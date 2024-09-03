package com.yusufkutluay.yemeksepeti_bootcamp.uix.views.homepage

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yusufkutluay.yemeksepeti_bootcamp.data.entity.CampaignsSection


@Composable
fun GridCampaignsSection(activity: Activity, campaignsSection: List<CampaignsSection>){

    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, top = 10.dp, bottom = 8.dp),
        text = "Kampanyalar",
        fontWeight = FontWeight.Bold,
        fontSize = 17.sp
    )

    LazyHorizontalGrid(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        rows = GridCells.Fixed(count = 1)
    ) {

        items(
            count = campaignsSection.count(),
            itemContent = {
                val campaigns = campaignsSection[it]
                Column(modifier = Modifier.padding(all = 10.dp)) {
                    Card(
                        onClick = {

                        },
                        modifier = Modifier.size(130.dp,140.dp)
                    ) {
                        Image(
                            bitmap = ImageBitmap.imageResource(
                                id = activity.resources.getIdentifier(campaigns.image, "drawable", activity.packageName)
                            ),
                            contentDescription = null,
                            contentScale = ContentScale.FillBounds
                        )
                    }
                }
            }
        )
    }

}