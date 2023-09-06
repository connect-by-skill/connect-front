package com.example.domain.model

data class RecruitModel(
  val id: Int,
  val title: String,
  val company: String,
  val tag: List<String>,
  val isWished: Boolean,
  val dDay: String,
)