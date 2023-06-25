package com.example.testcombine.ui.screens.detail.section

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testcombine.R
import com.example.testcombine.ui.theme.TestCombineTheme

@Composable
fun Recommendation(modifier: Modifier = Modifier) {
    val list = listOf(
        "Data 1",
        "Data 2",
        "Data 3",
        "Data 4",
        "Data 1",
        "Data 2",
        "Data 3",
        "Data 4",
        "Data 1",
        "Data 2",
        "Data 3",
        "Data 4"
    )
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(0.dp)
    ) {
        Text(
            text = "Mirip dengan ini",
            modifier = modifier.padding(start = 16.dp),
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            fontWeight = MaterialTheme.typography.titleLarge.fontWeight
        )
        LazyRow(contentPadding = PaddingValues(16.dp, 0.dp), content = {
            items(list) { text ->
                ItemsView(text = text)
            }
        })
        Spacer(modifier = modifier.height(4.dp))
        Text(
            text = "Anda mungkin juga suka ini",
            modifier = modifier.padding(start = 16.dp),
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            fontWeight = MaterialTheme.typography.titleLarge.fontWeight
        )
        LazyRow(contentPadding = PaddingValues(16.dp, 0.dp), content = {
            items(list) { text ->
                ItemsView(text = text)
            }
        })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ItemsView(modifier: Modifier = Modifier, text: String) {
    ElevatedCard(
        onClick = { },
        modifier = modifier
            .width(140.dp)
            .padding(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            contentColor = MaterialTheme.colorScheme.onSurfaceVariant
        )
    ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.bg_compose_background),
                contentDescription = null,
                modifier.height(120.dp),
                contentScale = ContentScale.FillHeight
            )
            Column(modifier = modifier.padding(8.dp)) {
                Text(text = text, maxLines = 1)
                Text(text = stringResource(id = R.string.dummy_product_price), fontWeight = FontWeight.Bold, maxLines = 1)
            }
        }
    }
}

@Preview(showBackground = true, device = "id:pixel_5")
@Composable
fun PreviewRecommendation() {
    TestCombineTheme {
        Recommendation()
    }
}