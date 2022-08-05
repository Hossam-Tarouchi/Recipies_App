package com.example.foodrecipes.presentation.screens.food_detail_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Menu

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import coil.request.ImageRequest
import com.example.foodrecipes.R
import com.example.foodrecipes.fake_data.Pizza
import com.example.foodrecipes.presentation.screens.food_detail_screen.widget.StepsProgressBar
import com.example.foodrecipes.presentation.screens.food_detail_screen.widget.TutoItem
import com.example.foodrecipes.presentation.screens.home_screen.widgets.foodListItem
import com.example.foodrecipes.presentation.screens.util.AnimatedImageShimmer
import com.example.foodrecipes.ui.theme.*

@Composable
fun FoodDetailScreen(navController: NavHostController) {
    val selectedStep = remember {
        mutableStateOf("")
    }
        Scaffold(
            topBar = {
                     Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically,modifier = Modifier
                         .fillMaxWidth()
                         .height(100.dp)
                         .background(
                             MainBackgroundColor
                         )) {
                         IconButton(onClick = {navController.navigate("home")}) {
                             Icon(Icons.Filled.ArrowBack, "backIcon", tint = NavigationBackgroundColor)
                         }
                         Text(text = "Detail Screen", fontSize = 26.sp)
                         IconButton(onClick = {navController.navigate("home")}) {
                             Icon(painter = painterResource(id = R.drawable.ic_food_unsaved), "backIcon", tint = NavigationBackgroundColor)
                         }
                     }
            }, content = {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .background(MainBackgroundColor)
                    .padding(10.dp, 0.dp),
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    Card(backgroundColor = Color.Transparent, modifier = Modifier
                        .clip(
                            RoundedCornerShape(20.dp)
                        )
                        .shadow(30.dp)) {
                        Box( contentAlignment = Alignment.Center, modifier = Modifier
                            .fillMaxHeight(0.25f)
                            .fillMaxWidth(0.8f)
                            .clip(
                                RoundedCornerShape(20.dp)
                            )
                            .shadow(30.dp) ){
                            SubcomposeAsyncImage(
                                model = ImageRequest.Builder(LocalContext.current)
                                    .data("https://cdn.pixabay.com/photo/2017/12/09/08/18/pizza-3007395_1280.jpg")
                                    .error(R.drawable.error_placeholder)
                                    .build(),
                                contentScale = ContentScale.Crop,
                                contentDescription = "Image",
                                loading = {
                                    AnimatedImageShimmer()
                                },
                                success = {
                                    //state.isImageLoading
                                    SubcomposeAsyncImageContent()
                                    Card(
                                        modifier = Modifier.size(38.dp),
                                        shape = CircleShape,
                                        elevation = 2.dp,
                                        backgroundColor = PlayBtnColor
                                    ) {
                                        Image(
                                            painterResource(R.drawable.ic_play),
                                            contentDescription = "",
                                            contentScale = ContentScale.None,
                                            modifier = Modifier.fillMaxSize()

                                        )
                                    }
                                }
                            )

                        }
                    }
                    Spacer(modifier = Modifier.height(18.dp))
                    Row(modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround
                        ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(0.4f)
                                .clip(RoundedCornerShape(5.dp))
                                .background(if (false) NavigationBackgroundColor else BoxBackgroundColor)
                                .clickable(onClick = {}),


                            ){
                            Text(text = "Ingredients", modifier = Modifier
                                .padding(20.dp, 10.dp)
                                .align(Alignment.Center), fontFamily = FontFamily.Serif, color = if (false) MainBackgroundColor else NavigationBackgroundColor, fontSize = 14.sp)
                        }
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(0.7f)
                                .clip(RoundedCornerShape(5.dp))
                                .background(if (true) NavigationBackgroundColor else BoxBackgroundColor)
                                .clickable(onClick = {}),


                            ){
                            Text(text = "Tutorial", modifier = Modifier
                                .padding(20.dp, 10.dp)
                                .align(Alignment.Center), fontFamily = FontFamily.Serif, color = if (true) MainBackgroundColor else NavigationBackgroundColor, fontSize = 14.sp)
                        }
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Column(modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)) {
                        LazyColumn(modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 42.dp)){

                            items(Pizza.pizzas.list.get(0).stepsList){ item ->
                                TutoItem(item = item, item.id.equals(selectedStep.value)){
                                    selectedStep.value = item.id
                                    //navController.navigate("detail")
                                    //viewModel.handle(HomeScreenAction.FoodSelect(item))
                                }
                            }

                        }
                    }

                }
            })

}

