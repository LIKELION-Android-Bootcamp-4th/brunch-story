package com.demo.brunchstory.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.demo.brunchstory.R
import com.demo.brunchstory.ui.components.CommonText

@Composable
fun BottomNavigationBar(selectedIndex: Int, onTabSelected: (Int) -> Unit) {
    val navItems = listOf(
        NavItem(
            defaultIconRes = R.drawable.ic_nav_home,
            selectedIconRes = R.drawable.ic_nav_home_filled,
            labelRes = R.string.home,
            contentDescription = "Home"
        ),
        NavItem(
            defaultIconRes = R.drawable.ic_nav_search,
            selectedIconRes = R.drawable.ic_nav_search_filled,
            labelRes = R.string.search,
            contentDescription = "Search"
        ),
        NavItem(
            defaultIconRes = R.drawable.ic_nav_write,
            selectedIconRes = R.drawable.ic_nav_write_filled,
            labelRes = R.string.write,
            contentDescription = "Edit"
        ),
        NavItem(
            defaultIconRes = R.drawable.ic_nav_mybox,
            selectedIconRes = R.drawable.ic_nav_mybox_filled,
            labelRes = R.string.myBox,
            contentDescription = "MyBox"
        )
    )

    BottomNavigation(
        backgroundColor = Color.White,
    ) {
        navItems.forEachIndexed { index, navItem ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(
                            if (selectedIndex == index) navItem.selectedIconRes else navItem.defaultIconRes
                        ),
                        contentDescription = navItem.contentDescription,
                        modifier = Modifier.size(46.dp).padding(vertical = 10.dp)
                    )
                },
                label = { CommonText(navItem.labelRes) },
                selected = selectedIndex == index,
                onClick = { onTabSelected(index) }
            )
        }
    }
}