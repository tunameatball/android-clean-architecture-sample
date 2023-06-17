package com.kkh.clean_architecture_sample.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kkh.clean_architecture_sample.base.BaseViewModel
import com.kkh.domain.common.Resource
import com.kkh.domain.model.Location
import com.kkh.domain.usecase.location.GetLocationUseCase
import com.kkh.domain.usecase.movie.GetMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getMovieUseCase: GetMovieUseCase,
    private val getLocationUseCase: GetLocationUseCase
) : BaseViewModel() {

    private val _isLoading = MutableStateFlow(false)
    val isLoading get() = _isLoading.asStateFlow()

    private val _locations = MutableLiveData<List<Location>?>()
    val locations get() = _locations

    fun getMovie(query: String) {
        getMovieUseCase(query).onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _isLoading.value = true
                }

                is Resource.Success -> {
                    // todo data receive

                }

                is Resource.Error -> {
                    // todo show toast??
                    showToast(result.message ?: "Error")
                }
            }
        }.launchIn(viewModelScope)
    }

    fun getLocation(query: String) {
        getLocationUseCase(query).onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _isLoading.value = true
                }

                is Resource.Success -> {
                    _isLoading.value = false
                    _locations.value = result.data
                }

                is Resource.Error -> {
                    showToast(result.message ?: "Error")
                }
            }
        }.launchIn(viewModelScope)
    }
}