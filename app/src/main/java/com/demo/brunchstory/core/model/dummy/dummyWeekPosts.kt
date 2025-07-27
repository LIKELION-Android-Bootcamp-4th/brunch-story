package com.demo.brunchstory.core.model.dummy

import com.demo.brunchstory.core.model.Post

fun dummyWeekPosts(): List<List<Post>> {
    val fixedThumbnails = listOf(
        "https://picsum.photos/id/1005/300/200",
        "https://picsum.photos/id/1011/300/200",
        "https://picsum.photos/id/1015/300/200",
        "https://picsum.photos/id/1020/300/200",
        "https://picsum.photos/id/1024/300/200",
        "https://picsum.photos/id/1027/300/200",
        "https://picsum.photos/id/1033/300/200"
    )

    val dayNames = listOf("월", "화", "수", "목", "금", "토", "일")

    return dayNames.mapIndexed { dayIndex, day ->
        List(2) { postIndex ->
            Post(
                id = "$dayIndex-$postIndex",
                title = "$day 요일의 제목 ${postIndex + 1}",
                subTitle = "$day 요일의 부제목 ${postIndex + 1}",
                writer = "작가 ${postIndex + 1}",
                thumbnailUrl = fixedThumbnails[(dayIndex + postIndex) % fixedThumbnails.size],
                updatedAt = "2025-07-17",
                isNew = postIndex == 0, // 첫 번째만 new 표시
                thumbnailDescription = "$day 요일 썸네일 설명 ${postIndex + 1}"
            )
        }
    }
}


fun flattenPosts(dummyWeekPosts: List<List<Post>>): List<Post> {
    return dummyWeekPosts.flatten()
}