package com.example.foodrecipes.domain.repository

import com.example.foodrecipes.core.util.Resource
import com.example.foodrecipes.domain.model.FoodTypeList
import com.example.foodrecipes.presentation.navigation.FoodType
import kotlinx.coroutines.flow.Flow

interface FoodRepository {

    fun getFoodList(foodType: FoodType): Flow<Resource<List<FoodTypeList>>>

    fun searchFoodList(searchQuery: String, foodType: FoodType): Flow<Resource<List<FoodTypeList>>>

}