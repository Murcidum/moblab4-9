package com.example.mycity.data

import com.example.mycitymagnitogorsk.R
import com.example.mycity.model.Category
import com.example.mycity.model.Place

object DataSource {

    val categories = listOf(
        Category(
            id = 1,
            nameResId = R.string.category_restaurants,
            iconResId = R.drawable.on,
            description = "Лучшие рестораны и кафе города"
        ),
        Category(
            id = 2,
            nameResId = R.string.category_attractions,
            iconResId = R.drawable.shma,
            description = "Главные достопримечательности Магнитогорска"
        ),
        Category(
            id = 3,
            nameResId = R.string.category_parks,
            iconResId = R.drawable.shma,
            description = "Парки для отдыха и прогулок"
        ),
        Category(
            id = 4,
            nameResId = R.string.category_museums,
            iconResId = R.drawable.shma,
            description = "Музеи и культурные центры"
        )
    )

    val places = listOf(
        // Рестораны
        Place(
            id = 1,
            name = "Бар \"On\"",
            categoryId = 1,
            address = "просп. Карла Маркса, 172/1",
            phone = "+7 (2233) 44-55-66",
            description = "Описание1.",
            rating = 4.5,
            imageResId = R.drawable.on
        ),
        Place(
            id = 2,
            name = "Ресторан \"Хочу Буду\"",
            categoryId = 1,
            address = "Ресторан",
            phone = "+7 (2233) 44-55-66",
            description = "Описание2.",
            rating = 4.2,
            imageResId = R.drawable.budu
        ),
        Place(
            id = 3,
            name = "Ресторан \"Brooklyn Republic\"",
            categoryId = 1,
            address = "просп. Карла Маркса, 172/1",
            phone = "+7 (2233) 44-55-66",
            description = "Описание3.",
            rating = 4.3,
            imageResId = R.drawable.brooklyn
        ),
        
        // Достопримечательности
        Place(
            id = 4,
            name = "Памятник \"Тыл - Фронту\"",
            categoryId = 2,
            address = "адр1",
            phone = "",
            description = "Описание1.",
            rating = 5.0,
            imageResId = R.drawable.shma
        ),
        Place(
            id = 5,
            name = "Церковь Вознесения Господня",
            categoryId = 2,
            address = "адр2",
            phone = "+7 (2233) 44-55-66",
            description = "Описание2.",
            rating = 4.8,
            imageResId = R.drawable.shma
        ),
        Place(
            id = 6,
            name = "Магнитогорский металлургический комбинат",
            categoryId = 2,
            address = "адр3",
            phone = "+7 (2233) 44-55-66",
            description = "Описание3.",
            rating = 4.6,
            imageResId = R.drawable.shma
        ),
        
        // Парки
        Place(
            id = 7,
            name = "Парк имени А.С. Пушкина",
            categoryId = 3,
            address = "адр1",
            phone = "",
            description = "Описание1.",
            rating = 4.4,
            imageResId = R.drawable.shma
        ),
        Place(
            id = 8,
            name = "Экологический парк",
            categoryId = 3,
            address = "адр2",
            phone = "",
            description = "Описание2.",
            rating = 4.5,
            imageResId = R.drawable.shma
        ),
        Place(
            id = 9,
            name = "Набережная реки Урал",
            categoryId = 3,
            address = "адр3",
            phone = "",
            description = "Описание3.",
            rating = 4.6,
            imageResId = R.drawable.shma
        ),
        
        // Музеи
        Place(
            id = 10,
            name = "Магнитогорская картинная галерея",
            categoryId = 4,
            address = "адр1",
            phone = "+7 (2233) 44-55-66",
            description = "Описание1.",
            rating = 4.5,
            imageResId = R.drawable.shma
        ),
        Place(
            id = 11,
            name = "Краеведческий музей",
            categoryId = 4,
            address = "адр2",
            phone = "+7 (2233) 44-55-66",
            description = "Описание2.",
            rating = 4.3,
            imageResId = R.drawable.shma
        ),
        Place(
            id = 12,
            name = "Музей ММК",
            categoryId = 4,
            address = "адр3",
            phone = "+7 (2233) 44-55-66",
            description = "Описание3",
            rating = 4.4,
            imageResId = R.drawable.shma
        )
    )

    fun getPlacesByCategory(categoryId: Int): List<Place> {
        return places.filter { it.categoryId == categoryId }
    }

    fun getPlaceById(placeId: Int): Place? {
        return places.find { it.id == placeId }
    }

    fun getCategoryById(categoryId: Int): Category? {
        return categories.find { it.id == categoryId }
    }
}
