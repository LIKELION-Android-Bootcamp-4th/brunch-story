package com.demo.brunchstory.ui.writer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.demo.brunchstory.R
import com.demo.brunchstory.core.model.Writer
import com.demo.brunchstory.ui.components.CommonText
import com.demo.brunchstory.ui.header.DefaultHeader
import com.demo.brunchstory.ui.search.components.SearchPostCard
import com.demo.brunchstory.viewmodel.WriterProfileViewModel
import org.xmlpull.v1.sax2.Driver

@Composable
fun WriterProfileScreen(navController: NavHostController, id: String) {
    val viewModel: WriterProfileViewModel = viewModel()
    val writerInfoState = viewModel.writerInfo.collectAsState()

    LaunchedEffect(id) {
        viewModel.fetchWriterProfile(id)
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
            val writer = writerInfoState.value

            if (writer != null) {
                var isSubscribe by remember { mutableStateOf(writer.isSubscribe) }

                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(paddingValues),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    item {
                        Box {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp)
                                    .background(color = colorResource(id = R.color.main_teal))
                            )

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Absolute.SpaceBetween,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 20.dp)
                            ) {
                                Column {
                                    Spacer(Modifier.height(55.dp))
                                    Text(
                                        text = writer.name,
                                        style = MaterialTheme.typography.titleLarge,
                                        modifier = Modifier.padding(bottom = 4.dp)
                                    )
                                    Text(
                                        text = writer.job,
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = Color.Gray
                                    )
                                }
                                writer.profileUrl?.let { url ->
                                    Image(
                                        painter = rememberAsyncImagePainter(url),
                                        contentDescription = "profile image",
                                        modifier = Modifier
                                            .size(80.dp)
                                            .clip(CircleShape)
                                    )
                                }

                            }
                        }
                    }

                    item {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
                        ) {
                            Text(
                                text = stringResource(R.string.subscriber) + "\n" + writer.subscriber,
                                style = MaterialTheme.typography.titleMedium,
                                color = Color.Gray
                            )
                            Spacer(Modifier.width(20.dp))
                            Text(
                                text = stringResource(R.string.interested_write) + "\n" + writer.interestedWrite,
                                style = MaterialTheme.typography.titleMedium,
                                color = Color.Gray
                            )

                            Spacer(Modifier.weight(1f))

                            Button(
                                onClick = {
                                    isSubscribe = !isSubscribe!!
                                },
                                colors = ButtonDefaults.buttonColors(colorResource(R.color.main_teal)),
                                modifier = Modifier
                                    .height(36.dp)
                                    .padding(0.dp)
                            ) {
                                Text(
                                    text = if (isSubscribe == true) stringResource(R.string.subscribed)
                                    else stringResource(R.string.subscribe),
                                    color = Color.White,
                                    fontSize = 12.sp
                                )
                            }
                        }
                    }

                    item {
                        writer.posts?.forEach { post ->
                            Column(modifier = Modifier.padding(horizontal = 20.dp)) {
                                post.category?.let {
                                    Text(
                                        it, color = colorResource(R.color.main_teal),
                                        textDecoration = TextDecoration.Underline,
                                    )
                                }
                                SearchPostCard(
                                    post = post,
                                    onClick = {
                                        navController.navigate("detailPost/${post.id}")
                                    }
                                )
                            }
                            Driver()
                        }
                    }
                }
            } else {
                CommonText(R.string.error_data_loading)
            }

        }
    )
}