package com.medov.medov_films.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.medov.medov_films.R
import com.medov.medov_films.databinding.FragmentFavoritesBinding
import com.medov.medov_films.utils.AnimationHelper

class FavoritesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.favoritesFragmentRoot
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val favoritesFragmentRoot:FrameLayout = view.findViewById(R.id.favorites_fragment_root)

        AnimationHelper.performFragmentCircularRevealAnimation(favoritesFragmentRoot, requireActivity(), 2)

    }
}