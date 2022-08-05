package com.example.foodrecipes.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.foodrecipes.presentation.screens.FavoriteScreen
import com.example.foodrecipes.presentation.screens.HomeScreen
import com.example.foodrecipes.presentation.screens.ProfileScreen
import com.example.foodrecipes.presentation.screens.SettingsScreen
import com.example.foodrecipes.presentation.screens.food_detail_screen.FoodDetailScreen

@Composable
fun Navigation(navController: NavHostController){
    NavHost(navController = navController, startDestination = "detail"){
        composable("home") { HomeScreen(navController) }
        composable("detail") { FoodDetailScreen(navController) }
        composable("favorite") { FavoriteScreen() }
        composable("profile") { ProfileScreen() }
        composable("settings") { SettingsScreen() }
    }
}