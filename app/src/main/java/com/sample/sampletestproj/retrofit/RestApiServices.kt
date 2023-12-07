package com.sample.sampletestproj.retrofit

import com.sample.sampletestproj.model.MovieResponse
import retrofit2.http.GET

interface RestApiServices {
    @GET("API/MostPopularMovies/k_9v5jw2c1")
    suspend fun getMostPopularMovies() : MovieResponse
}