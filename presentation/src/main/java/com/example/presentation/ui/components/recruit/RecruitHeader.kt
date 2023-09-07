package com.example.presentation.ui.components.recruit

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.presentation.model.SortType
import com.example.presentation.theme.Padding
import com.example.presentation.ui.common.dropdown.CustomDropdownMenuController
import com.example.presentation.ui.common.dropdown.CustomTextDropdownMenu
import com.example.presentation.ui.common.textField.CustomTextField
import com.example.presentation.ui.common.textField.CustomTextFieldController

@Composable
fun RecruitHeader(
  totalCount: Int,
  sortDropdownMenuController: CustomDropdownMenuController<SortType>,
  filterDropdownMenuController: CustomDropdownMenuController<String>,
  searchTextFieldController: CustomTextFieldController,
  addList: () -> Unit,
  modifier: Modifier = Modifier,
) {
  Column() {
    Row(
      modifier = modifier
        .height(ButtonDefaults.MinHeight), verticalAlignment = Alignment.CenterVertically
    ) {
      Text(text = "전체 ${1732}개")
      Spacer(modifier = Modifier.weight(1f))
      CustomTextDropdownMenu(
        controller = filterDropdownMenuController,
        modifier = Modifier.wrapContentSize()
      )
      Spacer(modifier = Modifier.width(Padding.medium))
      CustomTextDropdownMenu(
        controller = sortDropdownMenuController,
        modifier = Modifier.wrapContentSize()
      )
    }

    Spacer(modifier = Modifier.height(Padding.medium))

    Row(
      modifier = modifier
        .height(ButtonDefaults.MinHeight), verticalAlignment = Alignment.CenterVertically
    ) {
      CustomTextField(
        customTextFieldController = searchTextFieldController,
        Icons.Rounded.Search,
        modifier = Modifier.weight(6f)
      )
      Spacer(modifier = Modifier.width(Padding.medium))
      IconButton(onClick = addList, modifier = Modifier.weight(1f)) {
        Icon(Icons.Rounded.Search, "검색 버튼")
      }
    }
  }
}

//@Preview
//@Composable
//fun Preview() {
//  Surface(
//    modifier = Modifier.fillMaxSize(),
//    color = MaterialTheme.colorScheme.background
//  ) {
//    RecruitHeader(
//      0, CustomDropdownMenuController(
//        SortType.NEWEST,
//        SortType.values().toList(),
//      ), CustomDropdownMenuController(
//        "필터",
//        listOf("필터")
//      )
//    )
//  }
//}