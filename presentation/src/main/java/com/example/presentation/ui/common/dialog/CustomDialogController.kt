package kgb.plum.presentation.ui.common.dialog

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class CustomDialogController(val onDismissRequest: () -> Unit = {}) {
  var visible by mutableStateOf(false)
  fun show(callback: () -> Unit = {}) {
    visible = true
    callback()
  }

  fun close(callback: () -> Unit = {}) {
    visible = false
    callback()
  }
}