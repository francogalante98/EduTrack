package com.example.edutrack.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(
    navigateToHomeScreen: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Fondo sólido
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF5B9FD8))
        )

        // Círculos decorativos
        Box(
            modifier = Modifier
                .size(200.dp)
                .offset(x = (-80).dp, y = 30.dp)
                .background(
                    color = Color(0xFF8EC5F5).copy(alpha = 0.4f),
                    shape = CircleShape
                )
        )

        Box(
            modifier = Modifier
                .size(120.dp)
                .offset(x = 280.dp, y = 100.dp)
                .background(
                    color = Color(0xFF8EC5F5).copy(alpha = 0.4f),
                    shape = CircleShape
                )
        )

        Box(
            modifier = Modifier
                .size(90.dp)
                .offset(x = 20.dp, y = 250.dp)
                .background(
                    color = Color(0xFF8EC5F5).copy(alpha = 0.4f),
                    shape = CircleShape
                )
        )

        Box(
            modifier = Modifier
                .size(140.dp)
                .offset(x = 140.dp, y = 330.dp)
                .background(
                    color = Color(0xFF8EC5F5).copy(alpha = 0.4f),
                    shape = CircleShape
                )
        )

        Box(
            modifier = Modifier
                .size(110.dp)
                .offset(x = 280.dp, y = 280.dp)
                .background(
                    color = Color(0xFF8EC5F5).copy(alpha = 0.4f),
                    shape = CircleShape
                )
        )

        Box(
            modifier = Modifier
                .size(160.dp)
                .offset(x = (-60).dp, y = 460.dp)
                .background(
                    color = Color(0xFF8EC5F5).copy(alpha = 0.4f),
                    shape = CircleShape
                )
        )

        Box(
            modifier = Modifier
                .size(100.dp)
                .offset(x = 120.dp, y = 570.dp)
                .background(
                    color = Color(0xFF8EC5F5).copy(alpha = 0.4f),
                    shape = CircleShape
                )
        )

        Box(
            modifier = Modifier
                .size(180.dp)
                .offset(x = 250.dp, y = 620.dp)
                .background(
                    color = Color(0xFF8EC5F5).copy(alpha = 0.4f),
                    shape = CircleShape
                )
        )

        // Contenido centrado
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Título EduTrack
            Text(
                text = "EduTrack",
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                letterSpacing = 1.sp
            )

            Spacer(modifier = Modifier.height(64.dp))

            // Botón de Iniciar
            Button(
                onClick = navigateToHomeScreen,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 4.dp,
                    pressedElevation = 8.dp
                )
            ) {
                Text(
                    text = "Iniciar",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF5B9FD8),
                    letterSpacing = 0.5.sp
                )
            }
        }
    }
}