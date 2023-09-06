package com.example.presentation.model.careerMiddleType

enum class MechanicalInstallationMaintenanceProduction : CareerMiddleType {
  ETC {
    override fun toString(): String = "해당 없음"
  },
  SIMPLE_OPERATIVE_IN_MECHANICAL_METAL_FIELD {
    override fun toString(): String = "기계·금속 분야 단순 종사원"
  },
  CNC_MILLING_MACHINE_OPERATOR {
    override fun toString(): String = "CNC 밀링기 조작원(NC 밀링기 조작원)"
  },
  PUMP_WATER_TREATMENT_PLANT_OPERATOR {
    override fun toString(): String = "물펌프·정수 처리장치 조작원"
  },
  PULP_PAPER_MANUFACTURING_DEVICE_OPERATOR {
    override fun toString(): String = "펄프·종이 제조장치 조작원"
  },
  SHOE_MANUFACTURING_MACHINE_OPERATOR_AND_ASSEMBLER {
    override fun toString(): String = "신발 제조기계 조작원 및 조립원"
  },
  INJECTION_PACKAGING_LABELING_MACHINE_OPERATOR_AND_OTHERS {
    override fun toString(): String = "주입·포장·상표부착기 등 기타 기계 조작원"
  },
  TOFU_AND_SIMILAR_PRODUCTS_PRODUCTION_MACHINE_OPERATOR {
    override fun toString(): String = "두부 및 유사제품 생산기계 조작원"
  },
  LAUNDRY_MACHINE_OPERATOR {
    override fun toString(): String = "세탁 기계 조작원"
  },
  OTHER_NON_METALLIC_PRODUCT_PRODUCTION_MACHINE_OPERATOR {
    override fun toString(): String = "기타 비금속제품 생산기계 조작원"
  },
  MEAT_PROCESSING_MACHINE_OPERATOR {
    override fun toString(): String = "육류 가공기계 조작원"
  },
  PAPER_PRODUCT_PRODUCTION_MACHINE_OPERATOR {
    override fun toString(): String = "종이제품 생산기계 조작원"
  },
  AUTOMOBILE_COMPONENT_ASSEMBLY_AND_INSPECTION_WORKER {
    override fun toString(): String = "자동차 부분품 조립·검사원"
  },
  AUTOMOBILE_ASSEMBLY_AND_INSPECTION_WORKER {
    override fun toString(): String = "자동차 조립·검사원"
  },
  OTHER_MACHINE_ASSEMBLY_AND_INSPECTION_WORKER {
    override fun toString(): String = "기타 기계 조립·검사원"
  };

  companion object {
    fun fromString(string: String): MechanicalInstallationMaintenanceProduction? =
      values().find { it.toString() == string }
  }
}
