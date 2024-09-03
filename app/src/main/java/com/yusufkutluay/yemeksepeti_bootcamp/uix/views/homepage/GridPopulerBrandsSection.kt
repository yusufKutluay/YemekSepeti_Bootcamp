package com.yusufkutluay.yemeksepeti_bootcamp.uix.views.homepage

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yusufkutluay.yemeksepeti_bootcamp.data.entity.PopulerBrandsSection


@Composable
fun GridPopulerBrandsSection(activity: Activity, populerBrandsSection: List<PopulerBrandsSection>){

    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, top = 10.dp, bottom = 8.dp),
        text = "Popüler Markalar",
        fontWeight = FontWeight.Bold,
        fontSize = 17.sp
    )

    LazyRow(
        modifier = Modifier
            .height(150.dp)
            .fillMaxWidth()
    ) {
        items(
            count = populerBrandsSection.count(),
            itemContent = {

                val populerBrands = populerBrandsSection[it]

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(8.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .size(85.dp, 140.dp)
                            .clickable { }
                    ) {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(85.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color.LightGray
                            )
                        ) {
                            Image(bitmap = ImageBitmap.imageResource(
                                id = activity.resources.getIdentifier(populerBrands.brandImage, "drawable", activity.packageName)
                            ),
                                contentDescription = "",
                                contentScale = ContentScale.FillHeight,
                                modifier = Modifier.fillMaxSize()
                            )
                        }

                        Text(
                            text = populerBrands.brandName,
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp,
                            textAlign = TextAlign.Center,
                            lineHeight = 15.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 5.dp)
                        )

                        Text(
                            text = populerBrands.brandDistanceTime,
                            fontSize = 10.sp,
                            textAlign = TextAlign.Center,
                            lineHeight = 15.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 3.dp)
                        )
                    }
                }

            }
        )
    }

}