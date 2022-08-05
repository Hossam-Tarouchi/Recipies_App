package com.example.foodrecipes.domain.model

data class FoodTypeList(    val id : String,
                            val name : String,
                            val steps: Int,
                            val saved: Boolean,
                            val rating: String,
                            val likedBy : List<String>,
                            val prepareTime : Int,
                            val imageUrl: String)
