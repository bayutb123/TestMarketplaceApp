package com.example.testcombine.ui.screens.home.section

import android.content.Context
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.testcombine.showToast
import com.example.testcombine.ui.AppViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    context: Context,
    navController: NavController,
    viewModel: AppViewModel,
    scrollBehavior: TopAppBarScrollBehavior
) {
    val focusManager = LocalFocusManager.current
    var search by remember {
        mutableStateOf("")
    }
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
                context = context,
                modifier = Modifier.padding(horizontal = 8.dp),
                onDone = {
                    showToast(context, it)
                    focusManager.clearFocus()
                }
            )
        }
    )
}