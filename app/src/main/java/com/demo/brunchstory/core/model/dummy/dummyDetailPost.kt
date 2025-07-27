package com.demo.brunchstory.core.model.dummy

import com.demo.brunchstory.core.model.Comment
import com.demo.brunchstory.core.model.ContentItem
import com.demo.brunchstory.core.model.DetailPost

val dummyDetailPost = DetailPost(
    id = "1",
    title = "The Future of Kotlin in Mobile Development",
    subTitle = "Exploring Kotlin's Role in Modern App Development",
    writer = "Jane Doe",
    content = listOf(
        ContentItem.TextItem("Kotlin has rapidly become one of the most popular programming languages for mobile development, especially for Android apps. This post will explore why Kotlin has become the language of choice for developers and how it is reshaping the way mobile applications are built."),
        ContentItem.ImageItem("https://sphinxjsc.com/wp-content/uploads/2024/02/kotlin.png"),
        ContentItem.TextItem("One of the main reasons Kotlin is so popular is because it is fully interoperable with Java. Android developers can use Kotlin and Java together seamlessly, making it easier for teams to transition from Java to Kotlin without a complete rewrite of their codebase."),
        ContentItem.TextItem("Kotlin’s concise syntax and modern features also contribute to its appeal. Developers can write cleaner, more expressive code with fewer lines, which leads to fewer bugs and improved maintainability."),
        ContentItem.ImageItem("https://miro.medium.com/v2/da:true/resize:fit:1200/1*7e2RXi01fGB5gqxb5ZqzRA.gif"),
        ContentItem.TextItem("Another major benefit of Kotlin is its support for coroutines, which allows for simpler and more efficient handling of asynchronous programming. With Kotlin coroutines, developers can write asynchronous code in a sequential manner, making it much easier to work with tasks like network calls and database queries."),
        ContentItem.TextItem("Furthermore, Kotlin is not just limited to Android. It is also used for backend development with Kotlin/Native, web development with Kotlin/JS, and even desktop applications. This versatility makes Kotlin a great choice for developers looking to use a single language across multiple platforms."),
        ContentItem.ImageItem("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQkFKRXdtEKDUaD4lnNDMwGuF7_Y1F2nysSvQ&s"),
        ContentItem.TextItem("As Kotlin continues to grow in popularity, the Kotlin community is expanding as well. With an increasing number of libraries and tools being developed for Kotlin, the ecosystem is becoming richer and more robust."),
        ContentItem.TextItem("In conclusion, Kotlin is poised to play a central role in the future of mobile and multi-platform development. Its modern features, interoperability with Java, and growing ecosystem make it an excellent choice for developers today and in the years to come."),
        ContentItem.TextItem("If you haven't started learning Kotlin yet, now is the perfect time to dive in and explore its full potential. Whether you’re a beginner or an experienced developer, Kotlin offers something for everyone.")
    ),
    updatedAt = "2025-07-25",
    tag = listOf("Kotlin", "Mobile Development", "Android", "Coroutines", "Programming"),
    comment = listOf(
        Comment(
            id = "1",
            name = "Alice Smith",
            date = "2025-07-27",
            description = "This post was very informative! I’ve been using Kotlin for a while now, but I learned a lot about coroutines and Kotlin/Native. Thanks for sharing!",
            profileUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRMVwSlS7m5IS-vzr0b0tnM5RR0Fu_CnVvC_g&s"
        ),
        Comment(
            id = "2",
            name = "Bob Johnson",
            date = "2025-07-26",
            description = "Great overview of Kotlin’s advantages. I’ve been considering migrating my Android apps to Kotlin. This post definitely helped me understand the benefits.",
            profileUrl = null
        ),
        Comment(
            id = "3",
            name = "Charlie Brown",
            date = "2025-07-25",
            description = "I’ve been working with Java for years, but I’m just starting to learn Kotlin. This post gave me some great insights into why I should make the switch.",
            profileUrl = "https://img.hankyung.com/photo/202203/01.29289966.1.jpg"
        )
    )
)