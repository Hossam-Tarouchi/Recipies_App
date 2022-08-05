package com.example.foodrecipes.presentation.screens.home_screen

import com.example.foodrecipes.domain.model.FoodTypeList
import com.example.foodrecipes.presentation.navigation.FoodType

data class HomeScreenViewState (
    val foodList: List<FoodTypeList> = emptyList(),
    val isLoading: Boolean = false,
    val isImageLoading: Boolean = false,
    val currentTab: FoodType = FoodType.AllFoodType
)