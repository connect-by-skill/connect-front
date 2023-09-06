package com.example.presentation.ui.common.dialog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.presentation.theme.Padding
import com.example.presentation.theme.Shapes
import com.example.presentation.theme.colors
import kgb.plum.presentation.ui.common.dialog.CustomDialogController

@Composable
fun CustomDialog(
  controller: CustomDialogController,
  header: @Composable () -> Unit,
  body: @Composable () -> Unit
) {
  if (controller.visible)
    Dialog(onDismissRequest = controller.onDismissRequest) {
      Surface(
        modifier = Modifier
          .width(300.dp)
          .heightIn(0.dp, 500.dp),
        shape = Shapes.large,
        color = MaterialTheme.colors.checked
      ) {
        Column(modifier = Modifier.padding(Padding.xlarge)) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = controller::close, modifier = Modifier.size(30.dp)) {
              Icon(Icons.Rounded.Close, "다이얼로그 닫기 버튼")
            }
            Spacer(modifier = Modifier.width(Padding.medium))
            header()
          }
          body()
        }
      }
    }
}