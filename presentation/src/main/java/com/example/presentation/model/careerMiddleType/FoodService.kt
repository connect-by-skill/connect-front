package com.example.presentation.model.careerMiddleType

enum class FoodService : CareerMiddleType {
  ETC {
    override fun toString(): String = "해당 없음"
  },
  SERVER_RESTAURANT {
    override fun toString(): String = "일반 음식점 서빙원"
  },
  PREPARER_FASTFOOD {
    override fun toString(): String = "패스트푸드 준비원"
  },
  SUPPORT_STAFF_GROUP_MEALS {
    override fun toString(): String = "단체 급식 보조원"
  },
  COOK_SNACKS {
    override fun toString(): String = "분식 조리사"
  },
  COOK_COMPANY_CAFETERIA {
    override fun toString(): String = "사업체 구내식당 급식 조리사"
  },
  COOK_HOSPITAL {
    override fun toString(): String = "병원 급식 조리사"
  },
  STAFF_OTHER_FOOD_SERVICE_HOSPITAL {
    override fun toString(): String = "기타 음식서비스 종사원(병원 배식원)"
  },
  BEVERAGE_PREPARER_BARISTA {
    override fun toString(): String = "음료 조리사(바리스타 포함)"
  },
  KITCHEN_ASSISTANT_RESTAURANT {
    override fun toString(): String = "주방 보조원(일반 음식점)"
  };

  companion object {
    fun fromString(string: String): FoodService? =
      FoodService.values().find { it.toString() == string }
  }

  abstract override fun toString(): String
}
