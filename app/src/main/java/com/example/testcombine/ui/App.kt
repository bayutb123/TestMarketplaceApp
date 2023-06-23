package com.example.testcombine.ui

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.example.testcombine.showToast
import com.example.testcombine.ui.components.Content
import com.example.testcombine.ui.components.Title
import com.example.testcombine.ui.components.ActionButton
import com.example.testcombine.ui.components.Banner
import com.example.testcombine.ui.components.Recommendation
import com.example.testcombine.ui.theme.TestCombineTheme

@Composable
fun App(
    viewModel: AppViewModel,
    modifier: Modifier,
    context: Context
) {
    Column(modifier = modifier.fillMaxSize()) {
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

@Preview(showBackground = true)
@Composable
fun PhonePreview() {
    TestCombineTheme {
        App(viewModel = AppViewModel(), modifier = Modifier.fillMaxSize(), LocalContext.current)
    }
}
@Preview(showBackground = true, device = Devices.FOLDABLE)
@Composable
fun FoldablePreview() {
    TestCombineTheme {
        App(viewModel = AppViewModel(),Modifier.fillMaxSize(), context = LocalContext.current)
    }
}