package com.kingwolf.danhsachuser

data class User(
    var name : String,
    var age : Int,
    var sex : String,
) {
    override fun toString(): String {
        return "$name - $age tuổi - $sex"
    }
}
