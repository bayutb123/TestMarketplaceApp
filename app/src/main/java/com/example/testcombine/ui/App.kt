package com.example.testcombine.ui

import android.content.Context
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.testcombine.ui.screens.detail.DetailScreen
import com.example.testcombine.ui.screens.Screen
import com.example.testcombine.ui.screens.home.HomeScreen
import com.example.testcombine.ui.theme.TestCombineTheme

@Composable
fun App(
    viewModel: AppViewModel,
    modifier: Modifier = Modifier,
    context: Context
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(Screen.DetailScreen.route) {
            DetailScreen(
                viewModel = viewModel,
                modifier = modifier,
                context = context,
                navController = navController
            )
        }
        composable(Screen.HomeScreen.route) {
            HomeScreen(
                navController = navController,
                context = context,
                viewModel = viewModel
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PhonePreview() {
    TestCombineTheme {
        App(AppViewModel(), Modifier.fillMaxSize(), LocalContext.current)
    }
}

@Preview(showBackground = true, device = Devices.FOLDABLE)
@Composable
fun FoldablePreview() {
    TestCombineTheme {
        App(AppViewModel(), Modifier.fillMaxSize(), LocalContext.current)
    }
}