package com.demo.brunchstory.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.demo.brunchstory.R

@Composable
fun FilterButtons(
    buttons: List<Pair<Int, () -> Unit>>,
    selectedButtonIndex: Int,
    onButtonClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        buttons.forEachIndexed { index, (text, onClick) ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (selectedButtonIndex == index) {
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .background(colorResource(R.color.main_teal), shape = CircleShape)
                            .padding(2.dp)
                    )
                } else {
                    Spacer(modifier = Modifier.width(12.dp))
                }

                TextButton(
                    onClick = { onButtonClick(index) },
                    contentPadding = PaddingValues(horizontal = 8.dp),
                ) {
                    CommonText(
                        text,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}