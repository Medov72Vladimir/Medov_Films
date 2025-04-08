package com.medov.medov_films.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.medov.medov_films.R
import com.medov.medov_films.databinding.FragmentWatchlaterBinding
import com.medov.medov_films.utils.AnimationHelper

class WatchLaterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentWatchlaterBinding.inflate(inflater, container, false)
        return binding.watchLaterFragmentRoot
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val watchLaterFragmentRoot: FrameLayout = view.findViewById(R.id.watch_later_fragment_root)
        AnimationHelper.performFragmentCircularRevealAnimation(watchLaterFragmentRoot, requireActivity(), 3)
    }

}