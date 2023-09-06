package com.example.presentation.model.careerMiddleType

enum class ChemicalEnvironmentalInstallationMaintenanceProduction: CareerMiddleType {
  ETC {
    override fun toString(): String = "해당 없음"
  },
  METAL_MACHINE_COMPONENT_ASSEMBLER {
    override fun toString(): String = "금속기계부품 조립원"
  },
  OTHER_METAL_WORKING_MACHINE_OPERATOR {
    override fun toString(): String = "기타 금속공작기계 조작원 및 보조원"
  };

  companion object {
    fun fromString(string: String): ChemicalEnvironmentalInstallationMaintenanceProduction? =
      ChemicalEnvironmentalInstallationMaintenanceProduction.values().find { it.toString() == string }
  }

  abstract override fun toString(): String
}