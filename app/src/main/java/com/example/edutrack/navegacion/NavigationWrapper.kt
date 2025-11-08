package com.example.edutrack.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.edutrack.componentes.HomeScreen
import com.example.edutrack.componentes.LoginScreen
import com.example.edutrack.componentes.MateriasScreen

@Composable
fun NavigationWrapper()
{
    val navControlador = rememberNavController()

    NavHost(navController = navControlador, startDestination = Login)
    {
        composable<Login>
        {
            LoginScreen{
                navControlador.navigate(HomeScreen)
            }
        }
        composable<HomeScreen> {
            HomeScreen(
                navigateToHomeScreen = {navControlador.navigate(HomeScreen)                },
                navigateToCalendar = { navControlador.navigate(Calendar) },
                navigateToMaterias = { navControlador.navigate(Materias) },
                navigateToPerfil = { navControlador.navigate(Perfil) }
            )
        }

        composable<Materias>
        {
            MateriasScreen(
                navigateToHomeScreen = {navControlador.navigate(HomeScreen) },
                navigateToCalendar = { navControlador.navigate(Calendar) },
                navigateToMaterias = { navControlador.navigate(Materias) },
                navigateToPerfil = { navControlador.navigate(Perfil) }
            )

        }
    }
}