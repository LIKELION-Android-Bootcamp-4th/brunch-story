package com.demo.brunchstory.ui.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.demo.brunchstory.R
import com.demo.brunchstory.ui.components.CommonText

@Composable
fun EmptyResultScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(R.drawable.ic_logo),
            contentDescription = "",
            modifier = Modifier.size(47.dp, 67.dp)
        )

        Spacer(modifier = Modifier.height(40.dp))

        CommonText(
            text = R.string.search_empty_result,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Gray
        )
    }
}