package com.yusufkutluay.yemeksepeti_bootcamp.uix.views.homepage

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NavigationDrawerItem(activity: Activity, text : String, icon : Int){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .clickable {  }
    ) {
        Row (
            modifier = Modifier
                .padding(all = 15.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(painter = painterResource(id = icon), contentDescription = "")
            Text(text = text, fontSize = 14.sp, modifier = Modifier.padding(start = 15.dp))
        }
    }

}