package com.pochitaev.filmsearch.view.fragments
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pochitaev.filmsearch.databinding.FragmentWatchLaterBinding
import com.pochitaev.filmsearch.utils.AnimationHelper
import kotlinx.android.synthetic.main.fragment_watch_later.*

class WatchLaterFragment : Fragment() {
    private lateinit var binding: FragmentWatchLaterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWatchLaterBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        AnimationHelper.performFragmentCircularRevealAnimation(watch_later_fragment_root, requireActivity(), 3)
    }
}