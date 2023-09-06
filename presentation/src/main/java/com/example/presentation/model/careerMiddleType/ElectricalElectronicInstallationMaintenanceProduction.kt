package com.example.presentation.model.careerMiddleType

enum class ElectricalElectronicInstallationMaintenanceProduction : CareerMiddleType {
  ETC {
    override fun toString(): String = "해당 없음"
  },
  OFFICE_EQUIPMENT_INSTALLATION_REPAIRER_EXCLUDING_COMPUTERS {
    override fun toString(): String = "사무용 전자기기 설치·수리원(컴퓨터 제외)"
  },
  ELECTRIC_COMPONENT_PRODUCT_MACHINE_OPERATOR {
    override fun toString(): String = "전기 부품·제품 생산기계 조작원"
  },
  OTHER_ELECTRICAL_ELECTRONIC_EQUIPMENT_OPERATOR {
    override fun toString(): String = "기타 전기·전자 설비 조작원"
  },
  ELECTRONICS_COMPONENT_PRODUCT_MACHINE_OPERATOR {
    override fun toString(): String = "전자 부품·제품 생산기계 조작원"
  },
  LED_COMPONENT_PRODUCT_ASSEMBLER_TESTER {
    override fun toString(): String = "LED 부품·제품 조립·검사원"
  },
  OTHER_ELECTRONICS_COMPONENT_PRODUCT_ASSEMBLER_TESTER {
    override fun toString(): String = "기타 전자 부품·제품 조립·검사원"
  },
  ELECTRIC_COMPONENT_PRODUCT_ASSEMBLER_TESTER {
    override fun toString(): String = "전기 부품·제품 조립·검사원"
  },
  ELECTRICAL_ELECTRONIC_FIELD_SIMPLE_OPERATOR {
    override fun toString(): String = "전기·전자 분야 단순 종사원"
  };

  companion object {
    fun fromString(string: String): ElectricalElectronicInstallationMaintenanceProduction? =
      ElectricalElectronicInstallationMaintenanceProduction.values().find { it.toString() == string }
  }
}