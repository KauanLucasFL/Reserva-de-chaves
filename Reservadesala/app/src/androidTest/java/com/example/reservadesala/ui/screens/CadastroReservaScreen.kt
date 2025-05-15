package com.example.reservasalas.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
-
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.reservasalas.data.Reserva
import com.example.reservasalas.ui.components.ReservaCard

@Composable
fun CadastroReservaScreen(
    onReservar: (String, String, String, String) -> Unit,
    onMostrarCalendario: () -> Unit
) {
    var professor by remember { mutableStateOf("") }
    var data by remember { mutableStateOf("") }
    var hora by remember { mutableStateOf("") }
    var sala by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Cadastro de Reserva", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = professor,
            onValueChange = { professor = it },
            label = { Text("Nome do Professor") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = data,
            onValueChange = { data = it },
            label = { Text("Data (DD/MM/AAAA)") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = hora,
            onValueChange = { hora = it },
            label = { Text("Hora (HH:MM)") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = sala,
            onValueChange = { sala = it },
            label = { Text("Sala de Aula") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { onReservar(professor, data, hora, sala) }) {
            Text("Reservar Sala")
        }
        Spacer(modifier = Modifier.height(8.dp))

        TextButton(onClick = onMostrarCalendario) {
            Text("Ver Calendário de Reservas")
        }
    }
}

@Composable
fun CalendarioReservasScreen(reservas: List<Reserva>, onVoltarParaCadastro: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Calendário de Reservas", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        if (reservas.isEmpty()) {
            Text("Nenhuma reserva realizada ainda.")
        } else {
            reservas.forEach { reserva ->
                ReservaCard(reserva = reserva)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        Spacer(modifier = Modifier.weight(1f)) // Empurra o botão para baixo
        Button(onClick = onVoltarParaCadastro) {
            Text("Voltar para Cadastro")
        }
    }
}