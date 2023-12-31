package com.example.testcombine.ui.screens.home

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.testcombine.R
import com.example.testcombine.ui.AppViewModel
import com.example.testcombine.ui.screens.Screen
import com.example.testcombine.ui.screens.home.section.AllItems
import com.example.testcombine.ui.screens.home.section.BottomAppBar
import com.example.testcombine.ui.screens.home.section.Category
import com.example.testcombine.ui.screens.home.section.FlashSales
import com.example.testcombine.ui.screens.home.section.PromoBanner
import com.example.testcombine.ui.screens.home.section.TopAppBar
import com.example.testcombine.ui.theme.TestCombineTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: AppViewModel,
    context: Context
) {
    val scrollBehavior =
        TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        topBar = {
            TopAppBar(
                context = context,
                navController = navController,
                viewModel = viewModel,
                scrollBehavior = scrollBehavior
            )
        },
        bottomBar = {
            BottomAppBar()
        },
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
    ) { innerPadding ->
        Column(
            modifier
                .padding(innerPadding)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Column(
                    modifier = modifier
                        .padding(horizontal = 16.dp)
                        .padding(vertical = 8.dp)
                ) {
                    Category()
                }
                PromoBanner()
                FlashSales(navController = navController, eventItems = viewModel.getEventItems())
                AllItems(allItems = viewModel.getAllItems()) {
                    navController.navigate(Screen.DetailScreen.route)
                }
                Button(
                    onClick = { navController.navigate(Screen.DetailScreen.route) },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_star_active_24),
                        contentDescription = null
                    )
                }

            }
        }

    }
}


@Preview(showBackground = true, device = "id:pixel_5")
@Composable
fun PreviewHomeScreen() {
    TestCombineTheme {
        HomeScreen(
            navController = rememberNavController(),
            context = LocalContext.current,
            viewModel = AppViewModel()
        )
    }
}