package com.example.presentation.model

enum class CertificationType {
  NURSE {
    override fun toString(): String = "간호사"
  },
  SOCIAL_WORKER {
    override fun toString(): String = "사회복지사"
  },
  LOGISTICS_MANAGER_TRADE_ENGLISH {
    override fun toString(): String = "물류관리사"
  },
  TRADE_ENGLISH {
    override fun toString(): String = "무역영어"
  },
  CAREGIVER {
    override fun toString(): String = "요양보호사"
  },
  BOILER_MECHANIC {
    override fun toString(): String = "보일러기능사"
  },
  HVAC_TECHNICIAN {
    override fun toString(): String = "공조냉동기계기능사"
  },
  DRIVER_LICENSE {
    override fun toString(): String = "자동차운전면허"
  },
  BARISTA_LEVEL2 {
    override fun toString(): String = "바리스타 2급"
  },
  BARISTA_LEVEL1 {
    override fun toString(): String = "바리스타 1급"
  };

  companion object {
    fun fromString(string: String): CertificationType? = values().find { it.toString() == string }
  }
}
