package com.medov.medov_films

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.medov.medov_films.databinding.FragmentFavoritesBinding

class FavoritesFragment : Fragment() {
    private lateinit var filmsAdapter: FilmListRecyclerAdapter
    private lateinit var binding: FragmentFavoritesBinding
    val favoritesList: MutableList<Film> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val favoritesList: MutableList<Film> = mutableListOf()

    }
}