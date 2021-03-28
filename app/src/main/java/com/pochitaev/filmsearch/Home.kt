package com.pochitaev.filmsearch

import android.os.Bundle
import android.transition.Scene
import android.transition.Slide
import android.transition.TransitionManager
import android.transition.TransitionSet
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnScrollListener
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.merge_home_screen_content.*
import java.util.*


@Suppress("DEPRECATION")
class HomeFragment : Fragment() {
    private lateinit var filmsAdapter: FilmListRecyclerAdapter


    val filmsList = listOf(
        Film("Attack on titans", R.drawable.attackontitans, "Загнанное в угол человечество доживает свои последние дни под гнётом титанов - таинственных созданий, терроризирующих человеческую расу. Выжившие ютятся за стенами крупного поселения с собственным правительством, представляющим последний оплот централизованной власти в мире.", isInFavorites = false),
        Film("BreakingBad",R.drawable.breaking,"«Во все тяжкие» рассказывает историю отчаявшегося школьного учителя химии Уолтера Уайта, который ради того, чтобы прокормить семью, решается на самые крайние меры.", isInFavorites = false),
        Film("Bridgerton",R.drawable.bridgerton,"Wealth, lust, and betrayal set against the backdrop of Regency-era England, seen through the eyes of the powerful Bridgerton family.", isInFavorites = false),
        Film("Fate: The Winx Saga",R.drawable.fate,"It follows Bloom as she adjusts to life in the Otherworld, where she must learn to control her dangerous magical powers.", isInFavorites = false),
        Film("Game of Thrones",R.drawable.got,"Nine noble families fight for control over the lands of Westeros, while an ancient enemy returns after being dormant for millennia.", isInFavorites = false),
        Film("Interstellar",R.drawable.inter,"A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.", isInFavorites = false),
        Film("Lupin",R.drawable.lupin,"Inspired by the adventures of Arsène Lupin, gentleman thief Assane Diop sets out to avenge his father for an injustice inflicted by a wealthy family.", isInFavorites = false),
        Film("Promising Young Woman",R.drawable.perspective,"A young woman, traumatized by a tragic event in her past, seeks out vengeance against those who crossed her path.", isInFavorites = false),
        Film("Soul",R.drawable.soul,"After landing the gig of a lifetime, a New York jazz pianist suddenly finds himself trapped in a strange land between Earth and the afterlife.", isInFavorites = false),
        Film("The Wolf of Wall Street",R.drawable.wolf,"Based on the true story of Jordan Belfort, from his rise to a wealthy stock-broker living the high life to his fall involving crime, corruption and the federal government.", isInFavorites = false))


    var isLoading = false
    val scrollListener = object: RecyclerView.OnScrollListener() {
        @Override
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            //какая позиция первого элемента
            val firstVisibleItems = (recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()


             if (firstVisibleItems == 0) {
                 search_view.isInvisible}
                 else search_view.isVisible
                    //ставим флаг, что мы попросили еще элементы

                }
            }








    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val scene = Scene.getSceneForLayout(home_fragment_root, R.layout.merge_home_screen_content, requireContext())
//Создаем анимацию выезда поля поиска сверху
            val searchSlide = Slide(Gravity.TOP).addTarget(R.id.search_view)
//Создаем анимацию выезда RV снизу
            val recyclerSlide = Slide(Gravity.BOTTOM).addTarget(R.id.main_recycler)
//Создаем экземпляр TransitionSet, который объединит все наши анимации
            val customTransition = TransitionSet().apply {
            //Устанавливаем время, за которое будет проходить анимация
            duration = 750
            //Добавляем сами анимации
            addTransition(recyclerSlide)
            addTransition(searchSlide) }



            TransitionManager.go(scene, customTransition)



        search_view.setOnClickListener {
            search_view.isIconified = false
        } //нажатие на поиск на всё поле
        search_view.setOnQueryTextListener(object : SearchView.OnQueryTextListener,  // Поиск логика и изменения адаптера
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            //Этот метод отрабатывает при нажатии кнопки "поиск" на софт клавиатуре
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }
            //Этот метод отрабатывает на каждое изменения текста
            override fun onQueryTextChange(newText: String): Boolean {
                //Если ввод пуст то вставляем в адаптер всю БД
                if (newText.isEmpty()) {
                    filmsAdapter.addItems(filmsList)
                    return true
                }
                //Фильтруем список на поискк подходящих сочетаний
                val result = filmsList.filter {
                    //Чтобы все работало правильно, нужно и запрос, и имя фильма приводить к нижнему регистру
                    it.title.toLowerCase(Locale.getDefault()).contains(newText.toLowerCase(Locale.getDefault()))
                }
                //Добавляем в адаптер
                filmsAdapter.addItems(result)
                return true
            }
        })



        //находим наш RV
        main_recycler.apply {
            main_recycler.setOnScrollListener(scrollListener)
            filmsAdapter = FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener{
                override fun click(film: Film) {
                    (requireActivity() as MainActivity).launchDetailsFragment(film)
                }
            })
            //Присваиваем адаптер
            adapter = filmsAdapter
            //Присвои layoutmanager
            layoutManager = LinearLayoutManager(requireContext())
            //Применяем декоратор для отступов
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)

        }
        //Кладем нашу БД в RV
        filmsAdapter.addItems(filmsList)

    }
}
