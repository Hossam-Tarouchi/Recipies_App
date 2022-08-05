package com.example.foodrecipes.presentation.screens.food_detail_screen.widget

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
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
import com.example.foodrecipes.domain.model.Step
import com.example.foodrecipes.presentation.screens.home_screen.HomeScreenViewModel
import com.example.foodrecipes.presentation.screens.util.AnimatedImageShimmer
import com.example.foodrecipes.ui.theme.BoxBackgroundColor
import com.example.foodrecipes.ui.theme.LinesColor
import com.example.foodrecipes.ui.theme.NavigationBackgroundColor
import com.example.foodrecipes.ui.theme.PlayBtnColor


@Composable
fun TutoItem(item: Step, isSelected: Boolean, onItemSelected:()->Unit){

    Row(modifier = Modifier
        .fillMaxWidth()) {
        val color =  BoxBackgroundColor
        val innerCircleColor = if (isSelected) NavigationBackgroundColor else BoxBackgroundColor

        Box(contentAlignment = Alignment.TopEnd, modifier = Modifier.padding(0.dp,0.dp, 0.dp, 0.dp).height(IntrinsicSize.Max)) {

            //Line
            Divider(
                color = BoxBackgroundColor,
                modifier = Modifier
                    .height(130.dp)
                    .align(Alignment.TopCenter)
                    .width(2.dp)
            )

            //Circle
            Canvas(modifier = Modifier
                .size(14.dp)
                .align(Alignment.TopStart)
                .border(
                    shape = CircleShape,
                    width = 4.dp,
                    color = color
                ),
                onDraw = {
                    drawCircle(color = innerCircleColor, radius = 10f)
                }
            )
        }
        Column(modifier = Modifier.padding(10.dp,0.dp)) {
            Text(text = item.prepareTime, modifier = Modifier.padding(0.dp,0.dp, 0.dp, 5.dp).offset(y=-4.dp), fontFamily = FontFamily.Serif, fontSize = 12.sp)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(BoxBackgroundColor)
                    .clickable(onClick = onItemSelected)
                    .padding(),


                ) {
                Row() {
                    Column(modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()) {
                        Text(modifier = Modifier.padding(10.dp, 15.dp, 5.dp,5.dp), text = item.name, fontFamily = FontFamily.Serif)
                        Text(modifier = Modifier.padding(10.dp, 0.dp, 5.dp,15.dp), text = item.step_name, fontFamily = FontFamily.Serif, fontSize = 12.sp)
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

    }

}

