package com.medov.medov_films.view.rv_adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.medov.medov_films.R
import com.medov.medov_films.domain.Film
import com.medov.medov_films.RatingDonutView
import com.medov.medov_films.data.ApiConstants

class FilmListRecyclerAdapter(private val clickListener: OnItemClickListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val items = mutableListOf<Film>()

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return FilmViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.film_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is FilmViewHolder -> {
                holder.bind(items[position])
                holder.itemView.findViewById<CardView>(R.id.item_container).setOnClickListener {
                    clickListener.click(items[position])
                }
            }
        }
    }

    fun addItems(list: List<Film>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun click(film: Film)
    }

    class FilmViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title = itemView.findViewById<TextView>(R.id.title)
        private val poster = itemView.findViewById<ImageView>(R.id.poster)
        private val description = itemView.findViewById<TextView>(R.id.description)
        private val ratingDonut = itemView.findViewById<RatingDonutView>(R.id.rating_donut)

        fun bind(film: Film) {
            title.text = film.title
            Glide.with(itemView)
                //Загружаем сам ресурс
                .load(ApiConstants.IMAGES_URL + "w342" + film.poster)
                //Центруем изображение
                .centerCrop()
                //Указываем ImageView, куда будем загружать изображение
                .into(poster)
            description.text = film.description
            ratingDonut.setProgress((film.rating * 10).toInt())
        }
    }
}