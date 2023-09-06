package com.example.presentation.model

enum class EducationType {
  MIDDLE {
    override fun toString(): String = "중졸"
  },
  HIGH {
    override fun toString(): String = "고졸"
  },
  COLLEGE {
    override fun toString(): String = "대졸"
  };

  companion object {
    fun fromString(string: String): EducationType = when (string) {
      "중졸" -> MIDDLE
      "고졸" -> HIGH
      "대졸" -> COLLEGE
      else -> MIDDLE
    }
  }

  abstract override fun toString(): String
}