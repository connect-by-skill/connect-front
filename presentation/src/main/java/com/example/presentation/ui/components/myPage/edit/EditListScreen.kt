package com.example.presentation.ui.components.myPage.edit

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Dashboard
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.presentation.theme.Padding
import com.example.presentation.theme.WhaleTheme
import com.example.presentation.ui.theme.Typography
import com.example.presentation.ui.common.textField.CustomTextField
import com.example.presentation.viewmodel.EditListScreenViewModel

@Composable
fun EditListScreen(list: List<String>) {
  val viewModel = hiltViewModel<EditListScreenViewModel>()
  viewModel.init(list)
  Column(modifier = Modifier.padding(Padding.medium)) {
    Row(verticalAlignment = Alignment.CenterVertically) {
      IconButton(onClick = { /*TODO*/ }, modifier = Modifier.size(30.dp)) {
        Icon(Icons.Rounded.ArrowBack, "뒤로가기 버튼")
      }
      Spacer(modifier = Modifier.width(Padding.medium))
      CustomTextField(
        customTextFieldController = viewModel.customTextFieldController,
        leadingIcon = Icons.Rounded.Search
      )
      Spacer(modifier = Modifier.width(Padding.large))
    }
    LazyColumn {
      items(items = viewModel.list) {
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
          IconButton(onClick = { viewModel.addListItem(it) }) {
            Icon(Icons.Rounded.Add, "추가 버튼")
          }
        }
      }
    }
  }
}

@Composable
@Preview
fun EditListScreenPreview() {
  WhaleTheme {
    Surface {
      EditListScreen(listOf("a", "b", "c"))
    }
  }
}