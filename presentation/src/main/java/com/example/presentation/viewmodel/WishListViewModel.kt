package com.example.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.domain.EntityWrapper
import com.himanshoe.kalendar.KalendarEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import com.example.domain.model.CompanyModel
import com.example.domain.model.state.WishState
import com.example.domain.usecase.WishUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.datetime.LocalDate
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class WishListViewModel @Inject constructor(private val wishUseCase: WishUseCase) : ViewModel() {
    val eventList = mutableStateListOf<KalendarEvent>()

    private val _isChanged: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isChanged: StateFlow<Boolean> = _isChanged

    private val _wishState: MutableStateFlow<WishState> = MutableStateFlow(WishState.Loading)
    val wishState: StateFlow<WishState> = _wishState

    private lateinit var _navController: NavHostController


    fun changeWishStatus(isWish: Boolean, item: CompanyModel) {
        viewModelScope.launch {
            if (!isWish) {
                wishUseCase.addWishItem(item.id)
            } else {
                wishUseCase.deleteWishItem(item.id)
                Log.d("테스트", "위시리스트 삭제 요청")
                if(_wishState.value is WishState.Main){
                    (_wishState.value as WishState.Main).wishList.remove(item)
                    Log.d("테스트", "위시리스트에서 제거")
                }
            }
            _isChanged.value = !_isChanged.value
        }
    }

    fun getWishList() {
        viewModelScope.launch {
            _wishState.value = WishState.Loading
            val result = wishUseCase.getWishList()
            _wishState.value = when(result) {
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
            Log.d("위시리스트", _wishState.value.toString())
            if(_wishState.value is WishState.Main) {
                Timber.tag("위시리스트").d((_wishState.value as WishState.Main).wishList.toString())
            }
            updateEventList()
        }
    }


    private fun updateEventList() {
        eventList.clear()
        if(_wishState.value is WishState.Main){
            (_wishState.value as WishState.Main).wishList.forEach {
                eventList.add(KalendarEvent(LocalDate.parse(it.recruitmentPeriod), it.companyName, it.companyName))
            }
        }
    }
}