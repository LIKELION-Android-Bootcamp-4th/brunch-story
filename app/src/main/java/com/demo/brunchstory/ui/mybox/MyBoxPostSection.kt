package com.demo.brunchstory.ui.mybox

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.demo.brunchstory.core.model.Post
import com.demo.brunchstory.ui.components.TextWithArrowIcon
import com.demo.brunchstory.ui.mybox.component.BrunchPostCard

@Composable
fun MyBoxPostSection(navController: NavHostController, @StringRes title: Int, posts: List<Post>) {
    Column {
        TextWithArrowIcon(title)

        LazyRow {
            items(posts) { post ->
                BrunchPostCard(
                    item = post,
                    onClick = {
                        navController.navigate("detailPost/${post.id}")
                    }
                )
            }
        }
    }
}