package com.example.presentation.ui.components.myPage.userInfo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Bookmark
import androidx.compose.material.icons.rounded.Dashboard
import androidx.compose.material.icons.rounded.Remove
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.presentation.theme.Padding
import com.example.presentation.theme.Typography
import com.example.presentation.theme.WhaleTheme
import com.example.presentation.theme.colors

@Composable
fun UserInfoBodyListItem(
  modifier: Modifier = Modifier,
  title: String,
  leading: ImageVector,
  valueList: List<String>,
  onAddButtonClicked: () -> Unit = {},
  onRemoveButtonClicked: (Int) -> Unit = {},
) {
  Column(modifier) {
    Row(verticalAlignment = Alignment.CenterVertically) {
      Icon(
        leading, "Edit Icon",
        modifier = Modifier.size(20.dp), MaterialTheme.colors.iconSubColor
      )
      Spacer(modifier = Modifier.width(Padding.medium))
      Text(
        text = title,
        style = Typography.displaySmall.copy(
          color = MaterialTheme.colors.textSubColor,
          fontWeight = FontWeight.Bold
        ),
        modifier = Modifier.weight(1f)
      )
      IconButton(
        onClick = onAddButtonClicked,
        modifier = Modifier
          .size(30.dp)
          .padding(end = Padding.large)
      ) {
        Icon(Icons.Rounded.Add, "Edit Icon")
      }
    }
    valueList.forEachIndexed { index, it ->
      Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
          Icons.Rounded.Dashboard, "Edit Icon",
          modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(Padding.medium))
        Text(
          text = it, style = Typography.displaySmall.copy(
            fontWeight = FontWeight.Bold
          )
        )
        Spacer(modifier = Modifier.weight(1f))
        IconButton(
          onClick = { onRemoveButtonClicked(index) }, modifier = Modifier
            .size(30.dp)
            .padding(end = Padding.large)
        ) {
          Icon(Icons.Rounded.Remove, "삭제 버튼")
        }
      }
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun UserInfoBodyListItemPreview() {
  WhaleTheme {
    Scaffold {
      it
      UserInfoBodyListItem(
        title = "보유 자격증",
        leading = Icons.Rounded.Bookmark,
        valueList = listOf<String>("정보 처리 기사", "정보 처리 기사", "정보 처리 기사")
      )
    }
  }
}