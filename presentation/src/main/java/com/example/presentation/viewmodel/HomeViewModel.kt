package com.example.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.domain.EntityWrapper
import com.example.domain.model.CompanyModel
import dagger.hilt.android.lifecycle.HiltViewModel
import com.example.domain.usecase.HomeUseCase
import com.example.domain.model.state.RankState
import com.example.domain.model.state.UserState
import com.example.domain.model.state.WishState
import com.example.domain.usecase.WishUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
  private val homeUseCase: HomeUseCase,
  private val wishUseCase: WishUseCase
) : ViewModel() {
  private val _rankState: MutableStateFlow<RankState> = MutableStateFlow(RankState.Loading)
  val rankState: StateFlow<RankState> = _rankState

  private val _userState: MutableStateFlow<UserState> = MutableStateFlow(UserState.Loading)
  val userState: StateFlow<UserState> = _userState

  private val _wishState: MutableStateFlow<WishState> = MutableStateFlow(WishState.Loading)
  val wishState: StateFlow<WishState> = _wishState


  init {
    getRankItemList()
    getUserInfo()
    getWishList()
  }

  private fun getWishList() {
    viewModelScope.launch {
      _wishState.value = WishState.Loading
      val result = wishUseCase.getWishList()
      _wishState.value = when (result) {
        is EntityWrapper.Success -> {
          WishState.Main(
            wishList = result.entity.toMutableList()
          )
        }

        is EntityWrapper.Fail -> {
          WishState.Failed(
            reason = result.error.message ?: "Unknown error"
          )
        }
      }
    }
  }

  private fun getRankItemList() {
    viewModelScope.launch {
      _rankState.value = RankState.Loading
      val rankItems = homeUseCase.getRankItemList()
      _rankState.value = when (rankItems) {
        is EntityWrapper.Success -> {
          RankState.Main(
            rankList = rankItems.entity
          )
        }

        is EntityWrapper.Fail -> {
          RankState.Failed(
            reason = rankItems.error.message ?: "Unknown Error"
          )
        }
      }
    }
  }

  private fun getUserInfo() {
    viewModelScope.launch {
      _userState.value = UserState.Loading
      val result = homeUseCase.getUserInfo()
      _userState.value = when (result) {
        200 -> {
          UserState.Main
        }

        400 -> {
          UserState.Fail
        }

        else -> {
          UserState.Fail
        }
      }
    }
  }

  fun resetUserState() {
    _userState.value = UserState.Loading
  }


}