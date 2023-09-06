package com.example.presentation.model

enum class WorkType {
  ETC {
    override fun toString(): String = "해당 없음"
  },
  FULL_TIME {
    override fun toString(): String = "상용직"
  },
  CONTRACT {
    override fun toString(): String = "계약직"
  },
  PART_TIME {
    override fun toString(): String = "시간제"
  };

  companion object {
    fun fromString(string: String): WorkType? =
      WorkType.values().find { it.toString() == string }
  }

  abstract override fun toString(): String
}