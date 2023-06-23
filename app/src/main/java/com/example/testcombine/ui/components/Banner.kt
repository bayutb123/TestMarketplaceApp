package com.example.testcombine.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testcombine.R
import com.example.testcombine.ui.AppViewModel
import com.example.testcombine.ui.theme.TestCombineTheme

@Composable
fun Banner(modifier: Modifier = Modifier, viewModel: AppViewModel, onClick: () -> Unit) {
    val favouriteIcon = when (viewModel.favourite.value) {
        true -> R.drawable.baseline_favorite_50
        else -> R.drawable.baseline_favorite_border_50
    }
    Box {
        Image(
            painter = painterResource(id = R.drawable.bg_compose_background),
            contentDescription = null,
            modifier
                .fillMaxWidth()
                .height(250.dp),
            contentScale = ContentScale.Crop
        )
        Column(horizontalAlignment = Alignment.End, modifier = modifier.fillMaxWidth()) {
            Row(
                verticalAlignment = Alignment.Bottom,
                modifier = modifier
                    .height(275.dp)
                    .padding(16.dp, 0.dp)
            ) {
                Box(
                    modifier = modifier
                        .size(60.dp)
                        .background(MaterialTheme.colorScheme.primary, shape = CircleShape)
                        .clip(
                            RoundedCornerShape(25.dp)
                        )
                        .clickable { onClick() }, contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = favouriteIcon),
                        contentDescription = null,
                        modifier
                            .size(25.dp),
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BannerPreview() {
    TestCombineTheme {
        Banner(viewModel = AppViewModel()) {
        }
    }
}