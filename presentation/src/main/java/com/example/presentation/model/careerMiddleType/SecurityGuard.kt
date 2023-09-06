package com.example.presentation.model.careerMiddleType

enum class SecurityGuard : CareerMiddleType {
  ETC {
    override fun toString(): String = "해당 없음"
  },
  SECURITY_MONITORING_OFFICER {
    override fun toString(): String = "보안 관제원(경비 관제원)"
  },
  APARTMENT_VILLA_SECURITY_OFFICER {
    override fun toString(): String = "아파트·빌라 경비원"
  },
  BUILDING_SECURITY_OFFICER {
    override fun toString(): String = "건물 경비원(청사,학교,병원,상가,빌딩,공장 등)"
  },
  OTHER_BUILDING_MANAGEMENT_OFFICER {
    override fun toString(): String = "기타 건물 관리원(공원, 종교시설 등)"
  };

  companion object {
    fun fromString(string: String): SecurityGuard? =
      SecurityGuard.values().find { it.toString() == string }
  }

  abstract override fun toString(): String
}
