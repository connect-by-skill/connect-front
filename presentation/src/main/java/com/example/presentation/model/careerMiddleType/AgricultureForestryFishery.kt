package com.example.presentation.model.careerMiddleType

enum class AgricultureForestryFishery : CareerMiddleType {
  ETC {
    override fun toString(): String = "해당 없음"
  },
  LANDSCAPE_NURSERY {
    override fun toString(): String = "조경 식재원"
  },
  AGRICULTURAL_WORKER {
    override fun toString(): String = "농업 단순 종사원"
  },
  PLANT_CARETAKER {
    override fun toString(): String = "식물 관리원"
  },
  AGRICULTURE_FORESTRY_FISHERY_MANAGER {
    override fun toString(): String = "농림어업 및 기타 생산 관리자"
  };

  companion object {
    fun fromString(string: String): AgricultureForestryFishery? =
      AgricultureForestryFishery.values().find { it.toString() == string }
  }

  abstract override fun toString(): String
}
