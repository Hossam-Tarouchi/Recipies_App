package com.example.foodrecipes.fake_data

import com.example.foodrecipes.data.local.entity.FoodEntity

sealed class Coffee(
    val id : String,
    val name : String,
    val steps: Int,
    val saved: Boolean,
    val rating: String,
    val likedBy : List<String>,
    val prepareTime : Int,
    val imageUrl: String
    ) {
    object FrenchCafe:Coffee("frenchCafe","French Cafe", 3, false, "4.5/6", listOf(), 1, "https://www.thespruceeats.com/thmb/Go7sX-7-oKpRzlK08SV8s9lCK6k=/566x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/FrenchCafeauLait-TheSpruce-NitaWest-3191a04832f7440fb107b5395824811d.jpg")
    object GrillePizza:Coffee("poCoffee","Pour-Over Coffee", 2, false, "5/6", listOf(), 2, "https://www.thespruceeats.com/thmb/69EilUEDLbXt4LET263fzTBPFPM=/566x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/Pour-OverCoffee-TheSpruce-SCDesignStudios-72362e26f4fb4a4b8f50d6efb3e3c551.jpg")
    object PepporoPizza:Coffee("cafecito","Cuban Coffee (Cafecito)", 2, false, "5/6", listOf(), 1, "https://www.thespruceeats.com/thmb/f10I3u7TYvtnvP1NVYjsyhc7hZE=/566x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/CubanCoffeeCafecito-TheSpruce-SCDesignStudios-0796109d00034afeb420c4649f90dd43.jpg")
    object Italiana:Coffee("affogato","Affogato", 2, false, "5/6", listOf(), 1, "https://www.thespruceeats.com/thmb/YAzF4GwHBkNntvmq-kGuTASZjIQ=/566x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/Affogato-007-6e41d6fd68a943a6b3518b9eb9d4a5e6.jpg")

    object coffees{
        val list= listOf(
            FrenchCafe, GrillePizza, PepporoPizza, Italiana
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
