package com.demo.brunchstory.ui.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.NavHostController
import com.demo.brunchstory.R
import com.demo.brunchstory.core.model.dummy.dummySearches
import com.demo.brunchstory.core.model.dummy.dummyWriters
import com.demo.brunchstory.ui.header.SearchHeader

@Composable
fun SearchScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    var search by remember { mutableStateOf("") }
    var onSearchClicked by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            SearchHeader(
                query = search,
                onQueryChange = { search = it },
                onSearchClicked = {
                    onSearchClicked = true
                }
            )
        },
        content = { paddingValues ->
            LazyColumn(
                modifier = modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(colorResource(R.color.main_background))
            ) {
                item {

                    if (search.isNotEmpty() && onSearchClicked == true) {
                        SearchResultScreen(navController)
                    } else {
                        SearchRecommendedScreen(
                            modifier,
                            dummySearches,
                            dummyWriters[0]
                        )
                    }
                }
            }
        }
    )
}