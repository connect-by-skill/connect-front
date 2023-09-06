package com.example.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import dagger.hilt.android.lifecycle.HiltViewModel
import com.example.domain.model.CompanyModel
import com.example.domain.usecase.RecruitUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val recruitUseCase: RecruitUseCase) : ViewModel() {
  private lateinit var _navController: NavHostController

  fun init(navController: NavHostController) {
    _navController = navController
  }

  fun onIsWishedChange(companyModel: CompanyModel) {
    viewModelScope.launch {
      recruitUseCase.changeIsWished(companyModel.id, companyModel.addedWishlist)
      companyModel.addedWishlist = !companyModel.addedWishlist
    }
  }

  fun navigatePop() {
    _navController.navigateUp()
  }
}