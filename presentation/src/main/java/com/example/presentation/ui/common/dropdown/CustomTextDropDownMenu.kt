package com.example.presentation.ui.common.dropdown

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.FilterList
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp

@Composable
fun <T> CustomTextDropdownMenu(
  modifier: Modifier = Modifier,
  controller: CustomDropdownMenuController<T>,
  offset: DpOffset = DpOffset(0.dp, 10.dp),
) {
  Box(modifier = Modifier.border(1.dp, Color.Black, RoundedCornerShape(5.dp))) {
    Row(
      modifier = modifier
        .height(ButtonDefaults.MinHeight)
        .padding(horizontal = 10.dp, vertical = 5.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.SpaceBetween
    ) {
      Text(
        controller.currentValue.toString(),
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
      )
      Box {
        IconButton(
          onClick = controller.onClick ?: controller::onShowRequest,
          modifier = Modifier.size(24.dp),
        ) {
          Icon(
            Icons.Rounded.FilterList,
            "Search Btn",
          )
        }
        CustomDropdownMenu(controller, offset)
      }
    }
  }
}