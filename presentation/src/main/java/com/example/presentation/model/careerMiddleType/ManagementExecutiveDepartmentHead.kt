package com.example.presentation.model.careerMiddleType

enum class ManagementExecutiveDepartmentHead : CareerMiddleType {
  ETC {
    override fun toString(): String = "해당 없음"
  },
  CUSTOMER_SERVICE_MANAGER {
    override fun toString(): String = "각종 단체 및 기타 고객서비스 관리자"
  },
  ENVIRONMENTAL_CLEANING_MANAGER {
    override fun toString(): String = "환경·청소 관리자"
  },
  BUSINESS_SUPPORT_SERVICES_MANAGER {
    override fun toString(): String = "기타 경영지원 서비스 관리자"
  };

  companion object {
    fun fromString(string: String): ManagementExecutiveDepartmentHead? =
      ManagementExecutiveDepartmentHead.values().find { it.toString() == string }
  }

  abstract override fun toString(): String
}
