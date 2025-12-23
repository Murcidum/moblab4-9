package com.example.mycity.ui

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mycity.ui.screens.CategoryListScreen
import com.example.mycity.ui.screens.PlaceDetailScreen
import com.example.mycity.ui.screens.PlaceListScreen
import com.example.mycity.viewmodel.MyCityViewModel
@Composable
fun MyCityApp(
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier,
    viewModel: MyCityViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    
    when {
        uiState.selectedPlace != null -> {
            PlaceDetailScreen(
                place = uiState.selectedPlace!!,
                onBackClick = { viewModel.navigateToPlaceList() }
            )
        }

        uiState.selectedCategory != null -> {
            PlaceListScreen(
                category = uiState.selectedCategory!!,
                places = uiState.places,
                onPlaceClick = { place -> viewModel.selectPlace(place) },
                onBackClick = { viewModel.navigateToCategories() }
            )
        }

        else -> {
            CategoryListScreen(
                categories = uiState.categories,
                onCategoryClick = { category -> viewModel.selectCategory(category) }
            )
        }
    }
}
