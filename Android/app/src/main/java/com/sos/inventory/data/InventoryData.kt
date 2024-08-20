package com.sos.inventory.data

data class InventoryData(
    var id : Int = 0,
    var name : String = "",   // 재고 이름
    var remainCnt : Int = 0,   // 현재 수량
    var requiredCnt: Int = 0,   // 세팅한 필수 수량
    var cost: Int = 0,   // 원가
    var price: Int = 0,   // 판매가
    var isCheck: Boolean = false
)