package com.example.presentation.model.careerMiddleType

enum class SportsRecreation : CareerMiddleType {
  ETC {
    override fun toString(): String = "해당 없음"
  },
  PROFESSIONAL_ATHLETE {
    override fun toString(): String = "직업 운동선수"
  };

  companion object {
    fun fromString(string: String): SportsRecreation? =
      SportsRecreation.values().find { it.toString() == string }
  }

  abstract override fun toString(): String
}
