package com.pochitaev.filmsearch


import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.view.ContextThemeWrapper
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.pochitaev.filmsearch.App.LifeCycleListener
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onBackPressed() {
        val count = supportFragmentManager.backStackEntryCount
        super.onBackPressed()
        if (count == 1) {
             AlertDialog.Builder(ContextThemeWrapper(this, R.style.MyDialog ))
                .setTitle("Вы уверены что хотите выйти из нашего приложения?")
                .setIcon(R.drawable.exit)
                .setPositiveButton("Да, ухожу как предатель") { _, _ ->
                    finish()
                }
                .setNegativeButton("Нет, я с вами на веки") { _, _ ->
                    setContentView(R.layout.activity_main)
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
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_placeholder, HomeFragment())
            .addToBackStack(null)
            .commit()




        topAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.settings -> {
                    Toast.makeText(this, "Настройки", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        bottom_navigation.setOnNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.favorites -> {
                    supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.fragment_placeholder, FavoritesFragment())
                            .addToBackStack(null)
                            .commit()
                        true
                }
                R.id.watch_later -> {
                    Toast.makeText(this, "Посмотреть похже", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.selections -> {
                    Toast.makeText(this, "Подборки", Toast.LENGTH_SHORT).show()
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


}
