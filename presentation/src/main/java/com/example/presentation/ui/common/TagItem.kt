package com.example.presentation.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.presentation.theme.Padding
import com.example.presentation.theme.Shapes
import com.example.presentation.theme.colors

@Composable
fun TagItem(
  modifier: Modifier = Modifier,
  backgroundColor: Color,
  borderColor: Color = backgroundColor,
  tag: String,
  onClick: (() -> Unit)? = null
) {
  Box(
    modifier = modifier
      .wrapContentSize()
      .clip(Shapes.extraLarge)
      .background(color = backgroundColor)
      .border(width = 1.dp, color = borderColor, shape = Shapes.extraLarge)
      .clickable(enabled = onClick != null, onClick = onClick ?: {})
  ) {
    Text(
      text = tag,
      color = MaterialTheme.colors.textSubColor,
      textAlign = TextAlign.Center,
      fontWeight = FontWeight.Bold,
      modifier = Modifier.padding(horizontal = Padding.medium, vertical = Padding.xSmall),
    )
  }
}