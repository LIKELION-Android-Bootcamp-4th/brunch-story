package com.demo.brunchstory.ui.home.model

import androidx.compose.ui.graphics.Color

data class RecommendedBookItem(
    val id: String?,
    val title: String,
    val writer: String,
    val thumbnailUrl: String?,
    val backgroundColor: Color
)