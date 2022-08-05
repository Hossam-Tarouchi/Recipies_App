package com.example.foodrecipes.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.foodrecipes.presentation.navigation.Navigation
import com.example.foodrecipes.presentation.screens.home_screen.HomeScreenAction
import com.example.foodrecipes.presentation.screens.home_screen.HomeScreenViewEvent
import com.example.foodrecipes.presentation.screens.home_screen.HomeScreenViewModel
import com.example.foodrecipes.presentation.screens.home_screen.widgets.*
import com.example.foodrecipes.presentation.screens.util.AnimatedShimmer
import com.example.foodrecipes.ui.theme.*
import kotlinx.coroutines.flow.collectLatest

@Composable
fun HomeScreen(navController: NavHostController) {

    val viewModel: HomeScreenViewModel = hiltViewModel()
    val state = viewModel.state.value



    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when(event) {
                is HomeScreenViewEvent.ShowSnackbar -> {
                    System.err.println(event)
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message
                    )
                }
            }
        }
    }

    Scaffold(scaffoldState = scaffoldState, isFloatingActionButtonDocked = true){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MainBackgroundColor)
                .padding(20.dp, 30.dp)
        ){
            Text(text = "Food Recipes", fontWeight = FontWeight.Bold, fontSize = 32.sp, fontFamily = FontFamily.Serif)
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = viewModel.searchQuery.value,
                onValueChange = viewModel::handleFoodSearch,
                modifier = Modifier
                    .fillMaxWidth(),
                textStyle = TextStyle(color = TextColor, fontSize = 18.sp, fontFamily = FontFamily.Serif),
                leadingIcon = {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = "",
                        modifier = Modifier
                            .padding(15.dp)
                            .size(24.dp)
                    )
                },
                placeholder = { Text(text = "Search...", fontFamily = FontFamily.Serif)},
                shape = RoundedCornerShape(5.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = BoxBackgroundColor,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier= Modifier
                    .padding(0.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                selectFoodTypeWidget(currentFoodType = state.currentTab){
                    //currentFoodType.value = it
                    viewModel.handle(HomeScreenAction.SwitchTab(it))
                }

            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = state.currentTab.title, fontWeight = FontWeight.Bold, fontFamily = FontFamily.Serif)
            Spacer(modifier = Modifier.height(16.dp))
            



            if(state.isLoading) {
                Column {
                    repeat(7) {
                        AnimatedShimmer()
                    }
                }
            } else{
                LazyColumn(modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 42.dp)){

                    items(state.foodList){ item ->
                        Spacer(modifier = Modifier.height(18.dp))
                        foodListItem(item = item){
                            navController.navigate("detail")
                            //viewModel.handle(HomeScreenAction.FoodSelect(item))
                        }
                    }

                }
            }



        }

    }


}