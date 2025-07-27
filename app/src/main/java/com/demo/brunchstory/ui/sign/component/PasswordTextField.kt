package com.demo.brunchstory.ui.sign.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.demo.brunchstory.R
import com.demo.brunchstory.ui.components.CommonText

@Composable
fun PasswordTextField(
    password: String,
    onPasswordChange: (String) -> Unit,
    @StringRes hint: Int,
) {
    var isVisible by remember { mutableStateOf(false) }

    val isValid = remember(password) {
        password.length >= 8 &&
                password.any { it.isDigit() } &&
                password.any { it.isUpperCase() || it.isLowerCase() }
    }

    TextField(
        value = password,
        onValueChange = onPasswordChange,
        placeholder = { CommonText(text = hint, color = Color.Gray) },
        visualTransformation = if (isVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            val icon = if (isVisible) R.drawable.ic_visible_on else R.drawable.ic_visible_off

            IconButton(
                onClick = { isVisible = !isVisible },
            ) {
                Icon(
                    painter = painterResource(icon),
                    contentDescription = "",
                    modifier = Modifier.size(24.dp)
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

    if (!isValid && password.isNotEmpty()) {
        CommonText(
            text = R.string.sign_password_strength_message,
            color = Color.Red,
            modifier = Modifier.padding(start = 8.dp, top = 4.dp)
        )
    }
}