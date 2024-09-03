package com.yusufkutluay.yemeksepeti_bootcamp.uix.views.homepage

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yusufkutluay.yemeksepeti_bootcamp.data.entity.KitchenSection

@Composable
fun GridMutfakSection(activity: Activity, kitchenSectionList: List<KitchenSection>){

    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, top = 10.dp, bottom = 10.dp),
        text = "Mutfak",
        fontWeight = FontWeight.Bold,
        fontSize = 17.sp
    )

    LazyHorizontalGrid(
        rows = GridCells.Fixed(count = 2),
        modifier = Modifier.height(270.dp),
        verticalArrangement = Arrangement.Center
    ) {
        items(
            count = kitchenSectionList.count(),
            itemContent = {

                val kitchen = kitchenSectionList[it]

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Column (modifier = Modifier
                        .padding(all = 8.dp)
                        .clickable { }
                        .size(80.dp, 500.dp)
                    ){

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(80.dp)
                        ) {
                            Image(
                                bitmap = ImageBitmap.imageResource(
                                    id = activity.resources.getIdentifier(kitchen.image, "drawable", activity.packageName)
                                ),
                                contentDescription = null,
                                contentScale = ContentScale.Crop
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = kitchen.productName,
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp,
                            textAlign = TextAlign.Center,
                            lineHeight = 15.sp,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }

                }

            }
        )
    }
}