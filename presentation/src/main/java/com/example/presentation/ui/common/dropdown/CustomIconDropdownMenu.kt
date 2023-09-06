package com.example.presentation.ui.common.dropdown

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun <T> CustomIconDropDownMenu(
  controller: CustomDropdownMenuController<T>,
  icon: ImageVector
) {
  Box {
    IconButton(onClick = controller::onShowRequest) {
      Icon(
        icon,
        "Search Btn"
      )
    }
    CustomDropdownMenu(controller)
  }
}
