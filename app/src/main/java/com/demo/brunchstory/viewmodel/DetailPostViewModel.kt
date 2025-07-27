package com.demo.brunchstory.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.brunchstory.core.model.DetailPost
import com.demo.brunchstory.core.model.dummy.dummyDetailPost
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailPostViewModel : ViewModel() {
    private val _detailPost = MutableStateFlow<DetailPost?>(null)
    val detailPost: StateFlow<DetailPost?> = _detailPost

    fun fetchDetailPost(postId: String) {
        viewModelScope.launch {
            _detailPost.value = dummyDetailPost
        }
    }
}
