package com.medov.medov_films

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.medov.medov_films.databinding.FragmentDetailsBinding
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
        favoritesList.add( Film(
            "ПРАВЕДНИК",
            R.drawable.poster_1,
            "Реальная история подвига советского партизана Николая Киселёва, которому удалось вывести за линию фронта более 200 евреев, спасая их от гитлеровцев. В 2005 году ему было присвоено звание Праведник народов мира. Об этих не самых известных событиях рассказывает пронзительная военная драма Сергея Урсуляка с Александром Яценко в главной роли."
        ))
        binding.favoritesRecycler
            .apply {
                filmsAdapter =
                    FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener {
                        override fun click(film: Film) {
                            (requireActivity() as MainActivity).launchDetailsFragment(film)
                        }
                    })

                adapter = filmsAdapter

                layoutManager = LinearLayoutManager(requireContext())

                val decorator = TopSpacingItemDecoration(8)
                addItemDecoration(decorator)
            }

        filmsAdapter.addItems(favoritesList)
    }
}