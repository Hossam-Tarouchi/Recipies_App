package com.example.foodrecipes.domain.model

import com.example.foodrecipes.fake_data.Pizza

sealed class Step(
    val id : String,
    val food_id : String,
    val name : String,
    val step_name : String,
    val prepareTime : String,
    val imageUrl: String
){

    object step1: Step("step1italianPizza","italianPizza", "Introduction of Italian Pizza", "Intro", "5min","https://cdn.pixabay.com/photo/2017/12/09/08/18/pizza-3007395_1280.jpg")
    object step2: Step("step2italianPizza","italianPizza", "Prepare Pizza Dough", "Step 1", "15min - 20min","https://cdn.pixabay.com/photo/2017/12/09/08/18/pizza-3007395_1280.jpg")
    object step3: Step("step3italianPizza","italianPizza", "Prepare the Toppings", "Step2", "10min - 15min","https://cdn.pixabay.com/photo/2017/12/09/08/18/pizza-3007395_1280.jpg")
    object step4: Step("step4italianPizza","italianPizza", "Introduction of Italian Pizza", "Step3", "5min","https://cdn.pixabay.com/photo/2017/12/09/08/18/pizza-3007395_1280.jpg")

    object Steps{
        val list = listOf(
            step1, step2, step3, step4
        )
    }
}
