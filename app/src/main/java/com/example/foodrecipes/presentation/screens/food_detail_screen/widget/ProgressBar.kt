package com.example.foodrecipes.presentation.screens.food_detail_screen.widget

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodrecipes.ui.theme.BoxBackgroundColor
import com.example.foodrecipes.ui.theme.NavigationBackgroundColor

@Composable
fun StepsProgressBar(modifier: Modifier = Modifier, numberOfSteps: Int, currentStep: Int) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for (step in 0..numberOfSteps) {
            Step(
                modifier = Modifier.weight(1F),
                isCompete = step < currentStep,
                isCurrent = step == currentStep
            )
        }
    }
}

@Composable
fun Step(modifier: Modifier = Modifier, isCompete: Boolean, isCurrent: Boolean) {
    val color =  BoxBackgroundColor
    val innerCircleColor = if (isCurrent) NavigationBackgroundColor else BoxBackgroundColor

    Box(modifier = modifier, contentAlignment = Alignment.TopEnd) {

        //Line
        Divider(
            color = BoxBackgroundColor,
            modifier = Modifier
                .fillMaxHeight()
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
}

@Preview
@Composable
fun StepsProgressBarPreview() {
    val currentStep = remember { mutableStateOf(1) }
    StepsProgressBar(modifier = Modifier.fillMaxWidth(), numberOfSteps = 5, currentStep = currentStep.value)
}