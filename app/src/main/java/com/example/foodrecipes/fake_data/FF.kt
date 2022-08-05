package com.example.foodrecipes.fake_data

import com.example.foodrecipes.data.local.entity.FoodEntity

sealed class FF(
    val id : String,
    val name : String,
    val steps: Int,
    val saved: Boolean,
    val rating: String,
    val likedBy : List<String>,
    val prepareTime : Int,
    val imageUrl: String
    ) {
    object CrispyFries:FF("crispyFries","Crispy French Fries", 3, false, "4.5/6", listOf(), 1, "https://www.seriouseats.com/thmb/Gm6J49wltvTCH2dXt039zkvGZLg=/880x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/__opt__aboutcom__coeus__resources__content_migration__serious_eats__seriouseats.com__2018__04__20180309-french-fries-vicky-wasik-15-5a9844742c2446c7a7be9fbd41b6e27d.jpg")
    object JohnsFries:FF("johnsFries","John's French Fries", 2, false, "5/6", listOf(), 2, "https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fimages.media-allrecipes.com%2Fuserphotos%2F8644609.jpg&w=596&h=596&c=sc&poi=face&q=60")
    object FingerChips:FF("fingerChips","Finger Chips", 2, false, "5/6", listOf(), 1, "https://www.vegrecipesofindia.com/wp-content/uploads/2021/04/french-fries-recipe-1.jpg")
    object HomemadeFries:FF("homemadeFries","Homemade French Fries", 2, false, "5/6", listOf(), 1, "https://thecozycook.com/wp-content/uploads/2018/10/Homemade-French-Fry-Recipe-.jpg")

    object ffs{
        val list= listOf(
            CrispyFries, JohnsFries, FingerChips, HomemadeFries
        )
    }

    fun toFoodType(): FoodEntity {
        return FoodEntity(
            id,
            name,
            steps,
            saved,
            rating,
            likedBy,
            prepareTime,
            imageUrl
        )
    }
}
