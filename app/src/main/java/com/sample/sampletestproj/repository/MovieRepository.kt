package com.sample.sampletestproj.repository

import com.sample.sampletestproj.model.NetworkResult
import com.sample.sampletestproj.retrofit.RestApiServices
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieRepository  @Inject constructor(private val apiService: RestApiServices) {

    suspend fun getPopularMovies() = flow {
        emit(NetworkResult.Loading(true))
        val response = apiService.getMostPopularMovies()
        emit(NetworkResult.Success(response.items))
    }.catch { e ->
        emit(NetworkResult.Failure(e.message ?: "Unknown Error"))
    }
}