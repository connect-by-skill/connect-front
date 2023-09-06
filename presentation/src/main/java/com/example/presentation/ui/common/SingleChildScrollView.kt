package com.example.presentation.ui.common

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable

@Composable
fun SingleChildScrollView(content: @Composable () -> Unit) {
  LazyColumn {
    item { content() }
  }
}