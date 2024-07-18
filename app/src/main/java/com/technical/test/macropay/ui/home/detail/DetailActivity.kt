package com.technical.test.macropay.ui.home.detail

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.technical.test.macropay.R
import com.technical.test.macropay.api.BASE_URL
import com.technical.test.macropay.databinding.ActivityDetailMovieBinding
import com.technical.test.macropay.model.DataMovie
import com.technical.test.macropay.utils.Constants.MOVIE

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movie = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent?.extras?.getParcelable(MOVIE, DataMovie::class.java)
        } else {
            intent?.extras?.getParcelable(MOVIE)
        }

        if (movie == null) {
            Toast.makeText(this, getString(R.string.error_open_detail_movie), Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        initView(movie)
    }

    private fun initView(movie: DataMovie) = with(binding) {
        ivMovieImage.load(BASE_URL.plus(movie.posterPath))
        tvMovieTitle.text = movie.title
        tvMovieDuration.text = movie.voteAverage.toString()
        tvMovieDateRelease.text= movie.releaseDate
        tvMovieClassification.text = movie.adult.toString()
        tvMovieGenre.text = movie.genreIds.toString()
        tvMovieDescription.text = movie.overview

    }

}