package com.example.thirtydaysapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.thirtydaysapp.R

data class Day(
    val dayNumber: Int,
    @StringRes val titleRes: Int,
    @StringRes val descriptionRes: Int,
    @DrawableRes val imageRes: Int
)

object DaysRepository {
    val days = listOf(
        Day(
            dayNumber = 1,
            titleRes = R.string.day1_title,
            descriptionRes = R.string.day1_description,
            imageRes = R.drawable.day1
        ),
        Day(
            dayNumber = 2,
            titleRes = R.string.day2_title,
            descriptionRes = R.string.day2_description,
            imageRes = R.drawable.day2
        ),
        Day(
            dayNumber = 3,
            titleRes = R.string.day3_title,
            descriptionRes = R.string.day3_description,
            imageRes = R.drawable.day3
        ),
        Day(
            dayNumber = 4,
            titleRes = R.string.day4_title,
            descriptionRes = R.string.day4_description,
            imageRes = R.drawable.day4
        ),
        Day(
            dayNumber = 5,
            titleRes = R.string.day5_title,
            descriptionRes = R.string.day5_description,
            imageRes = R.drawable.day5
        ),
        Day(
            dayNumber = 6,
            titleRes = R.string.day6_title,
            descriptionRes = R.string.day6_description,
            imageRes = R.drawable.day6
        ),
        Day(
            dayNumber = 7,
            titleRes = R.string.day7_title,
            descriptionRes = R.string.day7_description,
            imageRes = R.drawable.day7
        ),
        Day(
            dayNumber = 8,
            titleRes = R.string.day8_title,
            descriptionRes = R.string.day8_description,
            imageRes = R.drawable.day8
        ),
        Day(
            dayNumber = 9,
            titleRes = R.string.day9_title,
            descriptionRes = R.string.day9_description,
            imageRes = R.drawable.day9
        ),
        Day(
            dayNumber = 10,
            titleRes = R.string.day10_title,
            descriptionRes = R.string.day10_description,
            imageRes = R.drawable.day10
        )
    )
}
