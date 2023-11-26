package com.example.material3tutorial.ui.navigation

sealed class Screen(val route: String) {
    object ButtonScreen : Screen(route = "button_screen")
    object TextFieldScreen : Screen(route = "text_field_screen")
    object CheckScreen : Screen(route = "check_screen")
    object TopBarScreen : Screen(route = "top_bar_screen")
    object BottomBarScreen : Screen(route = "bottom_bar_screen")
}
