package com.technical.test.macropay.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.technical.test.macropay.api.repositories.MoviesRepository
import com.technical.test.macropay.model.DataMovie
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {

    private val moviesRepository = MoviesRepository()

    private val _moviesList = MutableLiveData<List<DataMovie>>()
    val moviesList: LiveData<List<DataMovie>>
        get() = _moviesList

    init {
        downloadMovies()
    }

    private fun downloadMovies() {
        viewModelScope.launch {
            _moviesList.value = moviesRepository.downloadMovies()
        }
    }
}