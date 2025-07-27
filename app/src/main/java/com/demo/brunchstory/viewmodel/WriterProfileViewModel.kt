package com.demo.brunchstory.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.brunchstory.core.model.Writer
import com.demo.brunchstory.core.model.dummy.dummyWriters
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WriterProfileViewModel : ViewModel() {
    private val _writerInfo = MutableStateFlow<Writer?>(null)
    val writerInfo: StateFlow<Writer?> = _writerInfo

    fun fetchWriterProfile(id: String) {
        viewModelScope.launch {
            _writerInfo.value = dummyWriters[0]
        }
    }
}