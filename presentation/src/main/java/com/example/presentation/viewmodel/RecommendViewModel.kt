package com.example.presentation.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.EntityWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import com.example.domain.model.RecommendItemData
import com.example.domain.model.UserInfo
import com.example.domain.model.state.WishRecommendState
import com.example.domain.usecase.RecommendUseCase
import com.example.domain.usecase.WishUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecommendViewModel @Inject constructor(private val recommendUseCase: RecommendUseCase, private val wishUseCase: WishUseCase) : ViewModel()  {
    val recommendList = mutableStateListOf<RecommendItemData>()
    private val _wishListBaseRecommendState: MutableStateFlow<WishRecommendState> = MutableStateFlow(
        WishRecommendState.Loading)
    val wishListBaseRecommendState : StateFlow<WishRecommendState> = _wishListBaseRecommendState

    val isResume = mutableStateOf(true)

    init {
        getRecommendList()
    }

    fun getRecommendList() {
        viewModelScope.launch {
            val result = recommendUseCase.getRecommendList(UserInfo.userData?.email ?:"")
            if(result is EntityWrapper.Success) {
                recommendList.clear()
                recommendList.addAll(result.entity)
            }
        }
    }

    fun changeWishStatus(isWish: Boolean, id: Int){
        viewModelScope.launch {
            if(isWish){
                wishUseCase.addWishItem(id)
            }else{
                wishUseCase.deleteWishItem(id)
            }
        }
    }

    fun getWishListBaseRecommend(){
        viewModelScope.launch {
            _wishListBaseRecommendState.value = WishRecommendState.Loading
            val result = recommendUseCase.getWishListBaseRecommend(UserInfo.userData?.email ?:"")
            if(result is EntityWrapper.Success){
                recommendList.clear()
                recommendList.addAll(result.entity)
            }
        }
    }
}