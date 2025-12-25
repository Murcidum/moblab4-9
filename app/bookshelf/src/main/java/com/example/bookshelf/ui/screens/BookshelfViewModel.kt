package com.example.bookshelf.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.bookshelf.BookshelfApplication
import com.example.bookshelf.data.BooksRepository
import com.example.bookshelf.data.network.Book
import kotlinx.coroutines.launch
import java.io.IOException

/**
 * UI состояния для экрана списка книг
 */
sealed interface BookshelfUiState {
    data class Success(val books: List<Book>) : BookshelfUiState
    object Error : BookshelfUiState
    object Loading : BookshelfUiState
}

/**
 * ViewModel для управления данными о книгах
 */
class BookshelfViewModel(
    private val booksRepository: BooksRepository
) : ViewModel() {
    
    var bookshelfUiState: BookshelfUiState by mutableStateOf(BookshelfUiState.Loading)
        private set
    
    var searchQuery by mutableStateOf("jazz")
        private set
    
    init {
        searchBooks()
    }
    
    /**
     * Выполнить поиск книг
     */
    fun searchBooks(query: String = searchQuery) {
        searchQuery = query
        viewModelScope.launch {
            bookshelfUiState = BookshelfUiState.Loading
            bookshelfUiState = try {
                val books = booksRepository.getBooks(query)
                BookshelfUiState.Success(books)
            } catch (e: IOException) {
                BookshelfUiState.Error
            } catch (e: Exception) {
                BookshelfUiState.Error
            }
        }
    }
    
    /**
     * Factory для создания ViewModel с зависимостями
     */
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] 
                    as BookshelfApplication)
                val booksRepository = application.container.booksRepository
                BookshelfViewModel(booksRepository = booksRepository)
            }
        }
    }
}
