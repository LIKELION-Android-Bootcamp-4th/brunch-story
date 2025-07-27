package com.demo.brunchstory.ui.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.demo.brunchstory.R
import com.demo.brunchstory.core.model.Post
import com.demo.brunchstory.ui.components.FilterButtons
import com.demo.brunchstory.ui.search.components.SearchPostCard

@Composable
fun SearchPostsScreen(navController: NavHostController, posts: List<Post>) {
    var selectedButtonIndex by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .background(Color.Transparent)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.search_posts_result) + posts.size + stringResource(R.string.search_count),
                style = MaterialTheme.typography.bodySmall,
                color = Color.LightGray
            )
            Spacer(modifier = Modifier.weight(1f))

            FilterButtons(
                buttons = listOf(
                    R.string.accuracy_first to {},
                    R.string.newest to {}
                ),
                selectedButtonIndex = selectedButtonIndex,
                onButtonClick = { selectedButtonIndex = it },
            )
        }

        posts.forEach { post ->
            SearchPostCard(
                post = post,
                onClick = {
                    navController.navigate("detailPost/${post.id}")
                }
            )
        }
    }
}