package com.demo.brunchstory.ui.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.demo.brunchstory.core.model.dummy.dummyRecommendedBooks
import com.demo.brunchstory.ui.header.DefaultHeader
import com.demo.brunchstory.ui.header.LoggedOutHeader
import com.demo.brunchstory.ui.home.component.section.TrendingSection
import com.demo.brunchstory.ui.home.component.section.DividerSection
import com.demo.brunchstory.ui.home.component.section.RecommendedPicksSection
import com.demo.brunchstory.ui.home.component.section.WeeklySection

@Composable
fun HomeScreen(navController: NavHostController) {
    var isLoggedIn = remember { mutableStateOf(false) }

    val navBackStackEntry = navController.currentBackStackEntry
    val isLoggedInArg = navBackStackEntry?.arguments?.getString("isLoggedIn")

    LaunchedEffect(isLoggedInArg) {
        isLoggedIn.value = isLoggedInArg?.toBoolean() ?: false
    }

    Scaffold(
        modifier = Modifier.systemBarsPadding(),
        topBar = {
            if (isLoggedIn.value) {
                DefaultHeader(
                    profileUrl = "https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Ftistory1.daumcdn.net%2Ftistory%2F4951882%2Fattach%2F6de68945edd34f68904bf0139ebb622b",
                    onSearchClick = {
                        navController.navigate("search")
                    },
                    onNotificationClick = { },
                    onProfileClick = { }
                )
            } else {
                LoggedOutHeader(
                    onSearchClick = {
                        navController.navigate("search")
                    },
                    onStartClick = {
                        navController.navigate("signIn")
                    }
                )
            }
        },
        content = { paddingValues ->
            var selectedDayIndex by remember { mutableStateOf(0) }
            val recommendedBooks = remember { dummyRecommendedBooks() }
            var selectedButtonIndex by remember { mutableStateOf(0) }

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                item { RecommendedPicksSection(Modifier.fillParentMaxWidth(), recommendedBooks) }
                item {
                    WeeklySection(
                        selectedDayIndex = selectedDayIndex,
                        onTabSelected = { selectedDayIndex = it },
                        selectedButtonIndex = selectedButtonIndex,
                        onButtonClick = { selectedButtonIndex = it },
                        navController
                    )
                }
                item { DividerSection() }
                item { TrendingSection(navController) }
                // 추가 UI 항목...
            }
        }
    )
}