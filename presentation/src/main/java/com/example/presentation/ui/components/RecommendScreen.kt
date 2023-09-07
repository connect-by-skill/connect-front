package com.example.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.presentation.R
import com.example.presentation.theme.Padding
import com.example.presentation.theme.WhaleTheme
import com.example.presentation.theme.colors
import com.example.presentation.ui.common.RecommendItem
import com.example.presentation.viewmodel.RecommendViewModel

@Composable
fun RecommendScreen() {
  val viewModel = hiltViewModel<RecommendViewModel>()
  Column(
    modifier = Modifier
      .background(MaterialTheme.colors.surface)
      .fillMaxSize()
      .padding(Padding.extra)
  ) {
    Text(
      text = "추천",
      style = MaterialTheme.typography.headlineSmall
    )
    LazyColumn(
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.spacedBy(Padding.medium),
      modifier = Modifier.fillMaxWidth(),
    ) {
      item { Spacer(modifier = Modifier.height(Padding.xlarge)) }
      items(viewModel.recommendList) { item ->
        RecommendItem(
          id = item.id,
          color = if (item.id % 2 == 1) MaterialTheme.colors.background else MaterialTheme.colors.secondary,
          company = item.company,
          occupation = item.occupation,
          recommendReason = item.recommendReason,
          score = item.score,
          isWished = item.isWish,
          viewModel = viewModel
        )
      }
    }
  }
  Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomEnd) {
    FloatingActionButton(
      onClick = {
        viewModel.isResume.value = !viewModel.isResume.value
        if (viewModel.isResume.value) viewModel.getRecommendList()
        else viewModel.getWishListBaseRecommend()
      },
      shape = CircleShape,
      containerColor = MaterialTheme.colors.primary,
      contentColor = MaterialTheme.colors.surface,
      elevation = FloatingActionButtonDefaults.elevation(10.dp),
      modifier = Modifier
        .size(70.dp)
        .offset(x = (-10).dp, y = (-10).dp),
    ) {
      Image(
        painter = painterResource(id = if (viewModel.isResume.value) R.drawable.selected_clover else R.drawable.list),
        contentDescription = "리스트",
        modifier = Modifier.fillMaxSize(0.7f)
      )
    }
  }
}

@Preview
@Composable
fun RecommendScreenPreview() {
  WhaleTheme {
    RecommendScreen()
  }
}