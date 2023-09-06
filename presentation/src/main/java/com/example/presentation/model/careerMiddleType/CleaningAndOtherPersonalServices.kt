package com.example.presentation.model.careerMiddleType

enum class CleaningAndOtherPersonalServices : CareerMiddleType {
  ETC {
    override fun toString(): String = "해당 없음"
  },
  SALES_OTHER_SIMPLE {
    override fun toString(): String = "기타 판매 단순 종사원(전단지배포, 벽보원, 물품 보관원)"
  },
  THEME_PARK_SERVICE_STAFF {
    override fun toString(): String = "테마파크 서비스원"
  },
  RECYCLING_WASTE_COLLECTOR {
    override fun toString(): String = "재활용품 및 폐기물 수거원"
  },
  HOTEL_CONDO_ACCOMMODATION_CLEANER {
    override fun toString(): String = "호텔·콘도·숙박시설 청소원(룸메이드,하우스키퍼)"
  },
  PARKING_MANAGEMENT_GUIDE {
    override fun toString(): String = "주차 관리·안내원"
  },
  LAUNDRY_WORKER {
    override fun toString(): String = "세탁원(다림질원)"
  },
  OTHER_SERVICE_SIMPLE {
    override fun toString(): String = "기타 서비스 단순종사원(사우나,찜질방 정리원 등)"
  },
  STORE_CLEANER {
    override fun toString(): String = "매장 정리원(매장 보조원)"
  },
  LIBRARY_ORGANIZER {
    override fun toString(): String = "도서 정리원"
  },
  ENVIRONMENTAL_CLEANER {
    override fun toString(): String = "환경 미화원"
  },
  CAR_WASHER_TRANSPORT_CLEANER {
    override fun toString(): String = "세차원 및 운송장비 청소원"
  },
  PARKING_INSPECTOR_SAFETY_PATROL {
    override fun toString(): String = "주차 단속원 및 안전 순찰원"
  },
  EXTERIOR_WINDOW_CLEANER {
    override fun toString(): String = "외벽 및 창문 청소원"
  };

  companion object {
    fun fromString(string: String): CleaningAndOtherPersonalServices? =
      CleaningAndOtherPersonalServices.values().find { it.toString() == string }
  }

  abstract override fun toString(): String
}
