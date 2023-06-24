package com.example.testcombine.ui.screens.home.section

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.testcombine.showToast
import com.example.testcombine.ui.AppViewModel

@Composable
fun AppBarTitle(
    modifier : Modifier = Modifier,
    navController: NavController,
    context: Context,
    viewModel: AppViewModel
) {
    val topAppBarTextSize = 16.sp

    Box(
        Modifier
            .fillMaxWidth()
            .padding(end = 16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Card(modifier = modifier.weight(1f)) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = modifier
                        .padding(12.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(text = "Saldo dompet", fontSize = topAppBarTextSize)
                            Text(
                                text = "Rp 120.600",
                                fontSize = topAppBarTextSize,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Divider(
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier  //fill the max height
                                .height(30.dp)
                                .width(1.dp)
                        )
                        Column {
                            Text(text = "UG Poin", fontSize = topAppBarTextSize)
                            Text(
                                text = "120",
                                fontSize = topAppBarTextSize,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
            Card(modifier = Modifier.weight(0.4f)) {
                Column(
                    modifier = modifier.padding(12.dp)
                ) {
                    Text(text = "Promo", maxLines = 1, fontSize = topAppBarTextSize)
                    Text(
                        text = "Kupon anda",
                        maxLines = 1,
                        style = TextStyle(textDecoration = TextDecoration.Underline),
                        fontSize = topAppBarTextSize,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = modifier.clickable {
                            showToast(context, "Clicked Promo")
                        }
                    )
                }
            }
        }
    }
}