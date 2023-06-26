package com.example.testcombine.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.testcombine.data.apisimulation.ApiSimulation
import com.example.testcombine.data.apisimulation.Product

open class AppViewModel : ViewModel() {
    var favourite = mutableStateOf(false)
        private set

    fun setStatus(status: Boolean) {
        favourite.value = !status
    }

    fun getItemDetail(id: Int): Product {
        return ApiSimulation.apiGetItemDetail(id)
    }
    fun getAllItems(): List<Product> {
        return ApiSimulation.apiGetAllItems()
    }
    fun getEventItems(): List<Product> {
        return ApiSimulation.apiGetEventItems()
    }

}