package com.demo.brunchstory.ui.write

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.demo.brunchstory.R
import com.demo.brunchstory.ui.components.CommonTextField
import com.demo.brunchstory.ui.header.WriteHeader
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.text.style.TextAlign
import coil.compose.rememberAsyncImagePainter

@Composable
fun WriteScreen(
    onCancel: () -> Unit,
    onSave: () -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedIndex by remember { mutableStateOf(0) }
    var title by remember { mutableStateOf("") }
    var subtitle by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }
    var contentList = remember { mutableStateListOf<Any>() }
    var textAlignment by remember { mutableStateOf(TextAlign.Start) }

    val focusRequester = remember { FocusRequester() }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            uri?.let {
                contentList.add(content)
                contentList.add(it)
                content = ""
            }
        }
    )

    Scaffold(
        modifier = modifier.systemBarsPadding(),
        topBar = {
            WriteHeader(
                onCancel = onCancel,
                onSave = onSave
            )
        },
        bottomBar = {
            CustomBottomNavigationBar(
                selectedIndex = selectedIndex,
                onTabSelected = { index ->
                    when (index) {
                        0 -> {
                            launcher.launch("image/*")
                        }

                        1 -> {
                            textAlignment =
                                if (textAlignment == TextAlign.Start) TextAlign.Center
                                else if (textAlignment == TextAlign.Center) TextAlign.End
                                else TextAlign.Start
                        }

                        2 -> {
                            //키보드 제어
                        }
                    }
                    selectedIndex = index
                }
            )
        },
        content = { paddingValues ->

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(paddingValues)
            ) {
                item {
                    CommonTextField(
                        value = title,
                        onValueChange = { title = it },
                        hint = R.string.title,
                        textStyle = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.fillMaxWidth()
                    )

                    CommonTextField(
                        value = subtitle,
                        onValueChange = { subtitle = it },
                        textStyle = MaterialTheme.typography.titleMedium,
                        hint = R.string.sub_title,
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                items(contentList) { item ->
                    when (item) {
                        is String -> {
                            Text(
                                item,
                                style = TextStyle(fontSize = 16.sp),
                                textAlign = textAlignment
                            )
                        }

                        is Uri -> {
                            Image(
                                painter = rememberAsyncImagePainter(item),
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(200.dp),
                                contentScale = ContentScale.Inside
                            )
                        }
                    }
                }

                item {
                    CommonTextField(
                        value = content,
                        onValueChange = { content = it },
                        hint = R.string.write_placeholder_content,
                        modifier = Modifier
                            .fillMaxWidth()
                            .focusRequester(focusRequester),
                        textStyle = TextStyle(textAlign = textAlignment),
                        singleLine = false
                    )

                    LaunchedEffect(contentList.size) {
                        if (contentList.isNotEmpty()) {
                            focusRequester.requestFocus()
                        }
                    }

                }

            }
        }
    )
}