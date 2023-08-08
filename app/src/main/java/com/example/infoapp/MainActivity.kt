package com.example.infoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.infoapp.ui.theme.InfoAppTheme
import com.example.infoapp.ui_components.InfoScreen
import com.example.infoapp.ui_components.MainScreen
import com.example.infoapp.utils.ListItem
import com.example.infoapp.utils.Routes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            var item: ListItem? = null
            InfoAppTheme {
                NavHost(
                    navController = navController,
                    startDestination = Routes.MAIN_SCREEN
                ) {
                    composable(route = Routes.MAIN_SCREEN) {
                        MainScreen(context = this@MainActivity) { listItem ->
                            item = listItem
                            navController.navigate(Routes.INFO_SCREEN)
                        }
                    }
                    composable(route = Routes.INFO_SCREEN) {
                        item?.let { it1 -> InfoScreen(item = it1) }
                    }
                }
            }
        }
    }
}