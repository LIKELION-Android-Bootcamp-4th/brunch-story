package com.demo.brunchstory.ui.sign.signIn

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.demo.brunchstory.R
import com.demo.brunchstory.ui.components.CommonTextField
import com.demo.brunchstory.ui.components.CommonText
import com.demo.brunchstory.ui.sign.component.SignButton

@Composable
fun SignInScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isChecked by remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.img_illustration_login),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, top = 80.dp),
            contentScale = ContentScale.Fit
        )

        CommonText(
            R.string.sign_greeting_primary,
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center
        )
        CommonText(
            R.string.sign_greeting_secondary,
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.titleSmall,
            textAlign = TextAlign.Center,
            color = Color.Gray
        )

        CommonTextField(
            hint = R.string.email,
            value = email,
            onValueChange = { email = it },
            modifier = Modifier.fillMaxWidth()
        )
        CommonTextField(
            hint = R.string.password,
            value = password,
            onValueChange = { password = it },
            modifier = Modifier.fillMaxWidth(),
            isPassword = true
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = isChecked,
                onCheckedChange = { isChecked = it },
            )
            CommonText(R.string.sign_save_login_info)
        }

        SignButton(
            text = R.string.login,
            onClick = { navController.navigate("home?isLoggedIn=true") },
            modifier = Modifier.fillMaxWidth(),
            backgroundColor = Color.LightGray,
            contentColor = Color.White
        )

        OutlinedButton(
            onClick = { navController.navigate("signUp") },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            border = BorderStroke(1.dp, colorResource(R.color.main_teal)),
            shape = RectangleShape
        ) {
            CommonText(R.string.signUp)
        }
    }
}