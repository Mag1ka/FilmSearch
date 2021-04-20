package com.pochitaev.filmsearch.view


import android.app.AlertDialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ContextThemeWrapper
import androidx.fragment.app.Fragment
import com.pochitaev.filmsearch.Film
import com.pochitaev.filmsearch.HomeFragment
import com.pochitaev.filmsearch.R
import com.pochitaev.filmsearch.databinding.ActivityMainBinding
import com.pochitaev.filmsearch.view.fragments.DetailsFragment
import com.pochitaev.filmsearch.view.fragments.FavoritesFragment
import com.pochitaev.filmsearch.view.fragments.SelectionsFragment
import com.pochitaev.filmsearch.view.fragments.WatchLaterFragment


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onBackPressed() {
        val count = supportFragmentManager.backStackEntryCount
        super.onBackPressed()
        if (count == 1) {
            AlertDialog.Builder(ContextThemeWrapper(this, R.style.MyDialog))
                .setTitle("Вы уверены что хотите выйти из нашего приложения?")
                .setIcon(R.drawable.exit)
                .setPositiveButton("Да, ухожу как предатель") { _, _ ->
                    finish()
                }
                .setNegativeButton("Нет, я с вами на веки") { _, _ ->
                    setContentView(binding.root)
                    supportFragmentManager
                        .beginTransaction()
                        .add(R.id.fragment_placeholder, HomeFragment())
                        .addToBackStack(null)
                        .commit()

                }
                .show()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initNavigation()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_placeholder, HomeFragment())
            .addToBackStack(null)
            .commit()




        binding.topAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.settings -> {
                    Toast.makeText(this, "Настройки", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }






    }
    private fun initNavigation() {
        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    val tag = "home"
                    val fragment = checkFragmentExistence(tag)
                    //В первом параметре, если фрагмент не найден и метод вернул null, то с помощью
                    //элвиса мы вызываем создание нвого фрагмента
                    changeFragment( fragment?: HomeFragment(), tag)
                    true
                }
                R.id.favorites -> {
                    val tag = "favorites"
                    val fragment = checkFragmentExistence(tag)
                    changeFragment( fragment?: FavoritesFragment(), tag)
                    true
                }
                R.id.watch_later -> {
                    val tag = "watch_later"
                    val fragment = checkFragmentExistence(tag)
                    changeFragment( fragment?: WatchLaterFragment(), tag)
                    true
                }
                R.id.selections -> {
                    val tag = "selections"
                    val fragment = checkFragmentExistence(tag)
                    changeFragment( fragment?: SelectionsFragment(), tag)
                    true
                }
                else -> false
            }
        }
    }
    fun launchDetailsFragment(film: Film) {
        //Создаем "посылку"
        val bundle = Bundle()
        //Кладем наш фильм в "посылку"
        bundle.putParcelable("film", film)
        //Кладем фрагмент с деталями в перменную
        val fragment = DetailsFragment()
        //Прикрепляем нашу "посылку" к фрагменту
        fragment.arguments = bundle

        //Запускаем фрагмент
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_placeholder, fragment)
            .addToBackStack(null)
            .commit()

    }
    private fun checkFragmentExistence(tag: String): Fragment? =
        supportFragmentManager.findFragmentByTag(tag)

    private fun changeFragment(fragment: Fragment, tag: String) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_placeholder, fragment, tag)
            .addToBackStack(null)
            .commit()
    }
}



