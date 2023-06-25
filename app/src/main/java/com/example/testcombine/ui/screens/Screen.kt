package com.example.testcombine.ui.screens

sealed class Screen(val route: String) {

    object HomeScreen : Screen("home_screen")
    object DetailScreen : Screen("detail_screen/dataId=1")
}
