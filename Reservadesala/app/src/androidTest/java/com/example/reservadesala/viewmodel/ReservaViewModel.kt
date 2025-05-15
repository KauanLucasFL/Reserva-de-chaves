package com.example.reservasalas.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import com.example.reservasalas.data.Reserva

data class ReservaUiState(
    val reservas: List<Reserva> = emptyList(),
    val exibirCalendario: Boolean = false
)

class ReservaViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ReservaUiState())
    val uiState: StateFlow<ReservaUiState> = _uiState

    fun adicionarReserva(professor: String, data: String, hora: String, sala: String) {
        val novaReserva: String = Reserva(professor, data, hora, sala)
        _uiState.update { currentState ->
            currentState.copy(reservas = currentState.reservas + novaReserva)
        }
    }

    fun alternarTela() {
        _uiState.update { currentState ->
            currentState.copy(exibirCalendario = !currentState.exibirCalendario)
        }
    }
}