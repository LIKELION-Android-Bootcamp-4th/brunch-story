package com.demo.brunchstory.ui.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.demo.brunchstory.ui.home.model.RecommendedBookItem

@Composable
fun RecommendedPickCard(
    item: RecommendedBookItem, modifier: Modifier, index: Int, totalCount: Int
) {
    Card(
        modifier = modifier.height(480.dp),
        shape = RectangleShape,
        colors = CardDefaults.cardColors(containerColor = item.backgroundColor)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(70.dp))

            Text(
                text = item.title,
                style = MaterialTheme.typography.titleLarge,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "by ${item.writer}",
                style = MaterialTheme.typography.titleSmall,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(40.dp))

            item.thumbnailUrl?.let { url ->
                Image(
                    painter = rememberAsyncImagePainter(url),
                    contentDescription = "",
                    modifier = Modifier.size(130.dp, 190.dp),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(40.dp))

            ProgressBar(
                currentIndex = index,
                totalCount = totalCount,
                modifier = Modifier.width(130.dp)
            )
        }
    }
}

@Composable
fun ProgressBar(currentIndex: Int, totalCount: Int, modifier: Modifier = Modifier) {
    val segmentWidth = 1f / totalCount

    Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier.fillMaxWidth()) {
        repeat(totalCount) { index ->
            Box(
                modifier = Modifier
                    .height(2.dp)
                    .width((segmentWidth * 100).dp)
                    .background(
                        if (index == currentIndex - 1) Color.White else Color.Gray,
                        shape = RectangleShape
                    )
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "${currentIndex}/${totalCount}",
            color = Color.White,
            style = MaterialTheme.typography.bodySmall
        )
    }
}