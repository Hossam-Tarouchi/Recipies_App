package com.example.foodrecipes.presentation.navigation

import com.example.foodrecipes.R

sealed class FoodType(
    val id:String,
    val title:String,
    val icon: Int,
) {
    object AllFoodType:FoodType("all","All", R.drawable.food_type_all)
    object PizzaFoodType:FoodType("pizza","Pizza", R.drawable.food_type_pizza)
    object CoffeeFoodType:FoodType("coffee","Coffee", R.drawable.food_type_coffee)
    object FFFoodType:FoodType("ff","French fries", R.drawable.food_type_fries)

    object foodTypes{
        val list= listOf(
            AllFoodType, PizzaFoodType, CoffeeFoodType, FFFoodType
        )
    }
}
