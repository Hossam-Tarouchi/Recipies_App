package com.example.foodrecipes.presentation.screens.home_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodrecipes.core.util.Resource
import com.example.foodrecipes.domain.use_case.GetFoodUC
import com.example.foodrecipes.domain.use_case.SearchFoodUC
import com.example.foodrecipes.fake_data.Coffee
import com.example.foodrecipes.fake_data.FF
import com.example.foodrecipes.fake_data.Pizza
import com.example.foodrecipes.presentation.navigation.FoodType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getFoodUC: GetFoodUC,
    private val searchFoodUC: SearchFoodUC
): ViewModel() {

    private val _searchQuery = mutableStateOf("")
    val searchQuery: State<String> = _searchQuery

    private val _state = mutableStateOf(HomeScreenViewState())
    val state: State<HomeScreenViewState> = _state

    private val _eventFlow = MutableSharedFlow<HomeScreenViewEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var job: Job? = null

    init {
    handleSwitchTab(HomeScreenAction.SwitchTab(FoodType.AllFoodType))
    }

    fun handle(action: HomeScreenAction){
        when(action){
            is HomeScreenAction.SwitchTab -> handleSwitchTab(action)
            is HomeScreenAction.FoodSelect -> handleFoodSelect(action)
            is HomeScreenAction.FoodSearch -> handleFoodSearch("")
        }
    }

    private fun handleSwitchTab(action: HomeScreenAction.SwitchTab) {
        job?.cancel()
        job = viewModelScope.launch {
            _state.value = state.value.copy(
                currentTab = action.tab,
                isLoading = true
            )
            delay(1000L)

            getFoodUC(action.tab).onEach { result ->
                when(result){
                    is Resource.Loading -> {
                        _state.value = state.value.copy(
                            isLoading = true
                        )
                    }
                    is Resource.Success -> {
                        result.data?.let {
                            _state.value = state.value.copy(
                                currentTab = action.tab,
                                foodList = it,
                                isLoading = false
                            )
                        }
                    }
                    is Resource.Error -> {}
                }
            }.launchIn(this)


        }

    }

    private fun handleFoodSelect(action: HomeScreenAction.FoodSelect){
        System.err.println("clicked")
        viewModelScope.launch {
            _eventFlow.emit(HomeScreenViewEvent.ShowSnackbar(
                (action.food.name + " was selected")
            ))
        }
    }

    fun handleFoodSearch(query: String){
        _searchQuery.value = query
        if (query.isBlank()){
            handleSwitchTab(HomeScreenAction.SwitchTab(_state.value.currentTab))
        } else {
            _state.value = state.value.copy(
                isLoading = true
            )
            job?.cancel()
            job = viewModelScope.launch {
                delay(2000L)
                searchFoodUC(query, _state.value.currentTab).onEach { result ->
                    when(result){
                        is Resource.Success -> {
                            result.data?.let {
                                _state.value = state.value.copy(
                                    foodList = it,
                                    isLoading = false
                                )
                            }
                        }
                        is Resource.Loading -> {
                            _state.value = state.value.copy(
                                isLoading = true
                            )
                        }
                        is Resource.Error -> {}
                    }
                }.launchIn(this)



            }
        }

    }
}