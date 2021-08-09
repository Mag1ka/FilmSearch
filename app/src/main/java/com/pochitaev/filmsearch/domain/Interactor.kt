package com.pochitaev.filmsearch.domain

import com.pochitaev.filmsearch.data.API
import com.pochitaev.filmsearch.data.MainRepository
import com.pochitaev.filmsearch.data.PreferenceProvider
import com.pochitaev.filmsearch.data.TmdbApi
import com.pochitaev.filmsearch.data.entity.Film
import com.pochitaev.filmsearch.data.entity.TmdbResults
import com.pochitaev.filmsearch.utils.Converter
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.BehaviorSubject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Interactor(private val repo: MainRepository, private val retrofitService: TmdbApi, private val preferences: PreferenceProvider) {
    var progressBarState: BehaviorSubject<Boolean> = BehaviorSubject.create()

    fun getFilmsFromApi(page: Int) {
        //Показываем ProgressBar
        progressBarState.onNext(true)
        //Метод getDefaultCategoryFromPreferences() будет нам получать при каждом запросе нужный нам список фильмов
        retrofitService.getFilms(getDefaultCategoryFromPreferences(), API.KEY, "ru-RU", page)
            .enqueue(object : Callback<TmdbResults> {
                override fun onResponse(call: Call<TmdbResults>, response: Response<TmdbResults>) {
                    val list = Converter.convertApiListToDTOList(response.body()?.tmdbFilms)
                    //Кладем фильмы в бд
                    //В случае успешного ответа кладем фильмы в БД и выключаем ProgressBar
                    Completable.fromSingle<List<Film>> {
                        repo.putToDb(list)
                    }
                        .subscribeOn(Schedulers.io())
                        .subscribe()
                    progressBarState.onNext(false)
                }

                override fun onFailure(call: Call<TmdbResults>, t: Throwable) {
                    //В случае провала выключаем ProgressBar
                    progressBarState.onNext(false)
                }
            })
    }

    //Метод для сохранения настроек
    fun saveDefaultCategoryToPreferences(category: String) {
        preferences.saveDefaultCategory(category)
    }

    //Метод для получения настроек
    fun getDefaultCategoryFromPreferences() = preferences.geDefaultCategory()

    fun getFilmsFromDB(): Observable<List<Film>> = repo.getAllFromDB()
    fun getSearchResultFromApi(search: String): Observable<List<Film>> = retrofitService.getFilmFromSearch(API.KEY, "ru-RU", search, 1)
        .map {
            Converter.convertApiListToDTOList(it.tmdbFilms)
        }
}