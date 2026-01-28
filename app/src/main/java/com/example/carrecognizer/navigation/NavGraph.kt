package com.example.carrecognizer.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.carrecognizer.ui.home.HomeScreen
import com.example.carrecognizer.ui.result.ResultScreen

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Result : Screen("result/{image}")
}

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()
    val sharedViewModel: SharedViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                onNavigateToResult = { imageBytes ->
                    sharedViewModel.capturedImage = imageBytes
                    navController.navigate(Screen.Result.route)
                }
            )
        }

        composable(Screen.Result.route) {
            sharedViewModel.capturedImage?.let { imageBytes ->
                ResultScreen(
                    image = imageBytes,
                    viewModel = sharedViewModel
                )
            } ?: run {
                navController.popBackStack()
            }
        }
    }
}