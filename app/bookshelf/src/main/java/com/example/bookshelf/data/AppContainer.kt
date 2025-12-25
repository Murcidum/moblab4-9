package com.example.bookshelf.data

import com.example.bookshelf.data.network.BooksApi

/**
 * Контейнер зависимостей приложения
 */
interface AppContainer {
    val booksRepository: BooksRepository
}

/**
 * Реализация контейнера зависимостей
 */
class DefaultAppContainer : AppContainer {
    override val booksRepository: BooksRepository by lazy {
        DefaultBooksRepository(BooksApi.retrofitService)
    }
}
