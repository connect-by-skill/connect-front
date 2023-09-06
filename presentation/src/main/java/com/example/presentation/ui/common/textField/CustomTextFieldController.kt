package com.example.presentation.ui.common.textField

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class CustomTextFieldController(
  private val onTextChangeCallback: () -> Unit = {},
  initText: String = "",
  val keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
) {
  var text by mutableStateOf(initText)

  fun onTextChange(value: String, callback: () -> Unit = onTextChangeCallback) {
    text = value
    println("CustomTexField : $text, $value")
    callback()
  }

  fun clearText() {
    text = ""
  }
}