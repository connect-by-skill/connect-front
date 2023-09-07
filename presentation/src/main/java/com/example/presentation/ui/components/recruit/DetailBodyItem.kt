package com.example.presentation.ui.components.recruit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.presentation.theme.Padding
import com.example.presentation.theme.Typography
import com.example.presentation.theme.colors

@Composable
fun DetailBodyItem(title: String, value: String, modifier: Modifier = Modifier) {
  Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = modifier.padding(vertical = Padding.small).fillMaxWidth()) {
    Text(
      text = title,
      style = Typography.displayMedium.copy(
        color = MaterialTheme.colors.textSubColor, fontWeight = FontWeight.Bold,
      ),
      modifier = Modifier.weight(3f)
    )
    Text(
      text = value,
      style = Typography.displayMedium.copy(
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
      ),
      modifier = Modifier.weight(2f)
    )
  }
}