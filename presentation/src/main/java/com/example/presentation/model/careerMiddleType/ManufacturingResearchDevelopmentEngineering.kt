package com.example.presentation.model.careerMiddleType

enum class ManufacturingResearchDevelopmentEngineering : CareerMiddleType {
  ETC {
    override fun toString(): String = "해당 없음"
  },
  INDUSTRIAL_SAFETY_OFFICER {
    override fun toString(): String = "산업 안전원 및 위험물 관리원"
  },
  ELECTRICAL_ELECTRONIC_EQUIPMENT_DESIGNER {
    override fun toString(): String = "전기·전자 장비 제도사(캐드원)"
  },
  OTHER_DESIGNER {
    override fun toString(): String = "기타 제도사(캐드원)"
  },
  MECHANICAL_METAL_DESIGNER {
    override fun toString(): String = "기계·금속 제도사(캐드원)"
  };

  companion object {
    fun fromString(string: String): ManufacturingResearchDevelopmentEngineering? =
      ManufacturingResearchDevelopmentEngineering.values().find { it.toString() == string }
  }
}