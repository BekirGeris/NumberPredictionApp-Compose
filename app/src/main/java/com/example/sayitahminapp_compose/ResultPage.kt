package com.example.sayitahminapp_compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ResultPage(result: Boolean) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = if (result) "Kazandınız" else "Kaybettiniz", fontSize = 36.sp)
        Image(
            painter = painterResource(id = if (result) R.drawable.mood else R.drawable.mood_bad),
            contentDescription = "",
            modifier = Modifier.size(200.dp, 200.dp)
        )
    }
}