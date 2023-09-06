package com.example.presentation.model

enum class CompanyType {
  SMALL {
    override fun toString(): String = "중소기업"
  },
  MAJOR {
    override fun toString(): String = "대기업"
  };

  companion object {
    fun fromString(string: String): CompanyType = when (string) {
      "중소" -> SMALL
      "대기업" -> MAJOR
      else -> SMALL
    }
  }

  abstract override fun toString(): String
}