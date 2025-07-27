package com.demo.brunchstory.ui.mybox

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.demo.brunchstory.R
import com.demo.brunchstory.core.model.dummy.dummyPosts
import com.demo.brunchstory.core.model.dummy.dummyWriters
import com.demo.brunchstory.ui.header.DefaultHeader

@Composable
fun MyBoxScreen(navController: NavHostController,modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            DefaultHeader(
                profileUrl = "https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Ftistory1.daumcdn.net%2Ftistory%2F4951882%2Fattach%2F6de68945edd34f68904bf0139ebb622b",
                onSearchClick = { },
                onNotificationClick = { },
                onProfileClick = { }
            )
        },
        content = { paddingValues ->
            LazyColumn(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(paddingValues)
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                item {
                    MyBoxWriterSection(navController, dummyWriters)
                }

                item {
                    MyBoxPostSection(navController,R.string.recently_viewed, dummyPosts)
                }

                item {
                    MyBoxPostSection(navController,R.string.interest_post, dummyPosts)

                }

                item {
                    MyBoxBrunchSection(navController, dummyPosts)
                }
            }
        }
    )
}