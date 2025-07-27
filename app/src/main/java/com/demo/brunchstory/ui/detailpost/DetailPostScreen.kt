package com.demo.brunchstory.ui.detailpost

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.demo.brunchstory.R
import com.demo.brunchstory.core.model.ContentItem
import com.demo.brunchstory.ui.components.CommonText
import com.demo.brunchstory.ui.detailpost.component.CommentCard
import com.demo.brunchstory.ui.header.DefaultHeader
import com.demo.brunchstory.ui.search.components.KeywordTagItem
import com.demo.brunchstory.viewmodel.DetailPostViewModel

@Composable
fun DetailPostScreen(postId: String) {
    val viewModel: DetailPostViewModel = viewModel()
    val detailPostState = viewModel.detailPost.collectAsState()

    LaunchedEffect(postId) {
        viewModel.fetchDetailPost(postId)
    }

    Scaffold(
        modifier = Modifier.systemBarsPadding(),
        topBar = {
            DefaultHeader(
                profileUrl = "https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Ftistory1.daumcdn.net%2Ftistory%2F4951882%2Fattach%2F6de68945edd34f68904bf0139ebb622b",
                onSearchClick = { },
                onNotificationClick = { },
                onProfileClick = { }
            )
        },
        content = { paddingValues ->
            val detailPost = detailPostState.value

            if (detailPost != null) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(paddingValues),
                ) {
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(240.dp)
                        ) {
                            if (detailPost.thumbnailUrl == null) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .fillMaxHeight()
                                        .background(colorResource(R.color.main_teal))
                                )
                            } else {
                                Image(
                                    painter = rememberAsyncImagePainter(detailPost.thumbnailUrl),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(240.dp),
                                    contentScale = ContentScale.Crop
                                )
                            }
                            Column(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .padding(20.dp)
                            ) {
                                Spacer(Modifier.weight(1f))

                                Text(
                                    text = detailPost.title,
                                    style = MaterialTheme.typography.titleLarge
                                )
                                Text(
                                    text = detailPost.subTitle,
                                    style = MaterialTheme.typography.titleMedium
                                )

                                Spacer(Modifier.height(40.dp))

                                Row {
                                    Text(
                                        text = "by",
                                        style = MaterialTheme.typography.titleSmall,
                                        fontStyle = FontStyle.Italic,
                                        color = Color.Gray
                                    )
                                    Text(
                                        text = detailPost.writer,
                                        style = MaterialTheme.typography.titleSmall,
                                        color = Color.Black
                                    )

                                    Spacer(Modifier.width(10.dp))

                                    Text(
                                        text = detailPost.updatedAt,
                                        style = MaterialTheme.typography.titleSmall,
                                        color = Color.Gray
                                    )
                                }

                            }
                        }
                    }


                    items(detailPost.content) { item ->
                        when (item) {
                            is ContentItem.TextItem -> {
                                Text(
                                    text = item.text,
                                    modifier = Modifier.padding(horizontal = 20.dp)
                                )
                            }

                            is ContentItem.ImageItem -> {
                                Image(
                                    painter = rememberAsyncImagePainter(item.imageUrl),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(20.dp)
                                        .height(200.dp),
                                    contentScale = ContentScale.Inside
                                )
                            }
                        }
                    }

                    item {
                        FlowRow(
                            modifier = Modifier.padding(20.dp),
                            horizontalArrangement = Arrangement.spacedBy(5.dp),
                        ) {
                            detailPost.tag.forEach { tag ->
                                KeywordTagItem(tag)
                            }
                        }
                    }

                    item {
                        Row(
                            modifier = Modifier.padding(20.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = stringResource(R.string.comment)
                            )
                            Spacer(Modifier.width(5.dp))
                            Text(
                                text = detailPost.comment.size.toString(),
                                color = colorResource(R.color.main_teal)
                            )
                        }
                    }

                    items(detailPost.comment) { comment ->
                        CommentCard(comment)
                    }

                }
            } else {
                CommonText(R.string.error_data_loading)
            }

        }
    )
}