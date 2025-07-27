package com.demo.brunchstory.ui.header

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demo.brunchstory.R
import com.demo.brunchstory.ui.components.CommonText

@Composable
fun LoggedOutHeader(
    onSearchClick: () -> Unit = {},
    onStartClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painterResource(R.drawable.ic_logo_default),
            contentDescription = "logo",
            modifier = Modifier.size(120.dp, 22.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        IconButton(onClick = onSearchClick) {
            Icon(
                painterResource(R.drawable.ic_search),
                contentDescription = "search",
                modifier = Modifier.size(30.dp)
            )
        }
        Button(
            onClick = onStartClick,
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
            modifier = Modifier.height(30.dp).padding(0.dp)
        ) {
            CommonText(
                text = R.string.home_start,
                color = Color.White,
                style = MaterialTheme.typography.labelSmall.copy(fontSize = 11.sp)
            )
        }
    }
}