package com.yusufkutluay.yemeksepeti_bootcamp.uix.views.homepage

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yusufkutluay.yemeksepeti_bootcamp.R
import com.yusufkutluay.yemeksepeti_bootcamp.ui.theme.TopBarColor
import com.yusufkutluay.yemeksepeti_bootcamp.uix.viewmodel.HomePageViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(homePageViewModel: HomePageViewModel){

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp
    val screenHeight = configuration.screenHeightDp
    val kitchenSection = homePageViewModel.kitchenSection.observeAsState(listOf())
    val campaignsSection = homePageViewModel.campaignsSection.observeAsState(listOf())
    val populerBrandsSection = homePageViewModel.populerBrandsSection.observeAsState(listOf())
    val populerRestaurantsSection = homePageViewModel.populerRestaurantsSection.observeAsState(listOf())
    val discoverSection = homePageViewModel.discoverSection.observeAsState(listOf())

    val activity = (LocalContext.current as Activity)

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = true) {
        homePageViewModel.kitchenSectionData()
        homePageViewModel.campaignsSectionData()
        homePageViewModel.populerBrandsSectionData()
        homePageViewModel.populerRestaurantsSectionData()
        homePageViewModel.discoverSectionData()
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        //scrimColor = Color.Transparent, // arka tarafın görünümü
        drawerContent = {
            ModalDrawerSheet (
                modifier = Modifier
                    .width((screenWidth / 1.2).dp)
                    .padding(
                        top = WindowInsets.statusBars
                            .asPaddingValues()
                            .calculateTopPadding()
                    ),
                drawerShape = RoundedCornerShape(0.dp),
                drawerContainerColor = Color(0xFFFCF8F8),
            ) {
                Column(modifier = Modifier.fillMaxSize()) {
                    // Başlık ekleme
                    Spacer(modifier = Modifier.height((screenHeight/6).dp))
                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        Text(
                            text = "Giriş Yap / Hesap Oluştur",
                            modifier = Modifier
                                .padding(all = 16.dp)
                                .fillMaxWidth(),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }
                    NavigationDrawerItem(activity,"Yardım Merkezi",R.drawable.help_24px)
                    NavigationDrawerItem(activity,"Fırsatlar",R.drawable.unknown_5_24px)
                    NavigationDrawerItem(activity,"Arkadaşını Davet Et",R.drawable.featured_seasonal_and_gifts_24px)
                    Divider(
                        modifier = Modifier
                        .fillMaxWidth(),
                        color = Color.LightGray,
                        thickness = 1.dp
                    )
                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { }
                            .background(Color.White),
                        verticalArrangement = Arrangement.Center,
                        //horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Text(text = "Ayarlar/Dil Tercihi", fontSize = 14.sp, modifier = Modifier.padding(all = 15.dp))
                    }
                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { }
                            .background(Color.White)
                    ) {
                        Text(
                            text = "Kullanım Koşulları / KVK ve Gizlilik",
                            fontSize = 14.sp,
                            modifier = Modifier.padding(all = 15.dp)
                        )
                    }
                    Spacer(modifier = Modifier.fillMaxSize().background(Color.White))
                }
            }
        }
    ) {
        Scaffold (
            topBar = {
                TopAppBar(
                    modifier = Modifier.fillMaxWidth(),
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = TopBarColor
                    ),
                    title = {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            IconButton(onClick = {
                                scope.launch {
                                    drawerState.apply {
                                        if (isClosed) open() else close()
                                    } }
                            }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.baseline_menu_24),
                                    contentDescription = "",
                                    tint = Color.White
                                )
                            }
                            Spacer(modifier = Modifier.width(10.dp))
                            Column {
                                Text(
                                    text = "Gençosman Şht. Onbaşı M. Şengöz Sok. Güngören",
                                    fontSize = 15.sp,
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    lineHeight = 15.sp,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis //...
                                )
                                Text(
                                    text = "Güngören İstanbul 34165",
                                    fontSize = 13.sp,
                                    color = Color.White,
                                    lineHeight = 15.sp,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }
                    },

                    actions = {
                        Spacer(modifier = Modifier.width(20.dp))
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.shopping_basket_24px),
                                contentDescription = "",
                                tint = Color.White
                            )
                        }
                    }
                )
            }
        ){ paddingValues ->

            Column(modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
            ){
                Column(
                    Modifier
                        .fillMaxWidth()
                        .background(TopBarColor)) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(55.dp)
                            .padding(start = 20.dp, end = 20.dp, bottom = 15.dp),

                        colors = CardDefaults.cardColors(
                            containerColor = Color.White
                        ),
                        shape = RoundedCornerShape(30.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                        onClick = {
                        }
                    ) {
                        Row(Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(id = R.drawable.search),
                                contentDescription = "",
                                Modifier
                                    .size(40.dp)
                                    .padding(start = 15.dp)
                            )
                            Text(
                                text = "Restoran veya mağaza arayın",
                                modifier = Modifier.padding(start = 10.dp),
                                textAlign = TextAlign.Center,
                                color = Color.Gray,
                                fontSize = 14.sp,
                            )
                        }

                    }
                }
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    item {
                        //SectionOne çağrılması
                        SectionOne(activity,screenWidth, screenHeight)
                        Spacer(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(20.dp)
                        )

                        GridCampaignsSection(activity,campaignsSection.value)

                        GridMutfakSection(activity,kitchenSection.value)

                        GridPopulerBrandsSection(activity,populerBrandsSection.value)

                        GridPopulerRestorantsSection(activity,populerRestaurantsSection.value)

                        GridDiscoverSection(activity,discoverSection.value)
                    }
                }
            }

        }
    }
}
