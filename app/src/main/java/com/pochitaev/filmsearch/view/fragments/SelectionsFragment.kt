package com.pochitaev.filmsearch.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pochitaev.filmsearch.databinding.FragmentSelectionsBinding
import com.pochitaev.filmsearch.utils.AnimationHelper
import kotlinx.android.synthetic.main.fragment_selections.*

class SelectionsFragment : Fragment() {
    private lateinit var binding: FragmentSelectionsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSelectionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        AnimationHelper.performFragmentCircularRevealAnimation(selections_fragment_root, requireActivity(), 4)
    }
}