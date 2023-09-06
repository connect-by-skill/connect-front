package com.example.presentation.ui.components.myPage.edit

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.presentation.theme.Padding
import com.example.presentation.ui.common.textField.CustomTextField
import com.example.presentation.ui.common.textField.CustomTextFieldController

@Composable
fun CertificationEditDialogHeader(textFieldController: CustomTextFieldController) {
  Row {
    CustomTextField(
      customTextFieldController = textFieldController,
      leadingIcon = Icons.Rounded.Search
    )
    Spacer(modifier = Modifier.width(Padding.large))
  }
}