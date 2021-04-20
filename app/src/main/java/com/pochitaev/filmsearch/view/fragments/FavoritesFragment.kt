package com.pochitaev.filmsearch.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.pochitaev.filmsearch.Film
import com.pochitaev.filmsearch.view.MainActivity
import com.pochitaev.filmsearch.view.rv_adapters.TopSpacingItemDecoration
import com.pochitaev.filmsearch.databinding.FragmentFavoritesBinding
import com.pochitaev.filmsearch.utils.AnimationHelper
import com.pochitaev.filmsearch.view.rv_adapters.FilmListRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_favorites.*

    class FavoritesFragment : Fragment() {
        private lateinit var binding: FragmentFavoritesBinding
        private lateinit var filmsAdapter: FilmListRecyclerAdapter

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            binding = FragmentFavoritesBinding.inflate(inflater, container, false)
            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            //Получаем список при транзакции фрагмента
            val favoritesList: List<Film> = emptyList()

            AnimationHelper.performFragmentCircularRevealAnimation(favorites_fragment_root, requireActivity(),2)

            binding.favoritesRecycler.apply {
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
            filmsAdapter.addItems(favoritesList)
        }
    }