package com.example.foodrecipes.presentation.screens.home_screen.widgets

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import coil.request.ImageRequest
import com.example.foodrecipes.R
import com.example.foodrecipes.fake_data.Coffee
import com.example.foodrecipes.domain.model.FoodTypeList
import com.example.foodrecipes.presentation.screens.home_screen.HomeScreenViewModel
import com.example.foodrecipes.presentation.screens.util.AnimatedImageShimmer
import com.example.foodrecipes.ui.theme.BoxBackgroundColor
import com.example.foodrecipes.ui.theme.LinesColor
import com.example.foodrecipes.ui.theme.PlayBtnColor


@Composable
fun foodListItem(item: FoodTypeList, onItemSelected:()->Unit){

    val viewModel: HomeScreenViewModel = hiltViewModel()
    val state = viewModel.state.value

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(110.dp)
            .clip(RoundedCornerShape(5.dp))
            .background(BoxBackgroundColor)
            .clickable(onClick =  onItemSelected ),


        ) {
        Row() {
            Column(modifier = Modifier
                .weight(1f)
                .fillMaxWidth()) {
                Text(modifier = Modifier.padding(10.dp, 15.dp, 5.dp,5.dp), text = "In ${item.steps} steps", fontFamily = FontFamily.Serif, fontSize = 12.sp)
                Text(modifier = Modifier.padding(10.dp, 0.dp, 5.dp,15.dp), text = "${item.name}", fontFamily = FontFamily.Serif)
                val pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
                Canvas(
                    Modifier
                        .fillMaxWidth()
                        .height(1.dp)) {

                    drawLine(
                        color = LinesColor,
                        start = Offset(0f, 0f),
                        end = Offset(size.width, 0f),
                        pathEffect = pathEffect
                    )
                }
                Text(modifier = Modifier.padding(10.dp, 10.dp, 5.dp,0.dp), text = "Rating ${item.rating}", fontFamily = FontFamily.Serif, fontSize = 12.sp)
            }
            Column(modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Card(backgroundColor = Color.Transparent) {
                    Box( contentAlignment = Alignment.Center,  ){
                        SubcomposeAsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(item.imageUrl)
                                .error(R.drawable.error_placeholder)
                                .build(),
                            contentScale = ContentScale.Crop,
                            contentDescription = "Image",
                            loading = {
                                AnimatedImageShimmer()
                            },
                            success = {
                                state.isImageLoading
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

                                    )}
                            }
                        )

                    }
                }

            }
        }
    }
}

