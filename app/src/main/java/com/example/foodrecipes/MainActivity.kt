package com.example.foodrecipes

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.foodrecipes.presentation.navigation.CustomBottomNavigation
import com.example.foodrecipes.presentation.navigation.Navigation
import com.example.foodrecipes.presentation.navigation.Screen
import com.example.foodrecipes.ui.theme.FoodRecipesTheme
import com.example.foodrecipes.ui.theme.MainBackgroundColor
import com.example.foodrecipes.ui.theme.NavigationBackgroundColor
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            window.statusBarColor=MainBackgroundColor.toArgb()
            window.navigationBarColor=NavigationBackgroundColor.toArgb()

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                window.navigationBarDividerColor=MaterialTheme.colors.onBackground.copy(alpha = 0.1f).toArgb()
            }

            val currentScreen= mutableStateOf<Screen>(Screen.Home)

            FoodRecipesTheme {
                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background, modifier = Modifier.background(NavigationBackgroundColor)) {

                    Scaffold(
                        bottomBar = {
                            CustomBottomNavigation(currentScreenId = currentScreen.value.id) {
                                currentScreen.value=it
                                navController.navigate(it.id)
                            }
                        }
                    ) {
                        Navigation(navController = navController)
                    }

                }
            }


        }
    }
}