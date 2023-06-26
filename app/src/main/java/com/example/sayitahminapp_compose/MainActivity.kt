package com.example.sayitahminapp_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.sayitahminapp_compose.ui.theme.SayiTahminAppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SayiTahminAppComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PageNavigation()
                }
            }
        }
    }
}

@Composable
fun PageNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home_page") {
        composable("home_page") {
            HomePage(navController = navController)
        }
        composable("guess_page") {
            GuessPage(navController = navController)
        }
        composable("result_page/{result}", arguments = listOf(
            navArgument("result") {type = NavType.BoolType}
        )) {
            val result = it.arguments?.getBoolean("result") ?: false
            ResultPage(result = result)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SayiTahminAppComposeTheme {

    }
}

