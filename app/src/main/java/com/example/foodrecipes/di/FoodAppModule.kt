package com.example.foodrecipes.di

import com.example.foodrecipes.data.FoodListDao
import com.example.foodrecipes.data.repository.FoodRepositoryImpl
import com.example.foodrecipes.domain.repository.FoodRepository
import com.example.foodrecipes.domain.use_case.GetFoodUC
import com.example.foodrecipes.domain.use_case.SearchFoodUC
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FoodAppModule {
    @Provides
    @Singleton
    fun provideGetFoodUseCase(repository: FoodRepository):  GetFoodUC{
        return GetFoodUC(repository)
    }

    @Provides
    @Singleton
    fun provideSearchFoodUseCase(repository: FoodRepository):  SearchFoodUC{
        return SearchFoodUC(repository)
    }

    @Provides
    @Singleton
    fun provideFoodRepository(
    ): FoodRepository {
        return FoodRepositoryImpl(FoodListDao())
    }
}