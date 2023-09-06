package com.example.presentation.model.careerMiddleType

enum class SalesAndRetail : CareerMiddleType {
  ETC {
    override fun toString(): String = "해당 없음"
  },
  TELEMARKETER {
    override fun toString(): String = "기타 텔레마케터"
  },
  ELECTRONICS_TECHNICAL_SALES {
    override fun toString(): String = "전기·전자장비 기술영업원"
  },
  FARE_SETTLEMENT_OFFICER {
    override fun toString(): String = "요금 정산원(주차요금,통행료)"
  },
  STORE_CASHIER {
    override fun toString(): String = "매장 계산원"
  },
  CONVENIENCE_STORE_SALES_CLERK {
    override fun toString(): String = "편의점 판매원"
  },
  TELEMARKETER_CALL_CENTER {
    override fun toString(): String = "텔레마케터(콜센터)"
  },
  CALL_CENTER_CONSULTANT {
    override fun toString(): String = "콜센터 상담원(콜센터·고객센터·CS센터)"
  },
  IT_TECHNICAL_SALES_COMPUTER {
    override fun toString(): String = "IT 기술영업원(전산장비,소프트웨어)"
  };

  companion object {
    fun fromString(string: String): SalesAndRetail? =
      SalesAndRetail.values().find { it.toString() == string }
  }

  abstract override fun toString(): String
}
