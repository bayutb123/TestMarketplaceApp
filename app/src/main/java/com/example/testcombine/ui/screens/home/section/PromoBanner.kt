package com.example.testcombine.ui.screens.home.section

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testcombine.R
import com.example.testcombine.data.apisimulation.Product
import com.example.testcombine.ui.theme.TestCombineTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PromoBanner(
    modifier: Modifier = Modifier,
) {
    val list = listOf("Banner", "Banner", "Banner", "Banner", "Banner")
    val bannerCount = list.size
    val pagerState = rememberPagerState()
    Column(modifier = modifier.fillMaxWidth()) {

        HorizontalPager(
            pageCount = bannerCount,
            contentPadding = PaddingValues(16.dp, 0.dp),
            pageSize = PageSize.Fill,
            pageSpacing = 16.dp,
            state = pagerState
        ) {
            PromoBannerItem(
                image = painterResource(id = R.drawable.bg_compose_background),
                contentDescription = it.toString()
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                repeat(bannerCount) {
                    if (it == pagerState.currentPage) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_visibility_24),
                            contentDescription = null,
                            Modifier.size(16.dp)
                        )
                    } else {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_visibility_off_24),
                            contentDescription = null,
                            Modifier.size(8.dp)
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun PromoBannerItem(
    modifier: Modifier = Modifier,
    image: Painter,
    contentDescription: String?
) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp,
            pressedElevation = 0.dp,
            draggedElevation = 2.dp
        ),
        modifier = modifier
            .height(120.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = image,
            contentDescription = contentDescription,
            contentScale = ContentScale.FillHeight
        )
    }
}

@Preview(showBackground = true, device = Devices.DEFAULT)
@Composable
fun PromoBannerPreview() {
    TestCombineTheme {
        PromoBanner()
    }
}