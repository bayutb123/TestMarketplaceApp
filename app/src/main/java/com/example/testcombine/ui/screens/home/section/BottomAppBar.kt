package com.example.testcombine.ui.screens.home.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BottomAppBar(modifier: Modifier = Modifier) {
    Row(
        modifier
            .height(50.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Box(modifier = Modifier.size(36.dp)) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
            }
        }
        Box(modifier = Modifier.size(36.dp)) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
            }
        }
        Box(modifier = Modifier.size(36.dp)) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
            }
        }
        Box(modifier = Modifier.size(36.dp)) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
            }
        }
        Box(modifier = Modifier.size(36.dp)) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
            }
        }
    }
}