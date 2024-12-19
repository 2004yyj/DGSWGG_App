package kr.hs.dgsw.data.entity

data class NetworkResponse<T>(
    val data: T,
    val message: String,
    val status: Int
)