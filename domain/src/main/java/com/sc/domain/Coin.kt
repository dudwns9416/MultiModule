package com.sc.domain

data class Coin(
    val currency: String,
    val high: Double,
    val low: Double,
    val last: Double,
    val yesterdayHigh: Double,
    val yesterdayLow: Double,
)
