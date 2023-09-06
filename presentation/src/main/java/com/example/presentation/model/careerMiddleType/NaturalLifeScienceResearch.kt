package com.example.presentation.model.careerMiddleType

enum class NaturalLifeScienceResearch : CareerMiddleType {
  ETC {
    override fun toString(): String = "해당 없음"
  },
  AGRICULTURE_RESEARCHER {
    override fun toString(): String = "농어업 연구원 및 기술자"
  };

  companion object {
    fun fromString(string: String): NaturalLifeScienceResearch? =
      NaturalLifeScienceResearch.values().find { it.toString() == string }
  }

  abstract override fun toString(): String
}
