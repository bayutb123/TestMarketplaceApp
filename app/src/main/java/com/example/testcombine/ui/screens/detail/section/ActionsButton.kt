package com.example.testcombine.ui.screens.detail.section

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testcombine.R
import com.example.testcombine.ui.theme.TestCombineTheme

@Composable
fun ActionButton(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .height(60.dp)
            .fillMaxWidth()
            .padding(8.dp, 0.dp), verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Button(
            onClick = { /*TODO*/ },
            modifier.weight(2f),
            shape = ShapeDefaults.Small,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            )
        ) {
            Text(text = "Ajukan Penawaran")
        }
        Button(
            onClick = { /*TODO*/ }, modifier.weight(0.4f), shape = ShapeDefaults.Small,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                contentColor = MaterialTheme.colorScheme.onSurface
            ),
            border = BorderStroke(2.dp, MaterialTheme.colorScheme.primary)
        ) {
            Image(painter = painterResource(R.drawable.baseline_chat_24), contentDescription = null,
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurface))
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun ActionButtonPreview() {
    TestCombineTheme {
        ActionButton()
    }
}