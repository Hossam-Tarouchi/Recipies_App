package com.example.foodrecipes.domain.use_case

import com.example.foodrecipes.core.util.Resource
import com.example.foodrecipes.domain.model.FoodTypeList
import com.example.foodrecipes.domain.repository.FoodRepository
import com.example.foodrecipes.presentation.navigation.FoodType
import kotlinx.coroutines.flow.Flow

class SearchFoodUC (
    private val foodRepository: FoodRepository
) {
    operator fun invoke(searchQuery: String, foodType: FoodType): Flow<Resource<List<FoodTypeList>>> {
        return foodRepository.searchFoodList(searchQuery, foodType)
    }
}