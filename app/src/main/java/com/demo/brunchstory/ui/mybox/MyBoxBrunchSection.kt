package com.demo.brunchstory.ui.mybox

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.demo.brunchstory.R
import com.demo.brunchstory.core.model.Post
import com.demo.brunchstory.ui.components.TextWithArrowIcon
import com.demo.brunchstory.ui.mybox.component.MyBrunchPostCard

@Composable
fun MyBoxBrunchSection(navController: NavHostController,posts: List<Post>) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        TextWithArrowIcon(text = R.string.my_brunche)
        Divider()

        posts.forEach { post ->
            MyBrunchPostCard(
                item = post,
                onClick = {
                    navController.navigate("detailPost/${post.id}")
                }
            )
            Divider()
        }
    }
}