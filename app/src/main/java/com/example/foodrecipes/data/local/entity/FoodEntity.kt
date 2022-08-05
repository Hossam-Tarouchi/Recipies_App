package com.example.foodrecipes.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.foodrecipes.domain.model.FoodTypeList

@Entity
data class FoodEntity(
    @PrimaryKey
    val id : String,
    val name : String,
    val steps: Int,
    val saved: Boolean,
    val rating: String,
    val likedBy : List<String>,
    val prepareTime : Int,
    val imageUrl: String
) {
    fun toFoodTypeList(): FoodTypeList{
        return FoodTypeList(
            id, name, steps, saved, rating, likedBy, prepareTime, imageUrl
        )
    }
}
