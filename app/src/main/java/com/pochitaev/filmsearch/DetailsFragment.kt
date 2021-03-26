package com.pochitaev.filmsearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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



        val film = arguments?.get("film") as Film

        details_toolbar.title = film.title
        details_poster.setImageResource(film.poster)
        details_description.text = film.description
    }


}