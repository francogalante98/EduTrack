package com.example.edutrack.componentes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.edutrack.navegacion.HomeScreen

@Composable
fun HomeScreen(
    navigateToHomeScreen: () -> Unit,
    navigateToCalendar: () -> Unit,
    navigateToMaterias: () -> Unit,
    navigateToPerfil: () -> Unit
) {
    Column {
        Text("EduTrack")
        Spacer(modifier = Modifier.height(24.dp))

        FloatingActionButton(onClick = { navigateToHomeScreen() }) {
            Text("Inicio")
        }

        Spacer(modifier = Modifier.height(24.dp))
        FloatingActionButton(onClick = { navigateToCalendar() }) {
            Text("Calendario")
        }

        Spacer(modifier = Modifier.height(24.dp))
        FloatingActionButton(onClick = { navigateToMaterias() }) {
            Text("Materias")
        }

        Spacer(modifier = Modifier.height(24.dp))
        FloatingActionButton(onClick = { navigateToPerfil() }) {
            Text("Perfil")
        }
    }
}


/*ARMAR PANTALLA HOME Y MATERIAS CON NAVEGACION Y DISEÑO (EN LA MEDIDA DE LO POSIBLE, NO INDISPENSABLE)*/