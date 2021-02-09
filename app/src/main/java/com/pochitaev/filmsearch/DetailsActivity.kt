package com.pochitaev.filmsearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)


        details_toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.details_favorites-> {
                    Snackbar.make(details_description, "Избранные", Snackbar.LENGTH_SHORT)
                        .show()
                    true

                }
                R.id.details_watch_later-> {
                    Snackbar.make(details_description, "Посмотреть позже", Snackbar.LENGTH_SHORT)

                        .show()
                    true

                }
                R.id.details_share-> {
                    Snackbar.make(details_description, "Поделиться", Snackbar.LENGTH_SHORT)

                        .show()
                    true

                }

                else -> false
            }

        }



        val film = intent.extras?.get("film") as Film

        details_toolbar.title = film.title
        details_poster.setImageResource(film.poster)
        details_description.text = film.description
    }

}