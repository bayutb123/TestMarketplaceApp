package com.example.testcombine.ui.screens.home.section

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.testcombine.showToast
import com.example.testcombine.ui.theme.TestCombineTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBarAction(
    modifier: Modifier = Modifier,
    valueSearch: String,
    navController: NavController,
    onValueChanged: (String) -> Unit,
    onDone: (String) -> Unit,
    context: Context
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        BasicTextField(
            value = valueSearch,
            onValueChange = {
                onValueChanged(it)
            },
            modifier = modifier
                .background(
                    MaterialTheme.colorScheme.onPrimary,
                    shape = RoundedCornerShape(8.dp)
                )
                .weight(1f)
                .height(40.dp)
                .padding(end = 8.dp),
            textStyle = TextStyle(
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Start,
                lineHeight = TextUnit.Unspecified,
                fontSize = 16.sp,
            ),
            decorationBox = { innerTextField ->
                Row(
                    modifier.align(Alignment.CenterVertically),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Search, contentDescription = "search",
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Box {
                        if (valueSearch.isEmpty()) {
                            Text(
                                text = "Cari di TukerIn sekarang..",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color.LightGray
                            )
                        }
                        innerTextField()
                    }
                }
            },
            keyboardActions = KeyboardActions(onDone = { onDone(valueSearch)
            }),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            singleLine = true,
            maxLines = 1
        )
        IconButton(onClick = {
            showToast(context, "Clicked Chat")
        }) {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = "Chat",
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppBarActionPreview() {
    TestCombineTheme() {
        var search by remember {
            mutableStateOf("")
        }
        Column(modifier = Modifier.background(MaterialTheme.colorScheme.primary)) {
            AppBarAction(
                valueSearch = search,
                navController = rememberNavController(),
                onValueChanged = { search = it },
                context = LocalContext.current,
                onDone = {}
            )
        }
    }
}