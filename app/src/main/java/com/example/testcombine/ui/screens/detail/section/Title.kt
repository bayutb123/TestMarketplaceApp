package com.example.testcombine.ui.screens.detail.section

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.testcombine.R
import com.example.testcombine.data.apisimulation.Product
import com.example.testcombine.toIdr
import com.example.testcombine.ui.AppViewModel

@Composable
fun Title(
    modifier: Modifier = Modifier,
    itemDetail: Product
) {
    val price = itemDetail.eventPrice ?: itemDetail.price
        Column(
            modifier
                .fillMaxWidth()
                .padding(16.dp, 0.dp)
        ) {
            Text(
                text = stringResource(R.string.dummy_seller_address),
                fontSize = MaterialTheme.typography.bodySmall.fontSize
            )
            Text(text = itemDetail.name)
            Text(text = "Rp ${toIdr(price)}")
        }
}

@Composable
@Preview(showBackground = true, device = "id:pixel_5")
fun TitlePreview() {
    Title(itemDetail = AppViewModel().getItemDetail(1))
}