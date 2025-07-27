package com.demo.brunchstory.core.model

data class Writer(
    val id: String?,
    val name: String,
    val job: String,
    val profileUrl: String?,
    val profileDescription: String? = null,
    val keywords: List<String>? = listOf(),
    val isSubscribe: Boolean? = false,
    val subscriber: Int?,
    val interestedWrite: Int?,
    val posts: List<Post>? = listOf()
)