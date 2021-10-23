package com.sc.multimodule.data.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TickerResponse(
    @SerialName("currency")
    val currency: String,
    @SerialName("errorCode")
    val errorCode: String,
    @SerialName("first")
    val first: String,
    @SerialName("high")
    val high: String,
    @SerialName("last")
    val last: String,
    @SerialName("low")
    val low: String,
    @SerialName("result")
    val result: String,
    @SerialName("timestamp")
    val timestamp: String,
    @SerialName("volume")
    val volume: String,
    @SerialName("yesterday_first")
    val yesterdayFirst: String,
    @SerialName("yesterday_high")
    val yesterdayHigh: String,
    @SerialName("yesterday_last")
    val yesterdayLast: String,
    @SerialName("yesterday_low")
    val yesterdayLow: String,
    @SerialName("yesterday_volume")
    val yesterdayVolume: String
)