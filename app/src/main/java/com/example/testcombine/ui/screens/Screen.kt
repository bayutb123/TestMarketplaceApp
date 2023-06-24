package com.example.testcombine.ui.screens

sealed class Screen(val route: String) {

    object DetailScreen : Screen("detail_screen")

}
