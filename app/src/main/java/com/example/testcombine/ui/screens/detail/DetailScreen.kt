package com.example.testcombine.ui.screens.detail

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.testcombine.showToast
import com.example.testcombine.ui.AppViewModel
import com.example.testcombine.ui.screens.detail.section.Content
import com.example.testcombine.ui.screens.detail.section.Title
import com.example.testcombine.ui.screens.detail.section.ActionButton
import com.example.testcombine.ui.screens.detail.section.Banner
import com.example.testcombine.ui.screens.detail.section.Recommendation
import com.example.testcombine.ui.theme.TestCombineTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    viewModel: AppViewModel,
    modifier: Modifier,
    context: Context,
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Detail Produk")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigateUp()
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { contentPadding ->
        Column(modifier = modifier
            .fillMaxSize()
            .padding(contentPadding)) {
            Column(
                Modifier
                    .verticalScroll(rememberScrollState())
                    .weight(1f)) {
                Banner(viewModel = viewModel) {
                    viewModel.setStatus(viewModel.favourite.value)
                    showToast(context = context, "Favourite : ${viewModel.favourite.value}")
                }
                Title()
                Content(viewModel = viewModel)
                Recommendation()
            }
            ActionButton()
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PhonePreview() {
    TestCombineTheme {
        DetailScreen(viewModel = AppViewModel(), modifier = Modifier.fillMaxSize(), LocalContext.current, navController = rememberNavController())
    }
}
@Preview(showBackground = true, device = Devices.FOLDABLE)
@Composable
fun FoldablePreview() {
    TestCombineTheme {
        DetailScreen(viewModel = AppViewModel(),Modifier.fillMaxSize(), context = LocalContext.current, navController = rememberNavController())
    }
}