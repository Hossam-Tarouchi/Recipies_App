package com.example.foodrecipes.data

import androidx.room.Dao
import com.example.foodrecipes.data.local.entity.FoodEntity
import com.example.foodrecipes.fake_data.Coffee
import com.example.foodrecipes.fake_data.FF
import com.example.foodrecipes.fake_data.Pizza
import com.example.foodrecipes.presentation.navigation.FoodType

@Dao
class FoodListDao {

    fun getFoodList(foodType: FoodType): List<FoodEntity> {
        when(foodType){
            is FoodType.AllFoodType -> return Pizza.pizzas.list.map { it.toFoodType() } + Coffee.coffees.list.map { it.toFoodType() } + FF.ffs.list.map { it.toFoodType() }
            is FoodType.FFFoodType -> return FF.ffs.list.map { it.toFoodType() }
            is FoodType.CoffeeFoodType ->  return Coffee.coffees.list.map { it.toFoodType() }
            is FoodType.PizzaFoodType -> return Pizza.pizzas.list.map { it.toFoodType() }
        }
    }
}