package com.example.presentation.ui.components.recruit

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.domain.model.RecruitModel
import com.example.presentation.R
import com.example.presentation.theme.Padding
import com.example.presentation.theme.Shapes
import com.example.presentation.theme.colors
import com.example.presentation.ui.common.TagItem

@Composable
fun DetailHeader(recruitModel: RecruitModel, onWishChange: () -> Unit) {
  var isWished by remember { mutableStateOf(recruitModel.isWished) }

  Row(
    modifier = Modifier
      .fillMaxWidth()
      .background(color = MaterialTheme.colors.background)
      .padding(vertical = Padding.medium, horizontal = Padding.extra),
    verticalAlignment = Alignment.Top,
    horizontalArrangement = Arrangement.spacedBy(Padding.medium),
  ) {
    Image(
      modifier = Modifier
        .clip(Shapes.large)
        .size(100.dp).background(Color.White),
      contentScale = ContentScale.FillWidth,
      contentDescription = null,
      painter = painterResource(id = if(recruitModel.id % 3 == 0) R.drawable.company_gray else if(recruitModel.id % 3 == 1) R.drawable.company_black else R.drawable.company_white),
    )
    Column(
      modifier = Modifier
        .height(100.dp)
        .weight(1f),
      verticalArrangement = Arrangement.SpaceBetween,
      horizontalAlignment = Alignment.Start,
    ) {
      LazyRow(horizontalArrangement = Arrangement.spacedBy(Padding.medium)) {
        items(items = recruitModel.tag) {
          TagItem(tag = it, backgroundColor = MaterialTheme.colors.surface)
        }
      }
      Text(
        text = recruitModel.title,
        style = MaterialTheme.typography.displayMedium.copy(
          textAlign = TextAlign.Center,
          fontWeight = FontWeight.Bold
        )
      )
      Text(
        text = recruitModel.company,
        style = MaterialTheme.typography.displaySmall.copy(
          textAlign = TextAlign.Center,
          fontWeight = FontWeight.Bold,
          color = MaterialTheme.colors.textSubColor
        )
      )
    }
    IconButton(
      onClick = {
        onWishChange()
        isWished = !isWished
      }, modifier = Modifier
        .size(30.dp)
        .padding(end = Padding.large)
    ) {
      Icon(
        painter = if (!isWished) painterResource(id = R.drawable.clober) else painterResource(id = R.drawable.selected_clover),
        contentDescription = "찜하기",
        tint = if (isWished) MaterialTheme.colors.primary else MaterialTheme.colors.surface,
      )
    }
  }
}