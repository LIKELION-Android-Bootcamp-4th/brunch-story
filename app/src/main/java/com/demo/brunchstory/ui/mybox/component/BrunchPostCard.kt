package com.demo.brunchstory.ui.mybox.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.demo.brunchstory.core.model.Post

@Composable
fun BrunchPostCard(item: Post, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .wrapContentWidth()
            .padding(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        onClick = onClick
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = rememberAsyncImagePainter(item.thumbnailUrl),
                contentDescription = "",
                modifier = Modifier
                    .size(122.dp, 172.dp)
                    .padding(bottom = 10.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                item.title,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 5.dp)
            )

            Text(
                text = "by ${item.writer}",
                style = MaterialTheme.typography.bodySmall.copy(fontStyle = FontStyle.Italic),
                color = Color.LightGray,
            )
        }
    }
}