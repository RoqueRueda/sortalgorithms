package com.roque.rueda.soralgorithms.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlin.random.Random

const val NUMBER_OF_LINES = 500

class MainViewModel : ViewModel() {

    private val _lines = MutableLiveData<IntArray>()
    val lines: LiveData<IntArray> get() = _lines

    fun calculateRandomArray() {
        viewModelScope.launch {
            val randomNumbers = createRandomIntArray()
            _lines.value = randomNumbers
        }
    }

    private fun createRandomIntArray() =
        IntArray(NUMBER_OF_LINES) { Random.nextInt(NUMBER_OF_LINES) }
}
