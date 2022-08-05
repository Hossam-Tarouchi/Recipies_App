package com.example.foodrecipes.presentation.screens.home_screen.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodrecipes.presentation.navigation.FoodType
import com.example.foodrecipes.presentation.navigation.Screen
import com.example.foodrecipes.ui.theme.BoxBackgroundColor
import com.example.foodrecipes.ui.theme.MainBackgroundColor
import com.example.foodrecipes.ui.theme.NavigationBackgroundColor


@Composable
fun selectFoodTypeWidget(
    currentFoodType:FoodType,
    onItemSelected:(FoodType)->Unit
){
    val items=FoodType.foodTypes.list
    items.forEach { item->
        selectFoodType(item = item, isSelected = item.id == currentFoodType.id) {
            onItemSelected(item)
        }

    }
}

@Composable
fun selectFoodType(item: FoodType, isSelected:Boolean, onClick:()->Unit){
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(5.dp))
            .background(if (isSelected) NavigationBackgroundColor else BoxBackgroundColor)
            .clickable(onClick = onClick),


        ){
        Column(
            modifier= Modifier
                .padding(10.dp, 10.dp, 10.dp, 5.dp)
                .width(40.dp)
                .height(55.dp)
            ,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {

            Icon(
                painter = painterResource(id = item.icon),
                contentDescription = null,
                tint = if (isSelected) MainBackgroundColor else Color.Black
            )

            Text(modifier = Modifier.padding(0.dp, 5.dp, 0.dp, 0.dp),
                text = item.title,
                fontWeight = FontWeight.Bold,
                fontSize = 9.sp,
                fontFamily = FontFamily.Serif,
                textAlign = TextAlign.Center,
                color = if (isSelected) MainBackgroundColor else Color.Black
            )
        }
    }
}