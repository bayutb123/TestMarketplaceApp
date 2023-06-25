package com.example.testcombine.ui.screens.home.section


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.testcombine.R
import com.example.testcombine.data.apisimulation.Product
import com.example.testcombine.toIdr
import com.example.testcombine.ui.AppViewModel
import com.example.testcombine.ui.screens.Screen
import com.example.testcombine.ui.theme.TestCombineTheme

@Composable
fun FlashSales(
    modifier: Modifier = Modifier,
    navController: NavController,
    eventItems: List<Product>
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(0.dp)
    ) {
        Text(
            text = "Minggu Gaming !",
            modifier = modifier.padding(start = 16.dp),
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            fontWeight = MaterialTheme.typography.titleLarge.fontWeight
        )
        LazyRow(contentPadding = PaddingValues(16.dp, 0.dp), content = {
            items(eventItems) { item ->
                ItemsView(
                    name = item.name,
                    eventPrice = item.eventPrice?.let { toIdr(it) },
                    originalPrice = toIdr(item.price),
                    eventValue = item.eventValue
                ) {
                    navController.navigate(Screen.DetailScreen.route)
                }
            }
        })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ItemsView(
    modifier: Modifier = Modifier,
    name: String,
    eventPrice: String?,
    originalPrice: String,
    eventValue: String?,
    onClick: () -> Unit
) {
    ElevatedCard(
        onClick = onClick,
        modifier = modifier
            .width(140.dp)
            .padding(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.bg_compose_background),
                contentDescription = null,
                modifier.height(120.dp),
                contentScale = ContentScale.FillHeight
            )
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .background(
                        MaterialTheme.colorScheme.primary,
                        shape = RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                if (eventValue != null) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier
                            .padding(4.dp, 4.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            textAlign = TextAlign.End,
                            text = eventValue,
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
                Text(text = name, maxLines = 2, fontSize = 14.sp, lineHeight = 16.sp, modifier = modifier.padding(bottom = 4.dp))
                if (eventPrice != null) {
                    Text(
                        text = "Rp $originalPrice",
                        maxLines = 1,
                        fontSize = 10.sp,
                        textAlign = TextAlign.Center,
                        textDecoration = TextDecoration.LineThrough,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
                Text(
                    text = "Rp ${eventPrice ?: originalPrice}",
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )
            }
        }
    }
}

@Preview(showBackground = true, device = "id:pixel_5")
@Composable
fun PreviewFlashSales() {
    TestCombineTheme {
        FlashSales(
            navController = NavController(context = LocalContext.current),
            eventItems = AppViewModel().getEventItems()
        )
    }
}