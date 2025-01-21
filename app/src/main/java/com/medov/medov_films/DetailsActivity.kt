package com.medov.medov_films

import android.os.Bundle
import android.widget.TextView
import android.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import com.google.android.material.appbar.CollapsingToolbarLayout

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)

        setFilmsDetails()
    }

    private fun setFilmsDetails() {

        val film = intent.extras?.get("film") as Film
        val detailTitle = findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout)
        val detailPoster = findViewById<AppCompatImageView>(R.id.details_poster)
        val detailDesc = findViewById<TextView>(R.id.details_description)

        detailTitle.title = film.title
        detailPoster.setImageResource(film.poster)
        detailDesc.text = film.description

    }
}
