package com.demo.brunchstory.core.model.dummy

import androidx.compose.ui.graphics.Color
import com.demo.brunchstory.ui.home.model.RecommendedBookItem

fun dummyRecommendedBooks() = listOf(
    RecommendedBookItem(
        id = "1",
        title = "The Silent Patient",
        writer = "Alex Michaelides",
        thumbnailUrl = "https://picsum.photos/id/1005/300/20", // Unsplash 이미지
        backgroundColor = Color(0xFF1E88E5) // Blue background
    ),
    RecommendedBookItem(
        id = "2",
        title = "Where the Crawdads Sing",
        writer = "Delia Owens",
        thumbnailUrl = "https://picsum.photos/id/1011/300/200", // Unsplash 이미지
        backgroundColor = Color(0xFF8E24AA) // Purple background
    ),
    RecommendedBookItem(
        id = "3",
        title = "The Midnight Library",
        writer = "Matt Haig",
        thumbnailUrl = "https://picsum.photos/id/1005/300/20", // Unsplash 이미지
        backgroundColor = Color(0xFF7B1FA2) // Purple background
    ),
    RecommendedBookItem(
        id = "4",
        title = "Atomic Habits",
        writer = "James Clear",
        thumbnailUrl = "https://picsum.photos/id/1020/300/200", // Unsplash 이미지
        backgroundColor = Color(0xFF43A047) // Green background
    ),
    RecommendedBookItem(
        id = "5",
        title = "Educated",
        writer = "Tara Westover",
        thumbnailUrl = "https://picsum.photos/id/1005/300/20", // Unsplash 이미지
        backgroundColor = Color(0xFFFB8C00) // Orange background
    ),
    RecommendedBookItem(
        id = "6",
        title = "Becoming",
        writer = "Michelle Obama",
        thumbnailUrl = "https://picsum.photos/id/1020/300/200", // Unsplash 이미지
        backgroundColor = Color(0xFFD32F2F) // Red background
    )
)