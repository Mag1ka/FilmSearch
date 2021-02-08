package com.pochitaev.filmsearch

import FilmListRecyclerAdapter
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var filmsAdapter: FilmListRecyclerAdapter
    val filmsList = listOf(Film("Attack on titans", R.drawable.attackontitans, "Загнанное в угол человечество доживает свои последние дни под гнётом титанов - таинственных созданий, терроризирующих человеческую расу. Выжившие ютятся за стенами крупного поселения с собственным правительством, представляющим последний оплот централизованной власти в мире."),
            Film("BreakingBad", R.drawable.breaking, "«Во все тяжкие» рассказывает историю отчаявшегося школьного учителя химии Уолтера Уайта, который ради того, чтобы прокормить семью, решается на самые крайние меры."),
            Film("Bridgerton", R.drawable.bridgerton, "Wealth, lust, and betrayal set against the backdrop of Regency-era England, seen through the eyes of the powerful Bridgerton family."),
            Film("Fate: The Winx Saga", R.drawable.fate, "It follows Bloom as she adjusts to life in the Otherworld, where she must learn to control her dangerous magical powers."),
            Film("Game of Thrones", R.drawable.got, "Nine noble families fight for control over the lands of Westeros, while an ancient enemy returns after being dormant for millennia."),
            Film("Interstellar", R.drawable.inter, "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival."),
            Film("Lupin", R.drawable.lupin, "Inspired by the adventures of Arsène Lupin, gentleman thief Assane Diop sets out to avenge his father for an injustice inflicted by a wealthy family."),
            Film("Promising Young Woman", R.drawable.perspective, "A young woman, traumatized by a tragic event in her past, seeks out vengeance against those who crossed her path."),
            Film("Soul", R.drawable.soul, "After landing the gig of a lifetime, a New York jazz pianist suddenly finds himself trapped in a strange land between Earth and the afterlife."),
            Film("The Wolf of Wall Street", R.drawable.wolf, "Based on the true story of Jordan Belfort, from his rise to a wealthy stock-broker living the high life to his fall involving crime, corruption and the federal government."))


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main_recycler.apply {
            filmsAdapter = FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener {
                override fun click(film: Film) {}
            })
            //Присваиваем адаптер
            adapter = filmsAdapter
            //Присвои layoutmanager
            layoutManager = LinearLayoutManager(this@MainActivity)

            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }

        filmsAdapter.addItems(filmsList)


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
                    Toast.makeText(this, "Избранное", Toast.LENGTH_SHORT).show()
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


}