package com.example.presentation.viewmodel

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.EntityWrapper
import com.example.domain.model.CareerModel
import com.example.domain.model.UserInfoModel
import com.example.domain.model.ResumeModel
import com.example.domain.model.state.MyPageState
import com.example.domain.usecase.MyPageUseCase
import com.example.presentation.model.CareerMajorType
import com.example.presentation.model.CertificationType
import com.example.presentation.model.EducationType
import com.example.presentation.model.MajorType
import com.example.presentation.model.PreferKeywordType
import com.example.presentation.model.WorkType
import com.example.presentation.ui.common.dropdown.CustomDropdownMenuController
import com.example.presentation.ui.common.textField.CustomTextFieldController
import dagger.hilt.android.lifecycle.HiltViewModel
import kgb.plum.presentation.ui.common.dialog.CustomDialogController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(private val myPageUseCase: MyPageUseCase) : ViewModel() {
  private val _resumeState: MutableStateFlow<MyPageState> = MutableStateFlow(MyPageState.Loading)
  val resumeState: StateFlow<MyPageState> = _resumeState

  fun resetResumeState() {
    _resumeState.value = MyPageState.Loading
    viewModelScope.launch {
      setResume(myPageUseCase.getResume())
    }
  }

  init {
    viewModelScope.launch {
      setResume(myPageUseCase.getResume())
    }
  }

  private fun setResume(result: EntityWrapper<ResumeModel>) {
    when (result) {
      is EntityWrapper.Success -> {
        _resumeState.value = MyPageState.Main(
          result.entity
        )
      }

      is EntityWrapper.Fail -> {
        _resumeState.value = MyPageState.Failed(
          reason = result.error.message ?: "Unknown error"
        )
      }
    }
  }

  fun saveResume(resumeModel: ResumeModel) {
    viewModelScope.launch {
      myPageUseCase.deleteResume()
      myPageUseCase.saveResume(resumeModel)
//      setResume(myPageUseCase.getResume())
    }
  }

  val userInfoModel: UserInfoModel =
    UserInfoModel("박준식", 25, "qkrwnstlr@naver.com", "구미시", "청각 3급")

  val resumeDialogController = CustomDialogController()
  val resumeMajorDropdownMenuController = CustomDropdownMenuController(
    MajorType.ETC,
    MajorType.values().toList(),
  )
  val resumeEducationDropdownMenuController = CustomDropdownMenuController(
    EducationType.MIDDLE,
    EducationType.values().toList(),
  )
  val resumeWorkTypeDropdownMenuController = CustomDropdownMenuController(
    WorkType.ETC,
    WorkType.values().toList(),
  )
  val preferJobDropdownMenuController = CustomDropdownMenuController(
    CareerMajorType.BUSINESS_ADMINISTRATION_CLERICAL,
    CareerMajorType.values().toList(),
  )
  val resumePreferIncomeTextFieldController =
    CustomTextFieldController(keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))

  val careerDialogController = CustomDialogController()
  val careerMajorDropdownMenuController = CustomDropdownMenuController(
    CareerMajorType.BUSINESS_ADMINISTRATION_CLERICAL,
    CareerMajorType.values().toList(),
  )
  val yearDropdownMenuController = CustomDropdownMenuController(
    1,
    listOf(1, 2, 3, 4, 5),
  )

  fun editResume(resumeModel: ResumeModel, preferJob: String) {
    resumeDialogController.close()
    _resumeState.value = MyPageState.Main(
      resumeModel = resumeModel.copy(
        major = resumeMajorDropdownMenuController.currentValue.toString(),
        education = resumeEducationDropdownMenuController.currentValue.toString(),
        preferIncome = resumePreferIncomeTextFieldController.text.toLong(),
        workType = resumeWorkTypeDropdownMenuController.currentValue.toString(),
        preferJob = preferJob,
      )
    )
  }

  val preferKeywordDialogController = CustomDialogController()
  val preferKeywordTextFieldController = CustomTextFieldController(::updatePreferKeywordList)
  private val _preferKeywordList = mutableStateListOf<PreferKeywordType>()
  val preferKeywordList: List<PreferKeywordType> = _preferKeywordList

  fun initPreferKeywordList() {
    _preferKeywordList.clear()
    preferKeywordTextFieldController.clearText()
    _preferKeywordList.addAll(PreferKeywordType.values())
  }

  private fun updatePreferKeywordList() {
    _preferKeywordList.clear()
    _preferKeywordList.addAll(PreferKeywordType.values().filter {
      it.toString().contains(preferKeywordTextFieldController.text)
    })
  }

  fun addPreferKeyword(resumeModel: ResumeModel, value: PreferKeywordType) {
    preferKeywordDialogController.close()
    val newPreferKeywords = resumeModel.preferKeywords.toMutableList()
    newPreferKeywords.add(value.toString())
    _resumeState.value = MyPageState.Main(
      resumeModel.copy(preferKeywords = newPreferKeywords)
    )
  }

  fun removePreferKeyword(resumeModel: ResumeModel, index: Int) {
    val newPreferKeywords = resumeModel.preferKeywords.toMutableList()
    newPreferKeywords.removeAt(index)
    _resumeState.value = MyPageState.Main(
      resumeModel.copy(preferKeywords = newPreferKeywords)
    )
  }

  val certificationDialogController = CustomDialogController()
  val certificationTextFieldController = CustomTextFieldController(::updateCertificationList)
  private val _certificationList = mutableStateListOf<CertificationType>()
  val certificationList: List<CertificationType> = _certificationList

  fun initCertificationList() {
    _certificationList.clear()
    certificationTextFieldController.clearText()
    _certificationList.addAll(CertificationType.values())
  }

  private fun updateCertificationList() {
    _certificationList.clear()
    _certificationList.addAll(CertificationType.values().filter {
      it.toString().contains(certificationTextFieldController.text)
    })
  }

  fun addCertification(resumeModel: ResumeModel, value: CertificationType) {
    certificationDialogController.close()
    val newCertifications = resumeModel.certifications.toMutableList()
    newCertifications.add(value.toString())
    _resumeState.value = MyPageState.Main(
      resumeModel.copy(certifications = newCertifications)
    )
  }

  fun removeCertification(resumeModel: ResumeModel, index: Int) {
    val newCertifications = resumeModel.certifications.toMutableList()
    newCertifications.removeAt(index)
    _resumeState.value = MyPageState.Main(
      resumeModel.copy(certifications = newCertifications)
    )
  }

  fun addCareer(resumeModel: ResumeModel, careerModel: CareerModel) {
    careerDialogController.close()
    val newCareers = resumeModel.careers.toMutableList()
    newCareers.add(careerModel)
    _resumeState.value = MyPageState.Main(
      resumeModel.copy(careers = newCareers)
    )
  }

  fun removeCareer(resumeModel: ResumeModel, index: Int) {
    val newCareers = resumeModel.careers.toMutableList()
    newCareers.removeAt(index)
    _resumeState.value = MyPageState.Main(
      resumeModel.copy(careers = newCareers)
    )
  }
}