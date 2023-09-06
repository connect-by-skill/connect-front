package com.example.presentation.ui.components.myPage.userInfo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.presentation.theme.colors
import com.example.presentation.ui.theme.Typography
import com.example.presentation.theme.WhaleTheme

@Composable
fun UserInfoBodyHorizontalItem(title: String, value: String, modifier: Modifier = Modifier) {
  Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = modifier.fillMaxWidth()) {
    Text(
      text = title,
      style = Typography.displaySmall.copy(
        color = MaterialTheme.colors.textSubColor, fontWeight = FontWeight.Bold,
      ),
      modifier = Modifier.weight(3f)
    )
    Text(
      text = value,
      style = Typography.displaySmall.copy(
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colors.textHighlightColor
      ),
      modifier = Modifier.weight(2f)
    )
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun UserInfoBodyHorizontalItemPreview() {
  WhaleTheme {
    Scaffold {
      it
      UserInfoBodyHorizontalItem(
        "이메일",
        "qkrwnstlr@naver.com"
      )
    }
  }
}
