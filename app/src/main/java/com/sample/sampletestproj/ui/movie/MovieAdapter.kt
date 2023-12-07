package com.sample.sampletestproj.ui.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sample.sampletestproj.databinding.AdapterMovieBinding
import com.sample.sampletestproj.model.Movie
import javax.inject.Inject

class MovieAdapter  @Inject constructor() : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    var movies = mutableListOf<Movie>()

    fun updateMovies(movies: List<Movie>) {
        this.movies = movies.toMutableList()
        notifyItemRangeInserted(0, movies.size)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding =
            AdapterMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.view.tvTitle.text = movie.title
        holder.view.rvYear.text = "Year : ${movie.year}"
        holder.view.rvRating.text = "Rating : ${movie.imDbRating}"
        Glide
            .with(holder.view.imgMovieImage.context)
            .load(movie.image)
            .centerCrop()
            .into(holder.view.imgMovieImage)

    }

    override fun getItemCount(): Int {
        return movies.size
    }

    class MovieViewHolder(val view: AdapterMovieBinding) : RecyclerView.ViewHolder(view.root)
}