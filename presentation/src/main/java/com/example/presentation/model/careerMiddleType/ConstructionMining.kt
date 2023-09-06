package com.example.presentation.model.careerMiddleType

enum class ConstructionMining : CareerMiddleType {
  ETC {
    override fun toString(): String = "해당 없음"
  };

  companion object {
    fun fromString(string: String): ConstructionMining? =
      ConstructionMining.values().find { it.toString() == string }
  }

  override fun toString(): String = when (this) {
    ETC -> "해당 없음"
  }
}
