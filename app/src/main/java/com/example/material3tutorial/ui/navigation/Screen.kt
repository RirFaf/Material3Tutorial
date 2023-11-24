package com.example.material3tutorial.ui.navigation

sealed class Screen(val route: String) {
    object ButtonScreen : Screen(route = "button_screen")
    object TextFieldScreen : Screen(route = "text_field_screen")
}
