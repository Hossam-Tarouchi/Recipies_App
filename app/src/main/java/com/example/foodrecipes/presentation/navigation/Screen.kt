package com.example.foodrecipes.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val id:String,
    val title:String,
    val icon:ImageVector,
){



    object Home:Screen("home","Home",Icons.Outlined.Home)
    object Search:Screen("favorite","Favorite",Icons.Outlined.Favorite)
    object Profile:Screen("profile","Profile",Icons.Outlined.Person)
    object Settings:Screen("settings","Settings",Icons.Outlined.Settings)

    object Items{
        val list= listOf(
            Home,Search,Profile,Settings
        )
    }

}