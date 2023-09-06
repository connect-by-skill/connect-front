package com.example.presentation.ui.components.myPage.userInfo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.presentation.ui.theme.Typography
import com.example.presentation.theme.WhaleTheme
import com.example.presentation.theme.colors

@Composable
fun UserInfoBodyVerticalItem(title: String, value: String, modifier: Modifier = Modifier) {
  Column(modifier = modifier.fillMaxWidth()) {
    Text(
      text = title,
      style = Typography.displaySmall.copy(
        color = MaterialTheme.colors.textSubColor,
        fontWeight = FontWeight.Bold
      )
    )
    Text(text = value, style = Typography.displaySmall.copy(fontWeight = FontWeight.Bold))
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun UserInfoBodyVerticalItemPreview() {
  WhaleTheme {
    Scaffold {
      it
      UserInfoBodyVerticalItem(
        "장애 유형",
        "청각 3급"
      )
    }
  }
}