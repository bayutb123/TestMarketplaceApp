package com.example.testcombine.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class AppViewModel : ViewModel() {
    var favourite = mutableStateOf(false)
        private set

    fun setStatus(status: Boolean) {
        favourite.value = !status
    }

}