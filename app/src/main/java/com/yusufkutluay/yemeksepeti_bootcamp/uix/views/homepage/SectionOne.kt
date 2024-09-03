package com.yusufkutluay.yemeksepeti_bootcamp.uix.views.homepage

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SectionOne(activity: Activity, screenWidth : Int, screenHeight : Int){
    Column(
        modifier = Modifier
            .background(Color(0x79D3D3D3))
            .fillMaxWidth()
            .padding(top = 10.dp, bottom = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Column {
                CardSection(
                    width = screenWidth / 2.1,
                    height = screenHeight / 5.0,
                    title = "Mahalle",
                    subtitle = "İlk 3 siparişe 180₺ İndirim",
                    image = "mahalleupdate",
                    activity = activity
                )
                CardSection(
                    width = screenWidth / 2.1,
                    height = screenHeight / 5.0,
                    title = "Market",
                    subtitle = "Yüzlerce Üründe İndirim",
                    image = "marketupdate",
                    activity = activity
                )
            }
            Column {
                CardSection(
                    width = screenWidth / 2.1,
                    height = screenHeight / 3.7,
                    title = "Yemek",
                    subtitle = "İndirimli Lezzetler",
                    image = "hamburgerupdate",
                    activity = activity
                )
                CardSection(
                    width = screenWidth / 2.1,
                    height = screenHeight / 8.0,
                    title = "Gel Al",
                    subtitle = "%50'ye varan indirim",
                    image = "",
                    activity = activity
                )
            }
        }
    }
}

@Composable
fun CardSection(width: Double, height: Double, title: String, subtitle: String,image: String,activity: Activity) {
    Card(
        modifier = Modifier
            .width(width.dp)
            .height(height.dp)
            .padding(all = 5.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        //onClick = {  }
    ) {
        Column(
            Modifier.padding(start = 15.dp, top = 15.dp)
        ) {
            Text(text = title, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Text(text = subtitle, fontSize = 11.sp)
        }
        if (image != ""){
            Column(
                horizontalAlignment = Alignment.End,
                modifier = Modifier.fillMaxWidth()

            ) {
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    modifier = Modifier.height(((height/3)*2 ).dp)
                ) {
                    Image(
                        bitmap = ImageBitmap.imageResource(id = activity.resources.getIdentifier(image,"drawable",activity.packageName)),
                        contentDescription = "",
                        modifier = Modifier
                            .clickable {  }
                            .fillMaxHeight(),
                        contentScale = ContentScale.Fit,

                    )
                }

            }
        }

    }
}