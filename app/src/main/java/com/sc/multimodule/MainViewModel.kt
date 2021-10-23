package com.sc.multimodule

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sc.domain.Coin
import com.sc.domain.CoinRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val coinRepository: CoinRepository,
) : ViewModel() {

    private val _coin = MutableLiveData<Coin>()
    val coin: LiveData<Coin> get() = _coin

    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading

    private var job = SupervisorJob()

    fun getCoins() {
        viewModelScope.launch {
            _loading.value = true
            delay(500)
            _coin.value = coinRepository.getCoin("btc")
            _loading.value = false
        }
    }

    fun subscribeCoin() {
        job = SupervisorJob()
        viewModelScope.launch(job) {
            coinRepository.streamCoin("btc")
                .onEach { Log.e("main", "coin emitted") }
                .onCompletion { Log.e("main", "complite") }
                .collectLatest {
                    _coin.value = it
                }
        }
    }

    fun start() {
        stop()
        subscribeCoin()
    }

    fun stop() {
        job.cancel()
    }

    fun refresh() {
        getCoins()
    }


}
