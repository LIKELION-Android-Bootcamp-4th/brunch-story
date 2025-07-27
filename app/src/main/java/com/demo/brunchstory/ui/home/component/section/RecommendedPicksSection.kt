package com.demo.brunchstory.ui.home.component.section

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.demo.brunchstory.ui.home.component.RecommendedPickCard
import com.demo.brunchstory.ui.home.model.RecommendedBookItem

@Composable
fun RecommendedPicksSection(
    modifier: Modifier,
    recommendedPicks: List<RecommendedBookItem>
) {
    LazyRow(
        modifier = modifier
    ) {
        itemsIndexed(recommendedPicks) { index, item ->
            RecommendedPickCard(
                item = item,
                modifier = modifier,
                index = index + 1,
                totalCount = recommendedPicks.size
            )
        }
    }
}