package com.example.testcombine.ui.screens.home

import android.content.Context
import android.text.style.UnderlineSpan
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.testcombine.R
import com.example.testcombine.showToast
import com.example.testcombine.ui.AppViewModel
import com.example.testcombine.ui.screens.detail.DetailScreen
import com.example.testcombine.ui.screens.home.section.AppBarAction
import com.example.testcombine.ui.screens.home.section.AppBarTitle
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
    var search by remember {
        mutableStateOf("")
    }

    Scaffold(
        topBar = {
            LargeTopAppBar(
                title = {
                    AppBarTitle(
                        navController = navController,
                        context = context,
                        viewModel = viewModel
                    )
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    scrolledContainerColor = MaterialTheme.colorScheme.primary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onSecondary,
                ),
                scrollBehavior = scrollBehavior,
                actions = {
                    AppBarAction(
                        valueSearch = search,
                        onValueChanged = { search = it },
                        navController = navController,
                        context = context
                    )
                }
            )
        },
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
    ) { contentPadding ->
        Box(Modifier.padding(contentPadding)) {
            Column(modifier.padding(16.dp)) {

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