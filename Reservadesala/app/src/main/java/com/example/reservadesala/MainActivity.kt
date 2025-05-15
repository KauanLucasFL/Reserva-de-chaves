package com.example.reservadesala

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.reservadesala.ui.theme.ReservaDeSalaTheme
---
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.reservasalas.ui.screens.CadastroReservaScreen
import com.example.reservasalas.ui.screens.CalendarioReservasScreen
import com.example.reservasalas.ui.theme.ReservaSalasTheme
import com.example.reservasalas.viewmodel.ReservaViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReservaSalasTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel: ReservaViewModel = viewModel()
                    val uiState by viewModel.uiState.collectAsState()

                    // Simples navegação entre telas (pode ser melhorado com Navigation Compose)
                    if (uiState.exibirCalendario) {
                        CalendarioReservasScreen(
                            reservas = uiState.reservas,
                            onVoltarParaCadastro = { viewModel.alternarTela() }
                        )
                    } else {
                        CadastroReservaScreen(
                            onReservar = { professor, data, hora, sala ->
                                viewModel.adicionarReserva(professor, data, hora, sala)
                            },
                            onMostrarCalendario = { viewModel.alternarTela() }
                        )
                    }
                }
            }
        }
    }
}