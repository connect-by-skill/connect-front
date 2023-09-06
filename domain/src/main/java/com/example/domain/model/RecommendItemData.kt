package com.example.domain.model

data class RecommendItemData(
    val id: Int,
    val company: String,
    val occupation: String,
    val recommendReason: List<String>,
    val score: Double,
    val isWish: Boolean =false
)
