package com.demo.brunchstory.ui.write

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.demo.brunchstory.R

@Composable
fun CustomBottomNavigationBar(
    selectedIndex: Int,
    onTabSelected: (Int) -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    BottomNavigation(
        backgroundColor = Color.LightGray
    ) {
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start) {

            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_gallery),
                        contentDescription = "Gallery",
                        modifier = Modifier.size(24.dp)
                    )
                },
                selected = selectedIndex == 0,
                onClick = { onTabSelected(0) },
            )

            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_format_align_left),
                        contentDescription = "Text Alignment",
                        modifier = Modifier.size(24.dp)
                    )
                },
                selected = selectedIndex == 1,
                onClick = { onTabSelected(1) }
            )

            Spacer(modifier = Modifier.weight(1f))

            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(R.drawable.ic_keyboard_hide),
                        contentDescription = "Hide Keyboard",
                        modifier = Modifier.size(24.dp)
                    )
                },
                selected = selectedIndex == 2,
                onClick = {
                    keyboardController?.hide()
                    onTabSelected(2)
                }
            )
        }

    }
}