package com.example.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.domain.EntityWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import com.example.domain.model.CompanyModel
import com.example.domain.model.state.RecruitState
import com.example.domain.usecase.RecruitUseCase
import com.example.presentation.model.AddressTagType
import com.example.presentation.model.CompanyTagType
import com.example.presentation.model.EmploymentTagType
import com.example.presentation.model.ExperienceTagType
import com.example.presentation.model.SortType
import com.example.presentation.model.TagType
import com.example.presentation.ui.common.dropdown.CustomDropdownMenuController
import com.example.presentation.ui.common.textField.CustomTextFieldController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecruitViewModel @Inject constructor(private val recruitUseCase: RecruitUseCase) :
  ViewModel() {
  private lateinit var _navController: NavHostController

  private var page by mutableStateOf(0)

  private val _recruitState: MutableStateFlow<RecruitState> = MutableStateFlow(RecruitState.Loading)
  val recruitState: StateFlow<RecruitState> = _recruitState

  private val _isRefreshing = MutableStateFlow(false)
  val isRefreshing = _isRefreshing.asStateFlow()

  private val _filterList = mutableStateListOf<TagType>()
  val filterList: List<TagType> = _filterList

  var experienceTagType by mutableStateOf<TagType?>(null)
  var companyTagType by mutableStateOf<TagType?>(null)
  var employmentTagType by mutableStateOf<TagType?>(null)
  var addressTagType by mutableStateOf<TagType?>(null)

  val searchTextFieldController: CustomTextFieldController = CustomTextFieldController()
  // TODO : Search 시 controller.text 추가

  var isFilterOpen: Boolean by mutableStateOf(false)

  init {
    refreshRecruitList()
    _filterList.addAll(TagType.values())
  }

  fun init(navController: NavHostController) {
    this._navController = navController
  }

  fun refreshRecruitList(sort: String = "desc") {
    page = 0
    viewModelScope.launch {
      _isRefreshing.value = true
      addRecruitList(
        recruitUseCase.getRecruitList(
          experienceTagType?.toString(),
          companyTagType?.toString(),
          employmentTagType?.toString(),
          addressTagType?.toString(),
          searchTextFieldController.text,
          page++,
          sort
        )
      )
      _isRefreshing.value = false
    }
  }

  fun getRecruitList(sort: String = "desc") {
    viewModelScope.launch {
      addRecruitList(
        recruitUseCase.getRecruitList(
          experienceTagType?.toString(),
          companyTagType?.toString(),
          employmentTagType?.toString(),
          addressTagType?.toString(),
          searchTextFieldController.text,
          page++,
          sort
        )
      )
    }
  }

  private fun addRecruitList(result: EntityWrapper<List<CompanyModel>>) {
    when (result) {
      is EntityWrapper.Success -> {
        if (page == 1) {
          _recruitState.value = RecruitState.Main(
            result.entity
          )
        } else {
          val newRecruitList =
            if (_recruitState.value is RecruitState.Main) (_recruitState.value as RecruitState.Main).recruitList.toMutableList() else mutableListOf()
          newRecruitList.addAll(result.entity)
          _recruitState.value = RecruitState.Main(
            newRecruitList
          )
        }
      }

      is EntityWrapper.Fail -> {
        RecruitState.Failed(
          reason = result.error.message ?: "Unknown error"
        )
      }
    }
  }

  val sortDropdownMenuController = CustomDropdownMenuController(
    SortType.DESC,
    SortType.values().toList(),
  )

  val filterDropdownMenuController = CustomDropdownMenuController(
    "필터",
    listOf("필터"),
    onClick = ::setIsFilterOpen
  )

  fun onIsWishedChange(companyModel: CompanyModel) {
    viewModelScope.launch {
      recruitUseCase.changeIsWished(companyModel.id, companyModel.addedWishlist)
      companyModel.addedWishlist = !companyModel.addedWishlist
    }
  }

  fun showDetail(companyModel: CompanyModel) {
    _navController.currentBackStackEntry?.savedStateHandle?.set(
      key = "companyModel",
      value = companyModel
    )
    _navController.navigate("detail")
  }

  fun resetRecruitState() {
    _recruitState.value = RecruitState.Loading
  }

  fun updateIsFilterSelect(value: String) {
    val current = TagType.fromString(value)
    when (current.getMajorType()) {
      ExperienceTagType::class.java -> experienceTagType =
        if (experienceTagType == current) null else current

      CompanyTagType::class.java -> companyTagType =
        if (companyTagType == current) null else current

      EmploymentTagType::class.java -> employmentTagType =
        if (employmentTagType == current) null else current

      AddressTagType::class.java -> addressTagType =
        if (addressTagType == current) null else current
    }
  }

  fun setIsFilterOpen() {
    isFilterOpen = !isFilterOpen
  }
}
