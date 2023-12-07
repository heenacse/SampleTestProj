package com.sample.sampletestproj.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.sampletestproj.model.Movie
import com.sample.sampletestproj.model.NetworkResult
import com.sample.sampletestproj.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel  @Inject constructor(
    private val mainRepository: MovieRepository
): ViewModel() {
    private var _movieResponse = MutableLiveData<NetworkResult<List<Movie>>>()
    val movieResponse: LiveData<NetworkResult<List<Movie>>> = _movieResponse

    init {
        fetchAllMovies()
    }

    private fun fetchAllMovies() {
        viewModelScope.launch {
            mainRepository.getPopularMovies().collect {
                _movieResponse.postValue(it)
            }
        }
    }
}