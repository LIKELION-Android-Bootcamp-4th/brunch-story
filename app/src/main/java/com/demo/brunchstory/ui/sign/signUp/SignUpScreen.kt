package com.demo.brunchstory.ui.sign.signUp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.demo.brunchstory.R
import com.demo.brunchstory.ui.components.CommonText
import com.demo.brunchstory.ui.sign.component.DupCheckTextField
import com.demo.brunchstory.ui.sign.component.PasswordTextField
import com.demo.brunchstory.ui.sign.component.SignButton

@Composable
fun SignUpScreen(navController: NavController) {
    var nickname by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    var isNicknameAvailable by remember { mutableStateOf(false) }
    var isEmailAvailable by remember { mutableStateOf(false) }

    var password by remember { mutableStateOf("") }
    var checkPassword by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(horizontal = 20.dp)
    ) {
        CommonText(
            text = R.string.signUp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 80.dp, bottom = 40.dp),
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center
        )

        DupCheckTextField(
            value = nickname,
            onValueChange = {
                nickname = it
                isNicknameAvailable = false
            },
            hint = R.string.nickName,
            onCheckClick = {
                isNicknameAvailable = true
            }
        )

        if (isNicknameAvailable) {
            CommonText(
                text = R.string.sign_nickname_available,
                modifier = Modifier.padding(vertical = 5.dp),
                color = colorResource(R.color.main_teal)
            )
        }

        DupCheckTextField(
            value = email,
            onValueChange = {
                email = it
                isEmailAvailable = false
            },
            hint = R.string.email,
            onCheckClick = {
                isEmailAvailable = true
            }
        )
        if (isEmailAvailable) {
            CommonText(
                text = R.string.sign_email_available,
                modifier = Modifier.padding(vertical = 5.dp),
                color = colorResource(R.color.main_teal)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        PasswordTextField(
            password = password,
            onPasswordChange = { password = it },
            hint = R.string.password
        )

        PasswordTextField(
            password = checkPassword,
            onPasswordChange = { checkPassword = it },
            hint = R.string.sign_password_check
        )

        Spacer(modifier = Modifier.weight(1f))

        SignButton(
            text = R.string.signUp,
            onClick = { navController.navigate("signIn") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 100.dp),
            backgroundColor = Color.LightGray,
            contentColor = Color.White
        )
    }
}