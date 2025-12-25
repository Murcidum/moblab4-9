package com.example.bookshelf.data.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://www.googleapis.com/books/v1/"

/**
 * Настройка JSON парсера с игнорированием неизвестных ключей
 */
private val json = Json {
    ignoreUnknownKeys = true
    coerceInputValues = true
}

/**
 * Retrofit экземпляр для Google Books API
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

/**
 * Интерфейс API для получения данных о книгах
 */
interface BooksApiService {
    /**
     * Получить список книг по поисковому запросу
     * @param query - поисковый запрос
     * @param maxResults - максимальное количество результатов
     */
    @GET("volumes")
    suspend fun getBooks(
        @Query("q") query: String,
        @Query("maxResults") maxResults: Int = 40
    ): BooksResponse
}

/**
 * Singleton объект для доступа к API
 */
object BooksApi {
    val retrofitService: BooksApiService by lazy {
        retrofit.create(BooksApiService::class.java)
    }
}
