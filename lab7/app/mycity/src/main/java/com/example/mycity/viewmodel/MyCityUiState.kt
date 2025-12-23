package com.example.mycity.viewmodel

import com.example.mycity.model.Category
import com.example.mycity.model.Place

data class MyCityUiState(
    val categories: List<Category> = emptyList(),
    val places: List<Place> = emptyList(),
    val selectedCategory: Category? = null,
    val selectedPlace: Place? = null,
    val isShowingListPage: Boolean = false
)
