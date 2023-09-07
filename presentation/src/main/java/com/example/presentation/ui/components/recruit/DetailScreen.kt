package com.example.presentation.ui.components.recruit

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.domain.model.CompanyModel
import com.example.domain.model.RecruitModel
import com.example.presentation.theme.Padding
import com.example.presentation.theme.colors
import com.example.presentation.viewmodel.DetailViewModel

@Composable
fun DetailScreen(companyModel: CompanyModel, navController: NavHostController, isRecruit: Boolean = true, isDetail: MutableState<Boolean>?=null) {
  val scrollState = rememberScrollState()
  val viewModel = hiltViewModel<DetailViewModel>()
  viewModel.init(navController)
  Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxHeight()) {
    Column(modifier = Modifier.verticalScroll(state = scrollState)) {
      IconButton(onClick = {
        if(isRecruit) viewModel.navigatePop() else {isDetail?.value = false}
      }) {
        Icon(Icons.Rounded.ArrowBack, "종료 버튼")
      }
      DetailHeader(
        recruitModel = RecruitModel(
          companyModel.id,
          "[${companyModel.typeOfEmployment}] ${companyModel.recruitmentType}",
          companyModel.companyName,
          listOf(companyModel.requiredEducation, companyModel.companyType),
          companyModel.addedWishlist,
          companyModel.registrationDate
        ),
        onWishChange = { viewModel.onIsWishedChange(companyModel) },
      )
      Spacer(modifier = Modifier.height(Padding.medium))
      DetailBody(companyModel)
    }
  }
}
