package com.demo.brunchstory.core.model

data class DetailPost(
    val id: String,
    val title: String,
    val subTitle: String,
    val writer: String,
    val content: List<ContentItem>,
    val thumbnailUrl: String? = null,
    val tag: List<String>,
    val updatedAt: String,
    val comment: List<Comment>
)

data class Comment(
    val id: String,
    val name: String,
    val date: String,
    val description: String,
    val profileUrl: String?,
)