package com.demo.brunchstory.ui.home.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.demo.brunchstory.R

@Composable
fun WeekdayTabs(
    selectedIndex: Int,
    onTabSelected: (Int) -> Unit
) {
    val days = listOf("월", "화", "수", "목", "금", "토", "일")

    Box(modifier = Modifier.fillMaxWidth()) {
        Divider(
            color = Color.Gray,
            thickness = 1.dp,
            modifier = Modifier.align(Alignment.BottomCenter).padding(top = 12.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            days.forEachIndexed { index, day ->
                val isSelected = selectedIndex == index

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .clickable { onTabSelected(index) },
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = day,
                        color = if (isSelected) Color.Black else Color.Gray,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                    )


                    if (isSelected) {
                        Divider(
                            color = colorResource(R.color.main_teal),
                            thickness = 1.dp,
                            modifier = Modifier.fillMaxWidth().padding(top = 12.dp)
                        )
                    } else {
                        Spacer(modifier = Modifier.height(1.dp))
                    }
                }
            }
        }
    }
}