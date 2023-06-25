package com.example.testcombine.ui.screens.home.section

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testcombine.R

@Composable
fun Category(modifier: Modifier = Modifier) {

    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = modifier.fillMaxWidth()) {
            for (i in  1..4) {
                CategoryIcon(imageResource = painterResource(id = R.drawable.baseline_star_active_24), title = "Sample $i")
            }
        }
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = modifier.fillMaxWidth()) {
            for (i in  1..4) {
                CategoryIcon(imageResource = painterResource(id = R.drawable.baseline_tips_and_updates_24), title = "Sample $i")
            }
        }
    }
}

@Composable
fun CategoryIcon(
    modifier: Modifier = Modifier,
    imageResource: Painter,
    title: String
) {
    Box(
        modifier = modifier
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = imageResource,
                contentDescription = title,
                alignment = Alignment.Center,
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.tertiary),
                modifier = modifier.size(30.dp)
            )
            Text(text = title, textAlign = TextAlign.Center, fontSize = 12.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewItem() {
    CategoryIcon(
        imageResource = painterResource(id = R.drawable.baseline_star_active_24),
        title = "Sample"
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewCategory() {
    Category()
}