package com.example.a106_ucp2

import androidx.lifecycle.ViewModel
import com.example.a106_ucp2.data.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SkripsiViewModel: ViewModel() {
    private val _stateUI = MutableStateFlow(UiState())
    val stateUI: StateFlow<UiState> = _stateUI.asStateFlow()

    fun setStudent(list: MutableList<String>){
        _stateUI.update { event ->
            event.copy(
                nama = list[0],
                nim = list[1],
                konsentrasi = list[2],
                judul = list[3],
                dos1 = list[4],
                dos2 = list[5]
            )
        }
    }
}