package com.example.bookshelf.data

import com.example.bookshelf.data.network.Book

/**
 * Интерфейс репозитория для получения данных о книгах
 */
interface BooksRepository {
    /**
     * Получить список книг по поисковому запросу
     */
    suspend fun getBooks(query: String): List<Book>
}
