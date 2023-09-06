package com.example.presentation.model.careerMiddleType

enum class FinanceInsurance : CareerMiddleType {
  ETC {
    override fun toString(): String = "해당 없음"
  },
  BANK_OFFICER {
    override fun toString(): String = "은행 사무원(출납창구 제외)"
  },
  OTHER_OFFICER {
    override fun toString(): String = "카드사·신협·새마을금고·할부사, 우체국(금융부문) 등 기타 사무원"
  };
  companion object {
    fun fromString(string: String): FinanceInsurance? =
      FinanceInsurance.values().find { it.toString() == string }
  }

  abstract override fun toString(): String
}
