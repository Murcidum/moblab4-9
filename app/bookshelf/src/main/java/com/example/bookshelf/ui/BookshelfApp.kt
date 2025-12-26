@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.bookshelf.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bookshelf.R
import com.example.bookshelf.ui.screens.BookshelfViewModel
import com.example.bookshelf.ui.screens.HomeScreen

/**
 * Главный composable приложения Bookshelf
 */
@Composable
fun BookshelfApp() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            BookshelfTopAppBar(
                scrollBehavior = scrollBehavior
            )
        }
    ) { innerPadding ->
        val bookshelfViewModel: BookshelfViewModel = 
            viewModel(factory = BookshelfViewModel.Factory)
        
        HomeScreen(
            bookshelfUiState = bookshelfViewModel.bookshelfUiState,
            retryAction = bookshelfViewModel::searchBooks,
            contentPadding = innerPadding,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

/**
 * Верхняя панель приложения с поиском
 */
@Composable
fun BookshelfTopAppBar(
    scrollBehavior: TopAppBarScrollBehavior,
    modifier: Modifier = Modifier
) {
    val bookshelfViewModel: BookshelfViewModel = 
        viewModel(factory = BookshelfViewModel.Factory)
    
    var searchText by remember { mutableStateOf(bookshelfViewModel.searchQuery) }
    val keyboardController = LocalSoftwareKeyboardController.current
    
    CenterAlignedTopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
            OutlinedTextField(
                value = searchText,
                onValueChange = { searchText = it },
                placeholder = {
                    Text(stringResource(R.string.search_books))
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = stringResource(R.string.search)
                    )
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions(
                    onSearch = {
                        if (searchText.isNotBlank()) {
                            bookshelfViewModel.searchBooks(searchText)
                            keyboardController?.hide()
                        }
                    }
                ),
                modifier = Modifier.fillMaxWidth(0.9f),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.surface,
                    unfocusedContainerColor = MaterialTheme.colorScheme.surface
                )
            )
        },
        modifier = modifier
    )
}
