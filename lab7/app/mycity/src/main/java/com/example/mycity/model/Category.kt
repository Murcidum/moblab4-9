package com.example.mycity.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Category(
    val id: Int,
    @StringRes val nameResId: Int,
    @DrawableRes val iconResId: Int,
    val description: String
)
