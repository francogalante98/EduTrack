package com.example.edutrack.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.edutrack.componentes.HomeScreen
import com.example.edutrack.componentes.Login
import com.example.edutrack.componentes.Materias

@Composable
fun NavigationWrapper()
{
    val navControlador = rememberNavController()

    NavHost(navController = navControlador, startDestination = Login)
    {
        composable<Login>
        {
            Login{
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
            Materias(
                navigateToHomeScreen = {navControlador.navigate(HomeScreen) },
                navigateToCalendar = { navControlador.navigate(Calendar) },
                navigateToMaterias = { navControlador.navigate(Materias) },
                navigateToPerfil = { navControlador.navigate(Perfil) }
            )

        }
    }
}