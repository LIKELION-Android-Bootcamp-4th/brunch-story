package com.demo.brunchstory.ui.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.demo.brunchstory.R
import com.demo.brunchstory.core.model.Writer
import com.demo.brunchstory.ui.search.components.SearchWriterCard

@Composable
fun SearchWriterScreen(navController: NavHostController, writers: List<Writer>) {
    Column(
        modifier = Modifier.background(Color.Transparent)
    ) {
        Text(
            text = stringResource(R.string.search_writer_result) + writers.size + stringResource(R.string.search_count),
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(top = 20.dp, start = 20.dp, end = 20.dp),
            color = Color.Gray
        )

        writers.forEach { writer ->
            SearchWriterCard(
                writer = writer,
                onClick = {
                    navController.navigate("writerProfile/${writer.id}")
                }
            )
            Divider()
        }
    }
}