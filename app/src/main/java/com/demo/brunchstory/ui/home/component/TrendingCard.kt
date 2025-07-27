package com.demo.brunchstory.ui.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.demo.brunchstory.core.model.Post

@Composable
fun TrendingCard(item: Post, onClick: () -> Unit, index: Int) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        onClick = onClick,
        shape = RectangleShape
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = index.toString(),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.width(20.dp))

            Column(
                modifier = Modifier.weight(1f)
            )  {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.titleLarge,
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "by ${item.writer}",
                    style = MaterialTheme.typography.titleSmall,
                    fontStyle = FontStyle.Italic,
                    color = Color.LightGray
                )

                Spacer(modifier = Modifier.height(20.dp))

                item.thumbnailDescription?.let { des ->
                    Text(
                        text = des,
                        style = MaterialTheme.typography.titleSmall,
                        color = Color.Gray,
                        maxLines = 2
                    )
                }

            }

            item.thumbnailUrl?.let { url ->
                Image(
                    painter = rememberAsyncImagePainter(url),
                    contentDescription = "",
                    modifier = Modifier.size(80.dp, 110.dp),
                    contentScale = ContentScale.Crop,
                )
            }

        }
    }
}