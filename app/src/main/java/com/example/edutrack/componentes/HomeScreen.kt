package com.example.edutrack.componentes

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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

// Data classes para manejar los datos
data class Clase(
    val nombre: String,
    val horario: String,
    val color: Color
)

data class Entrega(
    val titulo: String,
    val materia: String,
    val color: Color
)

@Composable
fun HomeScreen(
    navigateToHomeScreen: () -> Unit,
    navigateToCalendar: () -> Unit,
    navigateToMaterias: () -> Unit,
    navigateToPerfil: () -> Unit
) {
    val context = LocalContext.current

    // Datos de ejemplo (en producción vendrían de un ViewModel)
    val clasesDelDia = listOf(
        Clase("Álgebra y Lógica", "18:00 a 20:00", Color(0xFF00AEEF)),
        Clase("Desarrollo de Aplicativos Móviles", "20:15 a 22:15", Color(0xFFFFEB3B))
    )

    val proximasEntregas = listOf(
        Entrega("Entrega TP Python (29/09)", "Programación", Color(0xFFFF5252)),
        Entrega("Parcial POO (01/10)", "Orientación a Objetos", Color(0xFF4CAF50)),
        Entrega("Entrega app (03/10)", "Desarrollo de Aplicativos Móviles", Color(0xFFFFEB3B))
    )

    Scaffold(
        containerColor = Color(0xFF7EB6FF),
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    Toast.makeText(context, "Agregar nueva clase o entrega", Toast.LENGTH_SHORT).show()
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
                    currentScreen = "home"
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

            // Tarjeta de clases del día
            item {
                ClasesDelDiaCard(
                    fecha = "Jueves 25/09/2025",
                    clases = clasesDelDia
                )
            }

            // Tarjeta de próximas entregas
            item {
                ProximasEntregasCard(entregas = proximasEntregas)
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun ClasesDelDiaCard(fecha: String, clases: List<Clase>) {
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
                text = fecha,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                letterSpacing = 0.5.sp
            )
            Text(
                text = "Clases del día",
                fontSize = 16.sp,
                color = Color.Gray,
                modifier = Modifier.padding(top = 4.dp),
                letterSpacing = 0.3.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Contenedor con borde para las clases
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
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    clases.forEach { clase ->
                        ClaseItem(clase = clase)
                    }
                }
            }
        }
    }
}

@Composable
fun ProximasEntregasCard(entregas: List<Entrega>) {
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
                text = "Próximas entregas o exámenes",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                letterSpacing = 0.5.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Contenedor con borde para las entregas
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
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    entregas.forEach { entrega ->
                        EntregaItem(entrega = entrega)
                    }
                }
            }
        }
    }
}

@Composable
fun ClaseItem(clase: Clase) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .size(12.dp)
                .background(clase.color, shape = CircleShape)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = clase.nombre,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                letterSpacing = 0.3.sp
            )
            Text(
                text = clase.horario,
                fontSize = 13.sp,
                color = Color.Gray,
                modifier = Modifier.padding(top = 2.dp),
                letterSpacing = 0.2.sp
            )
        }
    }
}

@Composable
fun EntregaItem(entrega: Entrega) {
    Row(
        verticalAlignment = Alignment.Top,
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .padding(top = 4.dp)
                .size(12.dp)
                .background(entrega.color, shape = CircleShape)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = entrega.titulo,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                letterSpacing = 0.3.sp
            )
            Text(
                text = entrega.materia,
                fontSize = 13.sp,
                color = Color.Gray,
                modifier = Modifier.padding(top = 2.dp),
                letterSpacing = 0.2.sp
            )
        }
    }
}

@Composable
fun BottomNavigationBar(
    navigateToHomeScreen: () -> Unit,
    navigateToCalendar: () -> Unit,
    navigateToMaterias: () -> Unit,
    navigateToPerfil: () -> Unit,
    currentScreen: String
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp),
        color = Color(0xFF2C5C7E),
        shadowElevation = 16.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 8.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            NavItem(
                icon = Icons.Default.Home,
                label = "Inicio",
                isSelected = currentScreen == "home",
                onClick = navigateToHomeScreen
            )
            NavItem(
                icon = Icons.Default.CalendarMonth,
                label = "Calendario",
                isSelected = currentScreen == "calendar",
                onClick = navigateToCalendar
            )
            NavItem(
                icon = Icons.Default.List,
                label = "Materias",
                isSelected = currentScreen == "materias",
                onClick = navigateToMaterias
            )
            NavItem(
                icon = Icons.Default.Person,
                label = "Perfil",
                isSelected = currentScreen == "perfil",
                onClick = navigateToPerfil
            )
        }
    }
}

@Composable
fun NavItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .width(80.dp)
            .fillMaxHeight()
            .then(
                if (isSelected) {
                    Modifier.background(
                        color = Color.White.copy(alpha = 0.15f),
                        shape = RoundedCornerShape(16.dp)
                    )
                } else {
                    Modifier
                }
            )
            .padding(vertical = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        IconButton(
            onClick = onClick,
            modifier = Modifier.size(48.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                modifier = Modifier.size(28.dp),
                tint = if (isSelected) Color.White else Color.White.copy(alpha = 0.7f)
            )
        }
        Text(
            text = label,
            fontSize = 11.sp,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
            color = if (isSelected) Color.White else Color.White.copy(alpha = 0.7f),
            letterSpacing = 0.3.sp,
            modifier = Modifier.padding(top = 2.dp)
        )
    }
}