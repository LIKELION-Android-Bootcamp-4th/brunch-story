package com.demo.brunchstory.ui.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.demo.brunchstory.R
import com.demo.brunchstory.core.model.Writer
import com.demo.brunchstory.ui.components.CommonText
import com.demo.brunchstory.ui.search.components.KeywordTagItem

@Composable
fun SearchRecommendedScreen(
    modifier: Modifier,
    recentSearches: List<String>,
    writer: Writer,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        CommonText(
            R.string.search_recommend_writer_keyword,
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )

        Text(
            text = writer.profileDescription.toString(),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(vertical = 10.dp)
        )

        Row {
            writer.keywords?.forEach { keyword ->
                KeywordTagItem(
                    keyword = keyword
                )
                Spacer(Modifier.width(5.dp))
            }
        }

        Divider(Modifier.padding(vertical = 20.dp))

        CommonText(
            text = R.string.search_recent_search_queries,
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(10.dp))

        recentSearches.forEach {
            RecentSearchItem(it)
        }
    }
}


@Composable
fun RecentSearchItem(word: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = word,
            style = MaterialTheme.typography.bodySmall,
        )

        Spacer(modifier = Modifier.weight(1f))

        IconButton(onClick = {}) {
            Icon(imageVector = Icons.Filled.Close, contentDescription = "Clear")
        }

    }
}