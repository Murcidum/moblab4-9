package com.example.mycity.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mycity.data.DataSource
import com.example.mycity.model.Category
import com.example.mycity.model.Place
import com.example.mycity.viewmodel.MyCityUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MyCityViewModel : ViewModel() {
    
    private val _uiState = MutableStateFlow(MyCityUiState(categories = DataSource.categories))
    val uiState: StateFlow<MyCityUiState> = _uiState.asStateFlow()

    fun selectCategory(category: Category) {
        val places = DataSource.getPlacesByCategory(category.id)
        _uiState.update { currentState ->
            currentState.copy(
                selectedCategory = category,
                places = places,
                selectedPlace = null,
                isShowingListPage = true
            )
        }
    }

    fun selectPlace(place: Place) {
        _uiState.update { currentState ->
            currentState.copy(
                selectedPlace = place
            )
        }
    }

    fun navigateToCategories() {
        _uiState.update { currentState ->
            currentState.copy(
                selectedCategory = null,
                selectedPlace = null,
                places = emptyList(),
                isShowingListPage = false
            )
        }
    }

    fun navigateToPlaceList() {
        _uiState.update { currentState ->
            currentState.copy(
                selectedPlace = null
            )
        }
    }
}
