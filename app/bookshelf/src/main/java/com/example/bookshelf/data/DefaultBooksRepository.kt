package com.example.bookshelf.data

import com.example.bookshelf.data.network.Book
import com.example.bookshelf.data.network.BooksApiService

/**
 * Реализация репозитория для получения данных о книгах из сети
 */
class DefaultBooksRepository(
    private val booksApiService: BooksApiService
) : BooksRepository {
    
    override suspend fun getBooks(query: String): List<Book> {
        return booksApiService.getBooks(query).items
    }
}
