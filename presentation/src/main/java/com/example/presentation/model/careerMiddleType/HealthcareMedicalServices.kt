package com.example.presentation.model.careerMiddleType

enum class HealthcareMedicalServices : CareerMiddleType {
  ETC {
    override fun toString(): String = "해당 없음"
  },
  MASSAGE_THERAPIST {
    override fun toString(): String = "안마사"
  },
  MEDICAL_SUPPORT_STAFF {
    override fun toString(): String = "의료 보조원"
  },
  REGISTERED_NURSE {
    override fun toString(): String = "일반 간호사"
  },
  OTHER_HEALTHCARE_MEDICAL_SERVICES {
    override fun toString(): String = "기타 보건·의료 서비스 종사원"
  },
  HOSPITAL_COORDINATOR {
    override fun toString(): String = "병원 코디네이터"
  },
  MEDICAL_RECORD_TECHNICIAN {
    override fun toString(): String = "의무기록사"
  };

  companion object {
    fun fromString(string: String): HealthcareMedicalServices? =
      HealthcareMedicalServices.values().find { it.toString() == string }
  }

  abstract override fun toString(): String
}
