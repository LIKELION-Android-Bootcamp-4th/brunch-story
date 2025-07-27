package com.demo.brunchstory.ui.sign.component

import androidx.annotation.StringRes
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.demo.brunchstory.R
import com.demo.brunchstory.ui.components.CommonText

@Composable
fun DupCheckTextField(
    value: String,
    onValueChange: (String) -> Unit,
    @StringRes hint: Int,
    onCheckClick: () -> Unit
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { CommonText(text = hint, color = Color.Gray) },
        trailingIcon = {
            Box(
                modifier = Modifier
                    .border(1.dp, Color(0xFF00C6BE), RoundedCornerShape(16.dp))
                    .clickable { onCheckClick() }
                    .padding(horizontal = 12.dp, vertical = 6.dp)
            ) {
                CommonText(
                    text = R.string.sign_check_duplicate,
                    color = colorResource(R.color.main_teal),
                )
            }
        },
        singleLine = true,
        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Gray,
            unfocusedIndicatorColor = Color.Gray,
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            errorContainerColor = Color.Transparent
        )
    )
}