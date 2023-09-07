package com.example.presentation.ui.common


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.presentation.R
import com.example.presentation.theme.Padding
import com.example.presentation.theme.colors
import com.example.presentation.viewmodel.RecommendViewModel

@Composable
fun RecommendItem(
  color: Color,
  id: Int,
  company: String,
  occupation: String,
  recommendReason: List<String>,
  score: Double,
  isWished: Boolean = false,
  viewModel: RecommendViewModel
) {
  Card(
    colors = CardDefaults.cardColors(color),
    elevation = CardDefaults.cardElevation(5.dp),
  ) {
    Column(
      modifier = Modifier
          .padding(Padding.medium)
          .fillMaxSize()
    ) {
      Row(
        verticalAlignment = Alignment.CenterVertically
      ) {
        Column() {
          Text(
            text = company,
            style = MaterialTheme.typography.headlineSmall
          )
          Text(
            text = occupation,
            style = MaterialTheme.typography.bodyMedium
          )
        }
        Spacer(modifier = Modifier.weight(1f))
        IconButton(
          onClick = { viewModel.changeWishStatus(isWished, id) }
        ) {
          Icon(
            painter = if (isWished) painterResource(id = R.drawable.clober) else painterResource(id = R.drawable.selected_clover),
            contentDescription = "찜하기",
            tint = MaterialTheme.colors.surface
          )
        }
      }
      Spacer(modifier = Modifier.size(24.dp))
      Box(
        modifier = Modifier
            .background(
                MaterialTheme.colors.surface,
                shape = RoundedCornerShape(topStartPercent = 6, topEndPercent = 6)
            )
            .fillMaxWidth()
            .padding(Padding.medium)
      ) {
        Column {
          recommendReason.forEach { item ->
            Row(
              verticalAlignment = Alignment.CenterVertically
            ) {
              Icon(
                painter = painterResource(id = R.drawable.thumb_up),
                contentDescription = "추천",
                tint = MaterialTheme.colors.primary,
                modifier = Modifier.size(24.dp),
              )
              Spacer(modifier = Modifier.size(6.dp))
              Text(
                text = item,
                style = MaterialTheme.typography.bodyMedium
              )
            }
          }
        }
      }
      Spacer(modifier = Modifier.size(6.dp))
      Box(
        modifier = Modifier
            .background(
                MaterialTheme.colors.surface,
                shape = RoundedCornerShape(bottomStartPercent = 12, bottomEndPercent = 12)
            )
            .height(40.dp)
            .fillMaxWidth()
            .padding(Padding.medium)
      ) {
        Row {
          Icon(
            painter = painterResource(id = if(score >= 6.0) R.drawable.happy else R.drawable.happiness),
            contentDescription = "추천",
            tint = MaterialTheme.colors.primary,
            modifier = Modifier.size(24.dp),
          )
          Spacer(modifier = Modifier.size(6.dp))
          Text(
            text = if(score >= 6.0) "높은 확률로 합격할 수 있어요!" else if(score == 0.0) "다른 사람들이 찜했어요!" else "도전 해볼만 해요!",
            style = MaterialTheme.typography.bodyMedium
          )
        }
      }
    }
  }
}



