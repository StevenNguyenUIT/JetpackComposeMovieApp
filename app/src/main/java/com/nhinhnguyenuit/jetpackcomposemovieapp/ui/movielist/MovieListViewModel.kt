package com.nhinhnguyenuit.jetpackcomposemovieapp.ui.movielist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nhinhnguyenuit.jetpackcomposemovieapp.data.local.MovieEntity
import com.nhinhnguyenuit.jetpackcomposemovieapp.data.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val repository: MovieRepository
): ViewModel() {
    val movies: StateFlow<List<MovieEntity>> = repository.getAllMovies().stateIn(viewModelScope,
        SharingStarted.Lazily, emptyList()
    )

    fun addMovie(title: String, description: String){
        viewModelScope.launch {
            repository.insertMovie(MovieEntity(title = title, description = description))
        }
    }

    fun deleteMovie(movie: MovieEntity){
        viewModelScope.launch {
            repository.deleteMovie(movie = movie)
        }
    }

    fun updateMovie(movie: MovieEntity){
        viewModelScope.launch {
            repository.updateMovie(movie = movie)
        }
    }

}