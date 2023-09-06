package com.example.presentation.model.careerMiddleType

enum class ManufacturingUnskilled : CareerMiddleType {
  ETC {
    override fun toString(): String = "해당 없음"
  },
  UNQUALIFIED_WORKER {
    override fun toString(): String = "제조 단순 종사원"
  };

  companion object {
    fun fromString(string: String): ManufacturingUnskilled? =
      ManufacturingUnskilled.values().find { it.toString() == string }
  }
}