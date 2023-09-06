package com.example.presentation.model.careerMiddleType

enum class MetalMaterialInstallationMaintenanceProduction: CareerMiddleType {
  ETC {
    override fun toString(): String = "해당 없음"
  },
  METAL_COMPONENT_ASSEMBLER {
    override fun toString(): String = "금속기계부품 조립원"
  },
  OTHER_METAL_MACHINE_OPERATOR_AND_ASSISTANT {
    override fun toString(): String = "기타 금속공작기계 조작원 및 보조원"
  };
  companion object {
    fun fromString(string: String): MetalMaterialInstallationMaintenanceProduction? =
      MetalMaterialInstallationMaintenanceProduction.values().find { it.toString() == string }
  }
}