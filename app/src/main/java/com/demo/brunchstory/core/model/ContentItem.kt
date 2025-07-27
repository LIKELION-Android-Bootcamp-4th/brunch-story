package com.demo.brunchstory.core.model

import com.google.gson.Gson

sealed class ContentItem {
    data class TextItem(val text: String) : ContentItem()
    data class ImageItem(val imageUrl: String) : ContentItem()
}

data class ServerResponse(val type: String, val content: String)

fun parseContent(jsonResponse: String): List<ContentItem> {
    val gson = Gson()
    val serverResponseList = gson.fromJson(jsonResponse, Array<ServerResponse>::class.java)

    return serverResponseList.map { response ->
        when (response.type) {
            "text" -> ContentItem.TextItem(response.content)
            "image" -> ContentItem.ImageItem(response.content)
            else -> throw IllegalArgumentException("Unknown type")
        }
    }
}