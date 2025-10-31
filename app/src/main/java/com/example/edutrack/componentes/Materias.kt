package com.example.edutrack.componentes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun Materias (
    navigateToHomeScreen: () -> Unit,
    navigateToCalendar: () -> Unit,
    navigateToMaterias: () -> Unit,
    navigateToPerfil: () -> Unit
)
{
    Column{
        Text("Materias")
        Spacer(modifier = Modifier.height(24.dp))
        Text("Materias del día")
        Spacer(modifier = Modifier.height(24.dp))
        FloatingActionButton(onClick = {navigateToHomeScreen()}) {
            Text("Inicio")
        }
        Spacer(modifier = Modifier.height(24.dp))
        FloatingActionButton(onClick = {navigateToCalendar()}) {
            Text("Calendario")
        }
        Spacer(modifier = Modifier.height(24.dp))
        FloatingActionButton(onClick = {navigateToMaterias()}) {
            Text("Materias")
        }
        Spacer(modifier = Modifier.height(24.dp))
        FloatingActionButton(onClick = {navigateToPerfil()}) {
            Text("Perfil")
        }
    }
}