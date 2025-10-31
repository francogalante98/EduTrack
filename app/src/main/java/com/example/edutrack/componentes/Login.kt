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
fun Login (navigateToHomeScreen:()->Unit)
{
    Column{
        Text("EduTrack")
        Spacer(modifier = Modifier.height(24.dp))
        FloatingActionButton(onClick = {navigateToHomeScreen()}) {
            Text("Iniciar App")
        }
    }
}