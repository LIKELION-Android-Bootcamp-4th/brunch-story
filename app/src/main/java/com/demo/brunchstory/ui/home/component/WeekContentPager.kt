package com.demo.brunchstory.ui.home.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.material.Divider
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.demo.brunchstory.core.model.dummy.dummyWeekPosts

@Composable
fun WeekContentPager(
    selectedIndex: Int,
    onPageChanged: (Int) -> Unit,
    navController: NavHostController
) {
    val dummyWeekPosts = remember { dummyWeekPosts() }

    val pagerState = rememberPagerState(
        initialPage = selectedIndex,
        initialPageOffsetFraction = 0f,
        pageCount = { 7 }
    )

    LaunchedEffect(selectedIndex) {
        pagerState.scrollToPage(selectedIndex)
    }

    HorizontalPager(
        state = pagerState,
        modifier = Modifier.fillMaxWidth()
    ) { page ->

        LaunchedEffect(pagerState.currentPage) {
            onPageChanged(pagerState.currentPage)
        }

        val postsToDisplay = dummyWeekPosts.getOrNull(page)?.take(3).orEmpty()

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            postsToDisplay.forEach { post ->
                WeekPostCard(
                    post = post,
                    onClick = {
                        navController.navigate("detailPost/${post.id}")
                    }
                )
                Divider(
                    thickness = 1.dp,
                    color = Color.LightGray,
                    modifier = Modifier.padding(horizontal = 25.dp)
                )
            }
        }
    }

}