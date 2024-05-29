package com.nhinhnguyenuit.jetpackcomposemovieapp.data.repository

import com.nhinhnguyenuit.jetpackcomposemovieapp.data.local.MovieDao
import com.nhinhnguyenuit.jetpackcomposemovieapp.data.local.MovieEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(
    private val movieDao: MovieDao
) {
    fun getAllMovies(): Flow<List<MovieEntity>> = movieDao.getAllMovies()

    suspend fun insertMovie(movie: MovieEntity){
        movieDao.insertMovie(movie)
    }

    suspend fun deleteMovie(movie: MovieEntity){
        movieDao.deleteMovie(movie)
    }
    suspend fun updateMovie(movie: MovieEntity){
        movieDao.updateMovie(movie)
    }
}