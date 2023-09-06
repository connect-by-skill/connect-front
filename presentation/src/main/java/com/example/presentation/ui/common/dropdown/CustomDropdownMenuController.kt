package com.example.presentation.ui.common.dropdown

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class CustomDropdownMenuController<T>(
  initValue: T,
  var dropdownMenuItemList: List<T>,
  val onDismissRequestCallBack: () -> Unit = {},
  val onClick: (() -> Unit)? = null
) {
  var expanded by mutableStateOf<Boolean>(false)
  var currentValue by mutableStateOf<T>(initValue)
  fun onShowRequest() {
    expanded = true
  }

  fun onDismissRequest() {
    expanded = false
    onDismissRequestCallBack()
  }

  fun onDropdownMenClicked(value: T) {
    currentValue = value
    onDismissRequest()
  }
}