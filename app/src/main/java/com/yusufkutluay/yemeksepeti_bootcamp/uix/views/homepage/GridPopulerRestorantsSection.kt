package com.yusufkutluay.yemeksepeti_bootcamp.uix.views.homepage

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yusufkutluay.yemeksepeti_bootcamp.R
import com.yusufkutluay.yemeksepeti_bootcamp.data.entity.PopulerRestaurantsSection
import com.yusufkutluay.yemeksepeti_bootcamp.ui.theme.TopBarColor


@Composable
fun GridPopulerRestorantsSection(activity: Activity, populerRestaurantsSection : List<PopulerRestaurantsSection>){

    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, top = 8.dp, bottom = 8.dp),
        text = "Popüler restoranlar",
        fontWeight = FontWeight.Bold,
        fontSize = 17.sp
    )
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .height(230.dp)
    ) {
        items(
            count = populerRestaurantsSection.count(),
            itemContent = {

                val populerRestaurant = populerRestaurantsSection[it]

                Column(
                    Modifier
                        .size(250.dp, 245.dp)
                        .padding(all = 8.dp)
                        .clickable { }
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(140.dp)
                    ){
                        Card(
                            modifier = Modifier
                                .fillMaxSize()
                        ){
                            Image(bitmap = ImageBitmap.imageResource(id = activity.resources.getIdentifier(populerRestaurant.image,"drawable",activity.packageName)),
                                contentDescription = "",
                                contentScale = ContentScale.FillBounds,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                        Column {
                            Spacer(modifier = Modifier.height(12.dp))
                            if (populerRestaurant.imageExplanation1 != ""){
                                Text(
                                    text = "  ${populerRestaurant.imageExplanation1}  ",
                                    fontSize = 11.sp,
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier
                                        .clip(
                                            RoundedCornerShape(
                                                topStart = 0.dp,
                                                bottomStart = 0.dp,
                                                topEnd = 7.dp,
                                                bottomEnd = 7.dp
                                            )
                                        )
                                        .background(TopBarColor)
                                )
                            }
                            Spacer(modifier = Modifier.height(3.dp))
                            if (populerRestaurant.imageExplanation2 != ""){
                                Text(
                                    text = "  ${populerRestaurant.imageExplanation2}  ",
                                    fontSize = 11.sp,
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier
                                        .clip(
                                            RoundedCornerShape(
                                                topStart = 0.dp,
                                                bottomStart = 0.dp,
                                                topEnd = 7.dp,
                                                bottomEnd = 7.dp
                                            )
                                        )
                                        .background(TopBarColor)
                                )
                            }
                        }
                    }


                    Row (
                        Modifier
                            .fillMaxWidth()
                            .padding(top = 5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(
                            text = populerRestaurant.restorantName,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Row (verticalAlignment = Alignment.CenterVertically){
                            Icon(
                                painter = painterResource(id = R.drawable.star),
                                contentDescription = "",
                                tint = TopBarColor,
                                modifier = Modifier.size(17.dp,17.dp)
                            )
                            Text(
                                text = populerRestaurant.favRatio,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = populerRestaurant.favRatioTotal,
                                fontSize = 12.sp
                            )
                        }
                    }

                    Text(
                        text = populerRestaurant.minPriceExplanation,
                        fontSize = 12.sp,
                        color = Color.Gray
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(painter = painterResource(id = R.drawable.time), contentDescription = "",
                            Modifier.size(16.dp,15.dp))
                        Text(
                            text = "${populerRestaurant.timeExplanation}▫️",
                            fontSize = 12.sp,
                            lineHeight = 1.sp,
                            modifier = Modifier.padding(start = 2.dp)
                        )
                        Icon(painter = painterResource(id = R.drawable.bike), contentDescription = "", tint = TopBarColor, modifier = Modifier.size(15.dp,14.dp))
                        Text(
                            text = "Ücretsiz Teslimat",
                            fontSize = 12.sp, color = TopBarColor,
                            fontWeight = FontWeight.Bold,
                            lineHeight = 1.sp,
                            modifier = Modifier.padding(start = 2.dp))
                    }
                }
            }
        )
    }
}
