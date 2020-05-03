package com.roque.rueda.soralgorithms.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

const val NUMBER_OF_LINES = 500

class MainViewModel : ViewModel() {

    private val _lines = MutableLiveData<IntArray>()
    val lines: LiveData<IntArray> get() = _lines

    private var _sortJob: Job? = null

    fun calculateRandomArray() {
        _sortJob?.cancel()
        val randomNumbers = createRandomIntArray()
        _lines.value = randomNumbers
    }

    fun sortArray() {
        _sortJob = viewModelScope.launch {
            val unsortedArray = lines.value ?: return@launch
            for (i in unsortedArray.indices) {
                for (j in 0..unsortedArray.indices.last - 1 - i) {
                    if (unsortedArray[j] > unsortedArray[j + 1]) {
                        val bigger = unsortedArray[j]
                        unsortedArray[j] = unsortedArray[j + 1]
                        unsortedArray[j + 1] = bigger
                    }
                }
                delay(100)
                _lines.value = unsortedArray
            }
        }
    }

    private fun createRandomIntArray() =
        IntArray(NUMBER_OF_LINES) { Random.nextInt(NUMBER_OF_LINES) }
}
