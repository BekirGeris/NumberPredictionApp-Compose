package com.example.sayitahminapp_compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomePage(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Tahmin Oyunu", fontSize = 36.sp)
        Image(
            painter = painterResource(id = R.drawable.zar),
            contentDescription = "",
            modifier = Modifier.size(200.dp, 200.dp)
        )
        Button(
            onClick = {
                navController.navigate("guess_page")
            },
            modifier = Modifier.size(250.dp, 50.dp)
        ) {
            Text(text = "OYUNA BAŞLA")
        }
    }
}