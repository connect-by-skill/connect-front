package com.example.presentation.model.careerMiddleType

enum class BeautyWeddingService : CareerMiddleType {
  ETC {
    override fun toString(): String = "해당 없음"
  },
  NAIL_ARTIST {
    override fun toString(): String = "네일 아티스트(손톱 관리사)"
  };

  companion object {
    fun fromString(string: String): BeautyWeddingService? =
      BeautyWeddingService.values().find { it.toString() == string }
  }

  abstract override fun toString(): String
}
