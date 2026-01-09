package com.example.carrecognizer.navigation

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.carrecognizer.ui.home.HomeScreen
import com.example.carrecognizer.ui.camera.CameraScreen
import com.example.carrecognizer.ui.result.ResultScreen

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Camera : Screen("camera")
    object Result : Screen("result")
}

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    // 🔑 privremeno držimo sliku u memoriji
    val capturedImage = remember { mutableStateOf<ByteArray?>(null) }

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {

        composable(Screen.Home.route) {
            HomeScreen(
                onTakePhoto = {
                    navController.navigate(Screen.Camera.route)
                },
                onPickGallery = {
                    navController.navigate(Screen.Camera.route)
                }
            )
        }

        composable(Screen.Camera.route) {
            CameraScreen { imageBytes ->
                capturedImage.value = imageBytes
                navController.navigate(Screen.Result.route)
            }
        }

        composable(Screen.Result.route) {
            capturedImage.value?.let { image ->
                ResultScreen(image = image)
            }
        }
    }
}