package com.nhinhnguyenuit.jetpackcomposemovieapp.di

import android.content.Context
import androidx.room.PrimaryKey
import androidx.room.Room
import com.nhinhnguyenuit.jetpackcomposemovieapp.data.local.MovieDao
import com.nhinhnguyenuit.jetpackcomposemovieapp.data.local.MovieDatabase
import com.nhinhnguyenuit.jetpackcomposemovieapp.data.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMovieDatabase(@ApplicationContext context: Context): MovieDatabase {
        return Room.databaseBuilder(
            context,
            MovieDatabase::class.java,
            "movies_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideMovieDao(movieDatabase: MovieDatabase) = movieDatabase.movieDao()

    @Provides
    @Singleton
    fun provideMovieRepository(movieDao: MovieDao) = MovieRepository(movieDao)
}