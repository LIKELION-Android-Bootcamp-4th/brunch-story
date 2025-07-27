package com.demo.brunchstory.ui.mybox

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.demo.brunchstory.R
import com.demo.brunchstory.core.model.Writer
import com.demo.brunchstory.ui.components.TextWithArrowIcon
import com.demo.brunchstory.ui.mybox.component.InterestedWriterCard

@Composable
fun MyBoxWriterSection(navController: NavHostController,writers: List<Writer>) {
    Column {

        TextWithArrowIcon(R.string.interest_author)

        LazyRow {
            items(writers) { writer ->
                InterestedWriterCard(
                    info = writer,
                    onClick = {
                        navController.navigate("writerProfile/${writer.id}")
                    }
                )
            }
        }
    }
}