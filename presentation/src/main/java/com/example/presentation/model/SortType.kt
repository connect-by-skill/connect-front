package com.example.presentation.model

enum class SortType {
  DESC {
    override fun toString(): String = "최신순"
    override fun toQueryString(): String = "desc"
  },
  ASC {
    override fun toString(): String = "오래된순"
    override fun toQueryString(): String = "asc"
  };

  companion object {
    fun fromString(string: String): SortType = when (string) {
      "최신순" -> DESC
      "오래된순" -> ASC
      else -> DESC
    }
  }

  abstract override fun toString(): String

  abstract fun toQueryString(): String
}