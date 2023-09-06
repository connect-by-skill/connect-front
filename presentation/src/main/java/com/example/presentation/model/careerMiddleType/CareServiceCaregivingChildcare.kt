package com.example.presentation.model.careerMiddleType

enum class CareServiceCaregivingChildcare : CareerMiddleType {
  ETC {
    override fun toString(): String = "해당 없음"
  },
  FACILITY_CAREGIVER {
    override fun toString(): String = "시설 요양보호사(노인요양사)"
  },
  DISABILITY_SUPPORT_WORKER {
    override fun toString(): String = "장애인 생활지도원(장애인활동보조원 포함)"
  };

  companion object {
    fun fromString(string: String): CareServiceCaregivingChildcare? =
      CareServiceCaregivingChildcare.values().find { it.toString() == string }
  }

  abstract override fun toString(): String
}
