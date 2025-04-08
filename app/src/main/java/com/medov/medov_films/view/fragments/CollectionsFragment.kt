package com.medov.medov_films.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.medov.medov_films.R
import com.medov.medov_films.databinding.FragmentCollectionsBinding
import com.medov.medov_films.utils.AnimationHelper

class CollectionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentCollectionsBinding.inflate(inflater, container, false)
        return binding.collectionsFragmentRoot
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val collectionsFragmentRoot: FrameLayout = view.findViewById(R.id.collections_fragment_root)
        AnimationHelper.performFragmentCircularRevealAnimation(collectionsFragmentRoot, requireActivity(), 4)
    }

}