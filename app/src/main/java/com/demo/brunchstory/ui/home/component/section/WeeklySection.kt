package com.demo.brunchstory.ui.home.component.section

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.demo.brunchstory.R
import com.demo.brunchstory.ui.components.CommonText
import com.demo.brunchstory.ui.components.FilterButtons
import com.demo.brunchstory.ui.home.component.WeekContentPager
import com.demo.brunchstory.ui.home.component.WeekdayTabs

@Composable
fun WeeklySection(
    selectedDayIndex: Int,
    onTabSelected: (Int) -> Unit,
    selectedButtonIndex: Int,
    onButtonClick: (Int) -> Unit,
    navController: NavHostController
) {
    Column {
        Spacer(modifier = Modifier.height(20.dp))
        CommonText(
            R.string.home_weekly_serial,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.dp, end = 25.dp, top = 20.dp),
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(10.dp))

        CommonText(
            R.string.home_brunch_original_serial,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 25.dp, end = 25.dp, bottom = 20.dp),
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )

        WeekdayTabs(
            selectedIndex = selectedDayIndex,
            onTabSelected = onTabSelected
        )

        FilterButtons(
            buttons = listOf(
                R.string.newest_first to {},
                R.string.most_liked_first to {}
            ),
            selectedButtonIndex = selectedButtonIndex,
            onButtonClick = onButtonClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp)
        )

        WeekContentPager(
            selectedIndex = selectedDayIndex,
            onPageChanged = onTabSelected,
            navController = navController
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp),
            contentAlignment = Alignment.Center
        ) {
            OutlinedButton(
                onClick = {},
                modifier = Modifier
                    .wrapContentWidth()
                    .height(48.dp),
                border = BorderStroke(1.dp, Color.Gray),
                shape = RoundedCornerShape(40.dp)
            ) {
                CommonText(R.string.home_view_all_serials)
            }
        }
    }
}
