package com.example.presentation.model.careerMiddleType

enum class BusinessAdministrationClerical: CareerMiddleType {
  ETC {
    override fun toString(): String = "해당 없음"
  },
  DESK_GUIDE {
    override fun toString(): String = "데스크 안내원"
  },
  STATISTICS_SURVEY_SUPERVISOR {
    override fun toString(): String = "통계·설문 조사원(슈퍼바이저 포함)"
  },
  HR_EXPERT {
    override fun toString(): String = "인사·노무 전문가"
  },
  COMPUTER_DATA_ENTRY {
    override fun toString(): String = "전산자료 입력원(DB·단순자료)"
  },
  CUSTOMER_SERVICE_REPRESENTATIVE {
    override fun toString(): String = "고객 상담원(A/S·고장·제품사용)"
  },
  MARKETING_EXPERT {
    override fun toString(): String = "마케팅 전문가"
  },
  MONITOR_AGENT {
    override fun toString(): String = "모니터 요원"
  },
  PUBLIC_INSTITUTION_OFFICE_SUPPORT {
    override fun toString(): String = "사무 보조원(공공기관)"
  },
  GENERAL_COMPANY_OFFICE_SUPPORT {
    override fun toString(): String = "사무 보조원(일반사업체)"
  },
  HOSPITAL_ADMINISTRATIVE_OFFICER {
    override fun toString(): String = "병원행정 사무원(원무)"
  },
  GENERAL_AFFAIRS_CLERK {
    override fun toString(): String = "총무 및 일반 사무원"
  },
  HR_CLERK {
    override fun toString(): String = "인사 사무원"
  },
  MANAGEMENT_PLANNING_CLERK {
    override fun toString(): String = "경영 기획 사무원"
  },
  MARKETING_ADVERTISING_PR_PRODUCT_PLANNING_CLERK {
    override fun toString(): String = "마케팅·광고·홍보·상품기획 사무원"
  },
  PUBLIC_ADMINISTRATION_CLERK {
    override fun toString(): String = "공공행정 사무원"
  },
  LOGISTICS_CLERK {
    override fun toString(): String = "물류 사무원(물류 관리사)"
  },
  PRODUCTION_QUALITY_CLERK {
    override fun toString(): String = "생산·품질 사무원 및 관리원(전기·전자·컴퓨터)"
  },
  EDUCATION_TRAINING_CLERK {
    override fun toString(): String = "교육·훈련 사무원"
  },
  PRODUCTION_QUALITY_CLERK_FOOD {
    override fun toString(): String = "생산·품질 사무원 및 관리원(음식료품)"
  },
  ACCOUNTING_CLERK_GENERAL_COMPANY {
    override fun toString(): String = "경리 사무원(일반사업체)"
  },
  SCHOOL_ADMINISTRATION_CLERK {
    override fun toString(): String = "학교행정 사무원(교무)"
  },
  ACCOUNTANT_GENERAL_COMPANY {
    override fun toString(): String = "회계 사무원(일반 사업체)"
  },
  FINANCIAL_CLERK {
    override fun toString(): String = "재무 사무원"
  },
  TAX_ADMINISTRATION_CLERK {
    override fun toString(): String = "조세행정 사무원"
  },
  SALES_PLANNING_MANAGEMENT_SUPPORT_CLERK {
    override fun toString(): String = "영업 기획·관리·지원 사무원"
  },
  NATIONAL_LOCAL_GOVERNMENT_ADMINISTRATION_CLERK {
    override fun toString(): String = "국가·지방행정 사무원"
  },
  PRODUCTION_QUALITY_CLERK_OTHER_FIELDS {
    override fun toString(): String = "생산·품질 사무원 및 관리원(그 외 분야)"
  },
  SIMPLE_ACCOUNTING_CLERK {
    override fun toString(): String = "단순 경리 사무원"
  };

  companion object {
    fun fromString(string: String): BusinessAdministrationClerical? =
      BusinessAdministrationClerical.values().find { it.toString() == string }
  }
}
