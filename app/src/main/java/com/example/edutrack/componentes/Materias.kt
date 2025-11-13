package com.example.edutrack.componentes

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Data class para las materias
data class Materia(
    val nombre: String,
    val horario: String,
    val profesor: String,
    val color: Color
)

@Composable
fun MateriasScreen(
    navigateToHomeScreen: () -> Unit,
    navigateToCalendar: () -> Unit,
    navigateToMaterias: () -> Unit,
    navigateToPerfil: () -> Unit
) {
    val context = LocalContext.current

    // Datos de ejemplo
    val materias = listOf(
        Materia(
            nombre = "Álgebra y Lógica",
            horario = "Jueves 18:00 a 20:00 - Prof. A",
            profesor = "Prof. A",
            color = Color(0xFF00AEEF)
        ),
        Materia(
            nombre = "Desarrollo de Aplicativos Móviles",
            horario = "Jueves 20:15 a 22:15 - Prof. B",
            profesor = "Prof. B",
            color = Color(0xFFFFEB3B)
        ),
        Materia(
            nombre = "Programación",
            horario = "Martes 20:15 a 22:15 - Prof. B",
            profesor = "Prof. B",
            color = Color(0xFFFF5252)
        )
    )

    Box(modifier = Modifier.fillMaxSize()) {
        // Fondo sólido de un solo color
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF5B9FD8))
        )

        // Círculos decorativos - todos del mismo color claro, sin superposición
        // ZONA SUPERIOR IZQUIERDA
        Box(
            modifier = Modifier
                .size(200.dp)
                .offset(x = (-80).dp, y = 30.dp)
                .background(
                    color = Color(0xFF8EC5F5).copy(alpha = 0.4f),
                    shape = CircleShape
                )
        )

        // ZONA SUPERIOR DERECHA
        Box(
            modifier = Modifier
                .size(120.dp)
                .offset(x = 280.dp, y = 100.dp)
                .background(
                    color = Color(0xFF8EC5F5).copy(alpha = 0.4f),
                    shape = CircleShape
                )
        )

        // ZONA CENTRO IZQUIERDA
        Box(
            modifier = Modifier
                .size(90.dp)
                .offset(x = 20.dp, y = 250.dp)
                .background(
                    color = Color(0xFF8EC5F5).copy(alpha = 0.4f),
                    shape = CircleShape
                )
        )

        // ZONA CENTRO CENTRO
        Box(
            modifier = Modifier
                .size(140.dp)
                .offset(x = 140.dp, y = 330.dp)
                .background(
                    color = Color(0xFF8EC5F5).copy(alpha = 0.4f),
                    shape = CircleShape
                )
        )

        // ZONA CENTRO DERECHA
        Box(
            modifier = Modifier
                .size(110.dp)
                .offset(x = 280.dp, y = 280.dp)
                .background(
                    color = Color(0xFF8EC5F5).copy(alpha = 0.4f),
                    shape = CircleShape
                )
        )

        // ZONA MEDIA IZQUIERDA
        Box(
            modifier = Modifier
                .size(160.dp)
                .offset(x = (-60).dp, y = 460.dp)
                .background(
                    color = Color(0xFF8EC5F5).copy(alpha = 0.4f),
                    shape = CircleShape
                )
        )

        // ZONA INFERIOR CENTRO
        Box(
            modifier = Modifier
                .size(100.dp)
                .offset(x = 120.dp, y = 570.dp)
                .background(
                    color = Color(0xFF8EC5F5).copy(alpha = 0.4f),
                    shape = CircleShape
                )
        )

        // ZONA INFERIOR DERECHA
        Box(
            modifier = Modifier
                .size(180.dp)
                .offset(x = 250.dp, y = 620.dp)
                .background(
                    color = Color(0xFF8EC5F5).copy(alpha = 0.4f),
                    shape = CircleShape
                )
        )

        Scaffold(
            containerColor = Color.Transparent,
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        Toast.makeText(context, "Próximamente", Toast.LENGTH_SHORT).show()
                    },
                    containerColor = Color(0xFF00C896),
                    contentColor = Color.White,
                    shape = CircleShape,
                    modifier = Modifier.size(56.dp)
                ) {
                    Icon(
                        Icons.Default.Add,
                        contentDescription = "Agregar",
                        modifier = Modifier.size(24.dp)
                    )
                }
            },
            floatingActionButtonPosition = FabPosition.End,
            bottomBar = {
                Column {
                    BottomNavigationBar(
                        navigateToHomeScreen = navigateToHomeScreen,
                        navigateToCalendar = navigateToCalendar,
                        navigateToMaterias = navigateToMaterias,
                        navigateToPerfil = navigateToPerfil,
                        currentScreen = "materias"
                    )
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .windowInsetsBottomHeight(WindowInsets.navigationBars)
                            .background(Color(0xFF2C5C7E))
                    )
                }
            }
        ) { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                    Spacer(modifier = Modifier.height(8.dp))

                    // Título
                    Text(
                        text = "EduTrack",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp),
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center
                    )
                }

                // Tarjeta de materias
                item {
                    MateriasCard(materias = materias)
                }

                item {
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}

@Composable
fun MateriasCard(materias: List<Materia>) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(16.dp)
            ),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Text(
                text = "MATERIAS",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                letterSpacing = 0.5.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Contenedor con borde para las materias
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 1.dp,
                        color = Color(0xFFE0E0E0),
                        shape = RoundedCornerShape(12.dp)
                    ),
                shape = RoundedCornerShape(12.dp),
                color = Color.White
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    materias.forEachIndexed { index, materia ->
                        MateriaItem(materia = materia)
                        // Agregar divider excepto después del último item
                        if (index < materias.size - 1) {
                            HorizontalDivider(
                                modifier = Modifier.padding(vertical = 4.dp),
                                color = Color(0xFFE0E0E0),
                                thickness = 1.dp
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MateriaItem(materia: Materia) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                // Aquí se puede agregar la navegación al detalle de la materia
            }
    ) {
        // Círculo de color
        Box(
            modifier = Modifier
                .size(16.dp)
                .background(materia.color, shape = CircleShape)
        )
        Spacer(modifier = Modifier.width(12.dp))
        // Información de la materia
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = materia.nombre,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                letterSpacing = 0.3.sp
            )
            Text(
                text = materia.horario,
                fontSize = 13.sp,
                color = Color.Gray,
                modifier = Modifier.padding(top = 2.dp),
                letterSpacing = 0.2.sp
            )
        }
    }
}