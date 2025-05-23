package com.example.reservasalas.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.reservasalas.data.Reserva

@Composable
fun ReservaCard(reserva: Reserva) {
    Card(modifier = Modifier.padding(4.dp)) {
        Column(modifier = Modifier.padding(8.dp)) {
            Professor (professor  = "Professor: ${reserva.professor}")
            data (data = "Data: ${reserva.data}")
            Sala (Sala "Sala: ${reserva.sala}")
            Hora (Hora = "Hora: ${reserva.hora}")

        }
    }
}