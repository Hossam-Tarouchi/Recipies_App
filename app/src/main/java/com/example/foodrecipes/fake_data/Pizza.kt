package com.example.foodrecipes.fake_data

import com.example.foodrecipes.data.FoodListDao
import com.example.foodrecipes.data.local.entity.FoodEntity
import com.example.foodrecipes.domain.model.FoodTypeList
import com.example.foodrecipes.domain.model.Step
import com.example.foodrecipes.presentation.navigation.FoodType

sealed class Pizza(
    val id : String,
    val name : String,
    val steps: Int,
    val saved: Boolean,
    val rating: String,
    val likedBy : List<String>,
    val prepareTime : Int,
    val imageUrl: String,
    val stepsList: List<Step>
){

    object ItalianPizza:Pizza("italianPizza","Italian Pizza", 6, false, "5/6", listOf(), 1, "https://cdn.pixabay.com/photo/2017/12/09/08/18/pizza-3007395_1280.jpg", Step.Steps.list)
    object GrillePizza:Pizza("grillePizza","Grille Pizza", 8, false, "5/6", listOf(), 2, "https://cdn.pixabay.com/photo/2017/09/30/15/10/plate-2802332_1280.jpg", Step.Steps.list)
    object PepporoPizza:Pizza("pepporoPizza","Pepporo Pizza", 10, false, "5/6", listOf(), 1, "https://cdn.pixabay.com/photo/2016/06/08/00/03/pizza-1442946_1280.jpg" , Step.Steps.list)
    object Italiana:Pizza("italianPizza","Italian Pizza", 6, false, "5/6", listOf(), 1, "https://cdn.pixabay.com/photo/2017/12/09/08/18/pizza-3007395_1280.jpg", Step.Steps.list)

    object pizzas{
        val list= listOf(
            ItalianPizza,
            GrillePizza,
            PepporoPizza,
            Italiana
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
    fun toFoodType2(): FoodTypeList {
        return FoodTypeList(
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
