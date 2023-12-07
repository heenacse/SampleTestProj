package com.sample.sampletestproj.ui.splashscreenui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@HiltViewModel
class SplashViewModel: ViewModel() {
    val splscreen: LiveData<SplashState>
        get() = _splscreen

    private val _splscreen = MutableLiveData<SplashState>()
    init {
        GlobalScope.launch {
            delay(3000)
            _splscreen.postValue(SplashState.MainActivity())
        }
    }
}
sealed class SplashState {
    class MainActivity : SplashState()
}