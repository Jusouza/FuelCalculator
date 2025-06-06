package com.example.fuelcalculator.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GasCalculatorViewModel : ViewModel() {

    private val _gasPrice = MutableLiveData<Float?>()
    val gasPrice: LiveData<Float?> = _gasPrice

    private val _travelDistance = MutableLiveData<Float?>()
    val travelDistance: LiveData<Float?> = _travelDistance

    private val _carConsumption = MutableLiveData<Float?>()
    val carConsumption: LiveData<Float?> = _carConsumption

    private val _totalCost = MutableLiveData<Float?>()
    val totalCost: LiveData<Float?> = _totalCost

    fun setGasPrice(gasPriceInput: Float){
        _gasPrice.value = gasPriceInput
    }

    fun setDistance(distanceInput: Float){
        _travelDistance.value = distanceInput
    }

    fun setCarConsumption(carConsumptionInput: Float){
        _carConsumption.value = carConsumptionInput
    }

    fun calculateTotal() {
        val price = gasPrice.value
        val distance = travelDistance.value
        val consumption = carConsumption.value

        if (price != null && distance != null && consumption != null){
            _totalCost.value = (distance / consumption) * price
        }
    }

    fun reset() {
        _gasPrice.value = null
        _travelDistance.value = null
        _carConsumption.value = null
        _totalCost.value = null
    }

}