package com.example.presentation.model.careerMiddleType

enum class DrivingTransportation : CareerMiddleType {
  ETC {
    override fun toString(): String = "해당 없음"
  },
  NEWSPAPER_BEVERAGE_OTHER_DELIVERY {
    override fun toString(): String = "신문·음료(우유·요구르트 등) 기타 배달원"
  },
  GENERAL_COURIER {
    override fun toString(): String = "일반 택배원(퀵서비스 포함)"
  },
  POSTAL_DELIVERY {
    override fun toString(): String = "우편물 집배원"
  },
  STEVEDORE_LOAD_HANDLING {
    override fun toString(): String = "하역·적재 종사원"
  },
  LIGHT_SMALL_CARGO_VEHICLE_DRIVER {
    override fun toString(): String = "경·소형 화물차 운전원"
  },
  DELIVERY_SUPPLIER_DRIVER_DELIVERY_SALES {
    override fun toString(): String = "배송·납품 운전원(납품영업 포함)"
  },
  ROUTE_BUS_DRIVER_URBAN_RURAL_INTERCITY {
    override fun toString(): String = "노선버스 운전원(시내, 마을, 시외, 고속)"
  },
  PASSENGER_CAR_DRIVER_PRIVATE_CAR_DRIVER {
    override fun toString(): String = "승용차 운전원(자가용 운전원)"
  },
  TOUR_COMMUTING_SCHOOL_AND_OTHER_BUS_DRIVER {
    override fun toString(): String = "관광 및 통근·통학·학원 및 기타 버스 운전원"
  };

  companion object {
    fun fromString(string: String): DrivingTransportation? =
      values().find { it.toString() == string }
  }
}