package com.d121211010.NBA.ui.activities.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.d121211010.NBA.MyApplication
import com.d121211010.NBA.data.models.Nba
import com.d121211010.NBA.data.repository.NbaRepository
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface MainUiState {
    data class Success(val NbaRepository : List<Nba>) : MainUiState
    object Error : MainUiState
    object Loading : MainUiState
}

class MainViewModel(private val NbaRepository: NbaRepository): ViewModel() {

    // initial state
    var mainUiState: MainUiState by mutableStateOf(MainUiState.Loading)
        private set

    fun getNba() = viewModelScope.launch {
        mainUiState = MainUiState.Loading
        try {
            val result = NbaRepository.getNba()
            mainUiState = MainUiState.Success(result.data)
        } catch (e: IOException) {
            mainUiState = MainUiState.Error
        }
    }

    // block yg prtama dipanggil ktika ini dibuka
    init {
        getNba()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MyApplication)
                val NbaRepository = application.container.nbaRepository
                MainViewModel(NbaRepository)
            }
        }
    }
}