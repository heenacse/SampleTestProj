package com.sample.sampletestproj.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.sample.sampletestproj.R
import com.sample.sampletestproj.databinding.FragmentMovieListBinding
import com.sample.sampletestproj.model.NetworkResult
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MovieList : Fragment() {

    private var _binding: FragmentMovieListBinding?= null
    private val binding get()=_binding!!

    private lateinit var viewModel: MovieListViewModel

    @Inject
    lateinit var movieAdapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentMovieListBinding.inflate(inflater,container,false)
        binding.rvMovies.adapter = movieAdapter

        return _binding!!.root
        setObserver()
    }

    private fun setObserver() {
        viewModel.movieResponse.observe(viewLifecycleOwner){
            when(it) {
                is NetworkResult.Loading -> {
                    binding.progressbar.isVisible = it.isLoading
                }

                is NetworkResult.Failure -> {
                    //Toast.makeText(this, it.errorMessage, Toast.LENGTH_SHORT).show()
                    binding.progressbar.isVisible = false
                }

                is  NetworkResult.Success -> {
                    movieAdapter.updateMovies(it.data)
                    binding.progressbar.isVisible = false
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=ViewModelProvider(this).get(MovieListViewModel::class.java)
        binding.rvMovies.adapter = movieAdapter
    }


}