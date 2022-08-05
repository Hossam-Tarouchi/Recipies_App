package com.example.foodrecipes.data.repository

import com.example.foodrecipes.core.util.Resource
import com.example.foodrecipes.data.FoodListDao
import com.example.foodrecipes.domain.model.FoodTypeList
import com.example.foodrecipes.domain.repository.FoodRepository
import com.example.foodrecipes.presentation.navigation.FoodType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class FoodRepositoryImpl(
    private val dao: FoodListDao
): FoodRepository {

    override fun getFoodList(foodType: FoodType): Flow<Resource<List<FoodTypeList>>> = flow {

        emit(Resource.Loading())

        try {
            emit(Resource.Success(data = dao.getFoodList(foodType).map { it.toFoodTypeList() }))
        } catch (e: Exception){
            emit(Resource.Error(e.message ?: ""))
        }
    }

    override fun searchFoodList(
        searchQuery: String,
        foodType: FoodType
    ): Flow<Resource<List<FoodTypeList>>> = flow {

        emit(Resource.Loading())
        val initialFoodList = dao.getFoodList(foodType)
        val finalFoodList = initialFoodList.filter { it.name.contains(searchQuery) }.map { it.toFoodTypeList() }

        try {
            emit(Resource.Success(data = finalFoodList))
        } catch (e: Exception){
            emit(Resource.Error(e.message ?: ""))
        }
    }
}