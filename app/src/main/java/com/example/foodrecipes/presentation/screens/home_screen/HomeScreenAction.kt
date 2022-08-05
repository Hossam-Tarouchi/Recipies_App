package com.example.foodrecipes.presentation.screens.home_screen

import com.example.foodrecipes.domain.model.FoodTypeList
import com.example.foodrecipes.presentation.navigation.FoodType

sealed class HomeScreenAction {
    data class SwitchTab(val tab: FoodType): HomeScreenAction()
    data class FoodSelect(val food: FoodTypeList): HomeScreenAction()
    object FoodSearch: HomeScreenAction()
}