package com.demo.brunchstory.core.model

data class Post(
    val id: String?,
    val title: String,
    val subTitle: String,
    val writer: String,
    val thumbnailUrl: String?,
    val updatedAt: String,
    val isNew: Boolean,
    val thumbnailDescription: String?,
    val category: String? = null
)