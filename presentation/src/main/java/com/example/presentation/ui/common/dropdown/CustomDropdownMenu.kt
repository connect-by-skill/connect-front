package com.example.presentation.ui.common.dropdown

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp

@Composable
fun <T> CustomDropdownMenu(
  controller: CustomDropdownMenuController<T>,
  offset: DpOffset = DpOffset(0.dp, 10.dp)
) {
  DropdownMenu(
    expanded = controller.expanded,
    onDismissRequest = controller::onDismissRequest,
    offset = offset,
  ) {
    controller.dropdownMenuItemList.forEach {
      DropdownMenuItem(
        text = {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = it.toString(), Modifier.weight(1f))
            Icon(
              imageVector = Icons.Rounded.Check,
              contentDescription = "Check Icon",
              tint = if (controller.currentValue == it) Color.Black else Color.Transparent,
              modifier = Modifier.padding(start = 16.dp)
            )
          }
        },
        onClick = { controller.onDropdownMenClicked(it) },
      )
    }
  }
}