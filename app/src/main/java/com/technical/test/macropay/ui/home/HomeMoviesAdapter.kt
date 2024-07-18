package com.technical.test.macropay.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.technical.test.macropay.api.BASE_URL
import com.technical.test.macropay.databinding.ItemMovieBinding
import com.technical.test.macropay.model.DataMovie

class HomeMoviesAdapter : ListAdapter<DataMovie, HomeMoviesAdapter.MovieViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<DataMovie>() {
        override fun areItemsTheSame(oldItem: DataMovie, newItem: DataMovie): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: DataMovie, newItem: DataMovie): Boolean {
            return oldItem.id == newItem.id
        }
    }

    private var onItemClickListener: ((DataMovie) -> Unit)? = null
    fun setOnItemClickListener(onItemClickListener: (DataMovie) -> Unit) {
        this.onItemClickListener = onItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context))
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(movieViewHolder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        movieViewHolder.bind(movie)
    }

    inner class MovieViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: DataMovie) {
            binding.ivMovieImage.load(BASE_URL.plus(movie.posterPath))

            binding.tvMovieName.text = movie.title
            binding.tvMovieScore.text = "Popularity ${movie.popularity}"

            binding.llRoot.setOnClickListener {
                onItemClickListener?.invoke(movie)
            }
        }
    }
}