package com.example.presentation.model.careerMiddleType

enum class PrintingWoodCraftAndOtherInstallationMaintenanceProduction : CareerMiddleType {
  PRINTING_POST_PROCESSING_WORKER {
    override fun toString(): String = "인쇄 후가공원"
  },
  PRINTING_PLATE_FILM_OUTPUT_WORKER {
    override fun toString(): String = "인쇄판·인쇄필름 출력원"
  },
  PRINTING_WOOD_CRAFT_AND_OTHER_UNSKILLED_WORKER {
    override fun toString(): String = "인쇄, 목재, 가구 및 기타 제조 분야 단순 종사원"
  },
  ETC {
    override fun toString(): String = "해당 없음"
  };

  companion object {
    fun fromString(string: String): PrintingWoodCraftAndOtherInstallationMaintenanceProduction? =
      PrintingWoodCraftAndOtherInstallationMaintenanceProduction.values().find { it.toString() == string }
  }

  abstract override fun toString(): String
}
