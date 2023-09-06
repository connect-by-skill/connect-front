package com.example.presentation.ui.components.myPage.userInfo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.presentation.theme.Padding
import com.example.presentation.theme.WhaleTheme

@Composable
fun UserInfoBody(
  disabilityType: String,
  address: String,
  email: String,
  phoneNumber: String,
  modifier: Modifier = Modifier
) {
  Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
    Row {
      UserInfoBodyVerticalItem(title = "장애 유형", value = disabilityType, modifier = Modifier.weight(1f))
      UserInfoBodyVerticalItem(title = "거주지", value = address, modifier = Modifier.weight(1f))
    }
    Spacer(modifier = Modifier.size(Padding.large))
    UserInfoBodyHorizontalItem(title = "이메일", value = email)
    Spacer(modifier = Modifier.size(Padding.large))
    UserInfoBodyHorizontalItem(title = "전화번호", value = phoneNumber)
  }
}

@Preview
@Composable
fun UserInfoBodyPreview() {
  WhaleTheme {
    Scaffold {
      it
      UserInfoBody(
        "청각 3급",
        "구미시",
        "qkrwnstlr@naver.com",
        "010 2630 4097"
      )
    }
  }
}
