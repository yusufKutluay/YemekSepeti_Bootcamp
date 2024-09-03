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
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yusufkutluay.yemeksepeti_bootcamp.data.entity.DiscoverSection


@Composable
fun GridDiscoverSection(activity: Activity, discoverSection: List<DiscoverSection>){
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, top = 8.dp, bottom = 8.dp),
        text = "Yemek Sepeti Mahalle'yi keşfet",
        fontWeight = FontWeight.Bold,
        fontSize = 17.sp
    )

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)
    ) {
        items(
            count = discoverSection.count(),
            itemContent = {
                val discover = discoverSection[it]

                Column(
                    modifier = Modifier
                        .size(90.dp, 120.dp)
                        .padding(all = 8.dp)
                        .clickable { },
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(70.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = discover.colorDiscoverCard
                        )
                    ) {
                        Image(
                            bitmap = ImageBitmap
                                .imageResource(
                                    id = activity.resources.getIdentifier(discover.imageDiscover,
                                        "drawable",activity.packageName
                                    )),
                            contentScale = ContentScale.FillBounds,
                            contentDescription = "",
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(all = 12.dp)
                        )
                    }
                    Text(
                        text = discover.nameDiscover,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 5.dp)
                    )
                }
            }
        )
    }
}
