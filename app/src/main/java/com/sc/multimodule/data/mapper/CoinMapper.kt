package com.sc.multimodule.data.mapper

import com.sc.domain.Coin
import com.sc.multimodule.data.remote.TickerResponse

fun TickerResponse.toDomain(): Coin {
    return Coin(
        currency = currency, high = high.toDouble(), low = low.toDouble(),
        last = last.toDouble(),
        yesterdayHigh = yesterdayHigh.toDouble(),
        yesterdayLow = yesterdayLow.toDouble(),
    )
}