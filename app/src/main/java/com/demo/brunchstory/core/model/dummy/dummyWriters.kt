package com.demo.brunchstory.core.model.dummy

import com.demo.brunchstory.core.model.Post
import com.demo.brunchstory.core.model.Writer

val dummyWriters = listOf(
    Writer(
        id = "1",
        name = "안드로이드를 좋아하는 곰",
        job = "안드로이드 앱 개발자",
        profileUrl = "https://media.bunjang.co.kr/product/199881130_1_1713577424_w360.jpg",
        profileDescription = "따뜻 말랑한 농담곰 작가를 만나보세요",
        isSubscribe = true,
        subscriber = 1200,
        interestedWrite = 25,
        keywords = listOf("농담곰", "좋아", "하세요?"),
        posts = listOf(
            Post(
                id = "1",
                title = "안드로이드 앱 개발 시작하기",
                subTitle = "안드로이드 앱 개발에 대한 기초부터 배우자!",
                writer = "안드로이드를 좋아하는 곰",
                thumbnailUrl = "https://example.com/images/android_start.jpg",
                updatedAt = "2025-07-25",
                isNew = true,
                category = "안드로이드",
                thumbnailDescription = "안드로이드 앱 개발을 위한 기초 가이드"
            ),
            Post(
                id = "2",
                title = "안드로이드에서 REST API 호출하기",
                subTitle = "안드로이드에서 REST API를 호출하는 방법을 알아보자",
                writer = "안드로이드를 좋아하는 곰",
                thumbnailUrl = "https://example.com/images/android_api.jpg",
                updatedAt = "2025-07-23",
                isNew = false,
                category = "안드로이드",
                thumbnailDescription = "안드로이드에서 REST API 호출하는 방법"
            ),
            Post(
                id = "2",
                title = "안드로이드에서 REST API 호출하기",
                subTitle = "안드로이드에서 REST API를 호출하는 방법을 알아보자",
                writer = "안드로이드를 좋아하는 곰",
                thumbnailUrl = "https://example.com/images/android_api.jpg",
                updatedAt = "2025-07-23",
                isNew = false,
                category = "안드로이드",
                thumbnailDescription = "안드로이드에서 REST API 호출하는 방법"
            )
        )
    ),
    Writer(
        id = "2",
        name = "안드로이드 Zㅣ존 마풍춘",
        job = "안드로이드 앱 개발자, 기술 블로거",
        profileUrl = "https://i.pinimg.com/originals/ee/89/8f/ee898f9a4b83f3a28ad8a5ab91cd0d83.png",
        isSubscribe = false,
        subscriber = 800,
        interestedWrite = 15,
        posts = listOf(
            Post(
                id = "3",
                title = "안드로이드 앱 UI 만들기: Jetpack Compose 활용",
                subTitle = "안드로이드 앱의 UI를 Jetpack Compose로 만들어보자",
                writer = "김민수",
                thumbnailUrl = "https://example.com/images/android_compose_ui.jpg",
                updatedAt = "2025-07-21",
                isNew = false,
                thumbnailDescription = "Jetpack Compose를 활용한 안드로이드 UI 디자인"
            ),
            Post(
                id = "4",
                title = "안드로이드에서의 코틀린 활용법",
                subTitle = "안드로이드 개발에서 코틀린을 활용하는 다양한 방법",
                writer = "김민수",
                thumbnailUrl = "https://example.com/images/android_kotlin.jpg",
                updatedAt = "2025-07-18",
                isNew = true,
                thumbnailDescription = "안드로이드에서 코틀린을 활용하는 예제"
            )
        )
    ),
    Writer(
        id = "3",
        name = "안드로이드 엔지니어 이수진",
        job = "안드로이드 엔지니어",
        profileUrl = "https://media.bunjang.co.kr/product/199881130_1_1713577424_w360.jpg",
        isSubscribe = true,
        subscriber = 1500,
        interestedWrite = 30,
        posts = listOf(
            Post(
                id = "5",
                title = "안드로이드 앱에서 MVVM 패턴 적용하기",
                subTitle = "안드로이드 앱 개발에서 MVVM 패턴을 적용하는 방법",
                writer = "이수진",
                thumbnailUrl = "https://example.com/images/android_mvvm.jpg",
                updatedAt = "2025-07-17",
                isNew = false,
                thumbnailDescription = "안드로이드 앱에서 MVVM 패턴을 사용하는 법"
            ),
            Post(
                id = "6",
                title = "안드로이드에서 Glide 사용하기",
                subTitle = "이미지 로딩을 위한 Glide 라이브러리 사용법",
                writer = "이수진",
                thumbnailUrl = "https://example.com/images/android_glide.jpg",
                updatedAt = "2025-07-16",
                isNew = false,
                thumbnailDescription = "Glide를 사용하여 안드로이드에서 이미지 효율적으로 로딩하기"
            )
        )
    ),
    Writer(
        id = "4",
        name = "안드로이드 튜터 박정호",
        job = "안드로이드 튜터, 기술 작가",
        profileUrl = "https://www.nintendo.com/kr/character/kirby/assets/img/about/characters-kirby.png",
        isSubscribe = true,
        subscriber = 2200,
        interestedWrite = 40,
        posts = listOf(
            Post(
                id = "7",
                title = "안드로이드에서 데이터베이스 다루기",
                subTitle = "안드로이드에서 SQLite와 Room을 활용한 데이터베이스 사용법",
                writer = "박정호",
                thumbnailUrl = "https://example.com/images/android_database.jpg",
                updatedAt = "2025-07-15",
                isNew = true,
                thumbnailDescription = "SQLite와 Room으로 데이터베이스 처리하기"
            ),
            Post(
                id = "8",
                title = "안드로이드 앱의 성능 최적화하기",
                subTitle = "안드로이드 앱의 성능을 최적화하는 다양한 방법들",
                writer = "박정호",
                thumbnailUrl = "https://example.com/images/android_performance.jpg",
                updatedAt = "2025-07-14",
                isNew = false,
                thumbnailDescription = "앱 성능 최적화를 위한 팁과 트릭"
            )
        )
    ),
    Writer(
        id = "5",
        name = "안드로이드 기술 블로거 최영수",
        job = "기술 블로거, 안드로이드 개발자",
        profileUrl = "https://mblogthumb-phinf.pstatic.net/MjAyMTAxMTVfMTQ3/MDAxNjEwNzE1NjI5NDg3.zVoKymGokWDVyo4LR4DGX0hcD0tOhekkrYrQXcFgrvog.j-77qhOAo8HG_hLeeo8PM1UFSZ4UQVpww9sRTX-A-6Qg.JPEG.dltldud33/IMG_8779.JPG?type=w800",
        isSubscribe = false,
        subscriber = 1000,
        interestedWrite = 20,
        posts = listOf(
            Post(
                id = "9",
                title = "안드로이드에서 Notification 사용법",
                subTitle = "안드로이드에서 Notification을 효율적으로 다루는 방법",
                writer = "최영수",
                thumbnailUrl = "https://example.com/images/android_notification.jpg",
                updatedAt = "2025-07-12",
                isNew = true,
                thumbnailDescription = "안드로이드 알림(Notification) 활용법"
            ),
            Post(
                id = "10",
                title = "안드로이드 앱의 보안 강화하기",
                subTitle = "안드로이드 앱에서 보안을 강화하는 방법들",
                writer = "최영수",
                thumbnailUrl = "https://example.com/images/android_security.jpg",
                updatedAt = "2025-07-10",
                isNew = false,
                thumbnailDescription = "안드로이드 앱 보안을 위한 베스트 프랙티스"
            )
        )
    )
)