package com.example.mycity.model

import androidx.annotation.DrawableRes

data class Place(
    val id: Int,
    val name: String,
    val categoryId: Int,
    val address: String,
    val phone: String,
    val description: String,
    val rating: Double,
    @DrawableRes val imageResId: Int
)
