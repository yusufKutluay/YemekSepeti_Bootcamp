package com.yusufkutluay.yemeksepeti_bootcamp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.yusufkutluay.yemeksepeti_bootcamp.ui.theme.YemekSepeti_BootcampTheme
import com.yusufkutluay.yemeksepeti_bootcamp.uix.viewmodel.HomePageViewModel
import com.yusufkutluay.yemeksepeti_bootcamp.uix.views.homepage.HomePage

class MainActivity : ComponentActivity() {
    val homePageViewModel : HomePageViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            YemekSepeti_BootcampTheme {
                HomePage(homePageViewModel)
            }
        }
    }
}

