package com.demo.brunchstory.ui.home.component.section

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import com.demo.brunchstory.R
import com.demo.brunchstory.ui.components.CommonText
import com.demo.brunchstory.core.model.dummy.flattenPosts
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.demo.brunchstory.core.model.dummy.dummyWeekPosts
import com.demo.brunchstory.ui.home.component.TrendingCard

@Composable
fun TrendingSection(navController: NavHostController) {
    val dummyWeekPosts = flattenPosts(dummyWeekPosts()).take(10)

    Column(modifier = Modifier.padding(20.dp)) {

        Spacer(modifier = Modifier.height(20.dp))

        CommonText(
            R.string.home_todays_pick,
            style = MaterialTheme.typography.titleMedium.copy(fontStyle = FontStyle.Italic)
        )
        CommonText(
            R.string.home_trending_brunch,
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
        )

        Spacer(modifier = Modifier.height(40.dp))

        dummyWeekPosts.forEachIndexed { index, item ->
            TrendingCard(
                item = item,
                onClick ={
                    navController.navigate("detailPost/${item.id}")
                },
                index = index + 1
            )
            Divider()
        }
    }
}