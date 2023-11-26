package com.example.material3tutorial.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.material3tutorial.ui.screens.BottomBarScreen
import com.example.material3tutorial.ui.screens.ButtonScreen
import com.example.material3tutorial.ui.screens.CheckScreen
import com.example.material3tutorial.ui.screens.TextFieldScreen
import com.example.material3tutorial.ui.screens.TopBarScreen

@Composable
fun AppNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.ButtonScreen.route
    ) {
        composable(
            route = Screen.ButtonScreen.route
        ){
            ButtonScreen(navController = navController)
        }
        composable(
            route = Screen.TextFieldScreen.route
        ){
            TextFieldScreen(navController = navController)
        }
        composable(
            route = Screen.CheckScreen.route
        ){
            CheckScreen(navController = navController)
        }
        composable(
            route = Screen.TopBarScreen.route
        ){
            TopBarScreen(navController = navController)
        }
        composable(
            route = Screen.BottomBarScreen.route
        ){
            BottomBarScreen(navController = navController)
        }
    }
}
