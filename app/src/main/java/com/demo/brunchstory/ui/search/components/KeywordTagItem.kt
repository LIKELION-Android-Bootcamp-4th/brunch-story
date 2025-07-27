package com.demo.brunchstory.ui.search.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun KeywordTagItem(keyword: String) {
    Box(
        modifier = Modifier.run {
            border(
                    width = 1.dp,
                    color = Color.LightGray,
                    shape = RoundedCornerShape(50)  // 완전 둥글게
                )
                .clickable { }
                .padding(horizontal = 12.dp, vertical = 6.dp)
        },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = keyword,
            color = Color.Gray,
            style = MaterialTheme.typography.bodySmall
        )
    }
}