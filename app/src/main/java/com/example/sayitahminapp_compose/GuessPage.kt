package com.example.sayitahminapp_compose

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlin.random.Random

@Composable
fun GuessPage(navController: NavController) {
    val guess = remember { mutableStateOf("") }
    val randomNumber = remember { mutableStateOf(0) }
    val remainingRight = remember { mutableStateOf(5) }
    val orientation = remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LaunchedEffect(key1 = true) {
            randomNumber.value = Random.nextInt(101)
            Log.d("bekbek", "randomNumber: ${randomNumber.value}")
        }

        Text(text = "Kalan Hak: ${remainingRight.value}", fontSize = 36.sp, color = Color.Red)
        Text(text = "Yardım: ${orientation.value}", fontSize = 36.sp)

        TextField(
            value = guess.value,
            label = { Text(text = "Tahmin") },
            onValueChange = {
                guess.value = it
            }
        )

        Button(
            onClick = {
                remainingRight.value -= 1
                val g = guess.value.toInt()

                when {
                    g == randomNumber.value -> {
                        navController.navigate("result_page/true") {
                            popUpTo("guess_page") { inclusive = true }
                        }
                        return@Button
                    }
                    g > randomNumber.value -> {
                        orientation.value = "Azalt"
                    }
                    g < randomNumber.value -> {
                        orientation.value = "Arttır"
                    }
                }

                if (remainingRight.value == 0) {
                    navController.navigate("result_page/false") {
                        popUpTo("guess_page") { inclusive = true }
                    }
                }

                guess.value = ""
            },
            modifier = Modifier.size(250.dp, 50.dp)
        ) {
            Text(text = "TAHMİN ET")
        }
    }
}