package kgb.plum.presentation.model.careerMiddleType

import com.example.presentation.model.careerMiddleType.CareerMiddleType

enum class FoodProcessingProduction : CareerMiddleType {
  ETC {
    override fun toString(): String = "해당 없음"
  },
  FOOD_PROCESSING_WORKER {
    override fun toString(): String = "식품 분야 단순 종사원"
  },
  KIMCHI_SIDE_DISH_MANUFACTURING_WORKER {
    override fun toString(): String = "김치·밑반찬 제조 종사원"
  },
  RICE_CAKE_MANUFACTURING_WORKER {
    override fun toString(): String = "떡 제조원(한과 포함)"
  },
  CONFECTIONERY_BAKERY_WORKER {
    override fun toString(): String = "제과·제빵원"
  },
  OTHER_FOOD_PROCESSING_WORKER {
    override fun toString(): String = "기타 식품가공 종사원"
  };

  companion object {
    fun fromString(string: String): FoodProcessingProduction? =
      FoodProcessingProduction.values().find { it.toString() == string }
  }

  abstract override fun toString(): String
}
