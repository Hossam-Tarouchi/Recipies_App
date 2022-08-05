package com.example.foodrecipes.presentation.screens.home_screen

sealed class HomeScreenViewEvent {
    data class ShowSnackbar(val message: String): HomeScreenViewEvent()
}