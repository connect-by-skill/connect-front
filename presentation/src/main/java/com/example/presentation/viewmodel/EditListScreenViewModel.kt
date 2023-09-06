package com.example.presentation.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import com.example.presentation.ui.common.textField.CustomTextFieldController
import javax.inject.Inject

@HiltViewModel
class EditListScreenViewModel @Inject constructor() : ViewModel() {
  val customTextFieldController = CustomTextFieldController()
  val list = mutableListOf<String>()
  fun init(list: List<String>) {
    list.forEach {
      this.list.add(it)
    }
  }
  fun addListItem(value: String) {

  }
}