package com.example.testcombine.ui.screens.detail.section

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testcombine.R
import com.example.testcombine.data.apisimulation.Product
import com.example.testcombine.ui.AppViewModel
import com.example.testcombine.ui.theme.GoldenBadge
import com.example.testcombine.ui.theme.TestCombineTheme

@Composable
fun Content(
    modifier: Modifier = Modifier,
    itemDetail: Product
) {
    Column(
        modifier
            .fillMaxWidth()
    ) {
        SellerSection()
        ProductSection(description = itemDetail.description)
        MapsSection(modifier = modifier)
    }
}


@Composable
fun SellerSection(
    modifier: Modifier = Modifier, rating: Int = 5,
) {
    Card(
        modifier = modifier.padding(16.dp, 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        )
    ) {
        Row(
            modifier
                .fillMaxWidth()
                .padding(16.dp, 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_account_circle_24),
                contentDescription = null,
                modifier.size(60.dp),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSecondaryContainer)
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp),
                modifier = modifier.weight(1f)
            ) {
                Text(
                    text = "Bayu Tantra Bramandhita",
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
                Box(
                    modifier = modifier
                        .background(
                            MaterialTheme.colorScheme.onSecondaryContainer,
                            RoundedCornerShape(6.dp)
                        )
                        .padding(0.dp, 4.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(2.dp),
                        modifier = modifier
                            .padding(6.dp, 0.dp)
                    ) {
                        if (rating > 0) {
                            for (i in 1..rating) {
                                Image(
                                    modifier = modifier.size(12.dp),
                                    painter = painterResource(id = R.drawable.baseline_star_active_24),
                                    contentDescription = null,
                                    colorFilter = ColorFilter.tint(GoldenBadge)
                                )
                            }
                        }
                    }
                }
            }
            Image(
                painter = painterResource(id = R.drawable.baseline_call_24),
                contentDescription = "Call",
                modifier = modifier
                    .background(MaterialTheme.colorScheme.onSecondaryContainer, shape = CircleShape)
                    .size(45.dp)
                    .padding(8.dp),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.secondaryContainer)
            )
        }
    }
}

@Composable
fun ProductSection(
    modifier: Modifier = Modifier,
    description: String
) {
    Column(
        modifier = modifier
            .padding(16.dp, 0.dp)
    ) {
        Text(
            text = description,
            fontSize = MaterialTheme.typography.bodyMedium.fontSize,
            fontWeight = MaterialTheme.typography.bodyMedium.fontWeight,
            modifier = modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
fun MapsSection(modifier: Modifier) {

    Column(modifier = modifier.padding(16.dp, 8.dp)) {
        Box(
            modifier = modifier
                .height(200.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primaryContainer),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Google Map")
        }
    }

}

@Preview(showBackground = true, device = "id:pixel_5")
@Composable
fun ContentPreview() {
    TestCombineTheme {
        Content(itemDetail = AppViewModel().getItemDetail(1))
    }
}