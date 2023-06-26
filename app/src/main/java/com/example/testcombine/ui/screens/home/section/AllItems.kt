package com.example.testcombine.ui.screens.home.section

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testcombine.R
import com.example.testcombine.data.apisimulation.Product
import com.example.testcombine.toIdr
import com.example.testcombine.ui.AppViewModel
import com.example.testcombine.ui.theme.TestCombineTheme

@Composable
fun AllItems(
    modifier: Modifier = Modifier,
    allItems: List<Product>,
    onClick: (Int) -> Unit
) {
    Column(modifier = modifier.fillMaxWidth()) {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(allItems) {
                Items(
                    name = it.name,
                    price = toIdr(it.price),
                    eventPrice = it.eventPrice?.let { it1 -> toIdr(it1) },
                    eventValue = it.eventValue,
                    isEvent = it.isEvent
                ) {
                    onClick(it.id)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Items(
    modifier: Modifier = Modifier,
    name: String,
    price: String,
    eventPrice: String?,
    eventValue: String?,
    isEvent: Boolean,
    onClick: () -> Unit
) {
    ElevatedCard(
        onClick = { onClick() },
        modifier = modifier
            .width(140.dp)
            .padding(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.tertiaryContainer,
            contentColor = MaterialTheme.colorScheme.onTertiaryContainer
        )
    ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.kitchen_set),
                contentDescription = null,
                modifier.height(120.dp),
                contentScale = ContentScale.Crop
            )
        }
        Box(
            modifier = modifier
                .fillMaxWidth()
                .background(
                    MaterialTheme.colorScheme.tertiary,
                    shape = RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            if (isEvent) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier
                        .padding(4.dp, 4.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        textAlign = TextAlign.End,
                        text = eventValue!!,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        }
        Column(
            modifier = modifier
                .padding(8.dp)
        ) {
            Text(
                text = name,
                maxLines = 2,
                fontSize = 14.sp,
                lineHeight = 16.sp,
                modifier = modifier.padding(bottom = 4.dp)
            )
            if (isEvent) {
                Text(
                    text = "Rp $price",
                    maxLines = 1,
                    fontSize = 10.sp,
                    textAlign = TextAlign.Center,
                    textDecoration = TextDecoration.LineThrough,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Text(
                    text = "Rp $eventPrice",
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )
            } else {
                Text(
                    text = "Rp $price",
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )
            }

        }
    }
}


@Preview(showBackground = true, device = "id:pixel_5")
@Composable
fun PreviewAllItems() {
    TestCombineTheme {
        AllItems(allItems = AppViewModel().getAllItems()) {}
    }
}

@Preview(showBackground = true, device = "id:pixel_5")
@Composable
fun PreviewItems() {
    TestCombineTheme {
        Items(
            name = AppViewModel().getAllItems()[1].name,
            price = toIdr(AppViewModel().getAllItems()[1].price)!!,
            eventPrice = AppViewModel().getAllItems()[1].eventPrice?.let { toIdr(it) },
            isEvent = AppViewModel().getAllItems()[1].isEvent,
            eventValue = AppViewModel().getAllItems()[1].eventValue
        ) {

        }

    }
}