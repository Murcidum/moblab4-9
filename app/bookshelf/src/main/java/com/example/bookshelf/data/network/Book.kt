package com.example.bookshelf.data.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Ответ от Google Books API
 */
@Serializable
data class BooksResponse(
    val items: List<Book> = emptyList()
)

/**
 * Модель книги из Google Books API
 */
@Serializable
data class Book(
    val id: String,
    val volumeInfo: VolumeInfo
)

/**
 * Информация о книге
 */
@Serializable
data class VolumeInfo(
    val title: String,
    val authors: List<String> = emptyList(),
    val imageLinks: ImageLinks? = null
)

/**
 * Ссылки на изображения обложки
 */
@Serializable
data class ImageLinks(
    @SerialName("thumbnail")
    val thumbnail: String? = null,
    @SerialName("smallThumbnail")
    val smallThumbnail: String? = null
) {
    /**
     * Возвращает HTTP URL вместо HTTPS для корректной работы
     */
    fun getHttpsImageUrl(): String? {
        return thumbnail?.replace("http://", "https://")
    }
}
