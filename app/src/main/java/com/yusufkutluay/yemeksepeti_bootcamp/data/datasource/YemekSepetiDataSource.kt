package com.yusufkutluay.yemeksepeti_bootcamp.data.datasource

import androidx.compose.ui.graphics.Color
import com.yusufkutluay.yemeksepeti_bootcamp.data.entity.CampaignsSection
import com.yusufkutluay.yemeksepeti_bootcamp.data.entity.DiscoverSection
import com.yusufkutluay.yemeksepeti_bootcamp.data.entity.KitchenSection
import com.yusufkutluay.yemeksepeti_bootcamp.data.entity.PopulerBrandsSection
import com.yusufkutluay.yemeksepeti_bootcamp.data.entity.PopulerRestaurantsSection
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class YemekSepetiDataSource {

    suspend fun kitchenSectionData() : List<KitchenSection> = withContext(Dispatchers.IO){
        val kitchenSection = ArrayList<KitchenSection>()
        kitchenSection.addAll(listOf(
            KitchenSection("burger", "Burger"),
            KitchenSection("cag_kebap", "Cağ Kebap"),
            KitchenSection("cigkofte", "Çiğköfte"),
            KitchenSection("dondurma", "Dondurma"),
            KitchenSection("doner", "Döner"),
            KitchenSection("dunya_mutfagi", "Dünya Mutfağı"),
            KitchenSection("pasta", "Pasta"),
            KitchenSection("kahve", "Kahve"),
            KitchenSection("kebap", "Kebap"),
            KitchenSection("pizza", "Pizza"),
            KitchenSection("tavuk", "Tavuk"),
            KitchenSection("tost", "Tost"),
        ))
        return@withContext kitchenSection
    }

    suspend fun campaignsSectionData() : List<CampaignsSection> = withContext(Dispatchers.IO){
        val campaignsSection = ArrayList<CampaignsSection>()
        campaignsSection.addAll(listOf(
            CampaignsSection("campaigns1"),
            CampaignsSection("campaigns2"),
            CampaignsSection("campaigns3"),
            CampaignsSection("campaigns4"),
            CampaignsSection("campaigns5"),
            CampaignsSection("campaigns6"),
            CampaignsSection("campaigns7")
        ))
        return@withContext campaignsSection
    }

    suspend fun populerBrandsSectionData() : List<PopulerBrandsSection> = withContext(Dispatchers.IO){
        val populerBrandsSection = ArrayList<PopulerBrandsSection>()
        populerBrandsSection.addAll(listOf(
            PopulerBrandsSection("Köfteci Yusuf","kofteci_yusuf","20 mins"),
            PopulerBrandsSection("Pidem","pidem","20 mins"),
            PopulerBrandsSection("Levent Börek","levent_borek","45 mins"),
            PopulerBrandsSection("Hey Döner","hey_doner","58 mins"),
            PopulerBrandsSection("Pasaport Pizza","pasaport_pizza","15 mins"),
            PopulerBrandsSection("O Ses","oses","21 mins"),
            PopulerBrandsSection("Öncü Döner","oncu_doner","33 mins")
        ))
        return@withContext populerBrandsSection
    }

    suspend fun populerRestaurantsSectionData() : List<PopulerRestaurantsSection> = withContext(Dispatchers.IO){
        val populerRestaurantsSection = ArrayList<PopulerRestaurantsSection>()
        populerRestaurantsSection.addAll(listOf(
            PopulerRestaurantsSection(
                "Hey Döner",
                "heydoner_restoran",
                "Öne Çıkan",
                "50 TL Kupon: SEPETTE",
                "4.5",
                "(100+)",
                "₺▫️Minimun 90 TL▫️Döner",
                "20-35 dakika"
            ),
            PopulerRestaurantsSection(
                "Köfteci Yusuf",
                "kofteciyusuf_restoran",
                "300₺'ye 100₺",
                "Ücretsiz Teslimat",
                "3.5",
                "(3000+)",
                "₺▫️Minimun 90 TL▫️Köfte",
                "20-35 dakika"
            ),
            PopulerRestaurantsSection(
                "Pasaport Pizza",
                "pasaportpizza_restoran",
                "Süper Restoran",
                "",
                "4.0",
                "(1000+)",
                "₺▫️Minimun 90 TL▫️Pizza",
                "15-30 dakika"
            ),
            PopulerRestaurantsSection(
                "Levent Börek",
                "leventborek_restoran",
                "%10 indirim",
                "",
                "3.4",
                "(5000+)",
                "₺▫️Minimun 600 TL▫️Börek",
                "25-40 dakika"
            ),
            PopulerRestaurantsSection(
                "Pidem",
                "pidem_restoran",
                "Ücretsiz Teslimat",
                "",
                "3.9",
                "(1000+)",
                "₺▫️Minimun 90 TL▫️Pide",
                "20-35 dakika"
            ),
            PopulerRestaurantsSection(
                "Oses Çiğköfte",
                "oses_restoran",
                "Ücretsiz Teslimat",
                "%20 indirim",
                "2.8",
                "(5+)",
                "₺▫️Minimun 90 TL▫️Pide",
                "10-25 dakika"
            )
        ))
        return@withContext populerRestaurantsSection
    }

    suspend fun discoverSectionData() : List<DiscoverSection> = withContext(Dispatchers.IO){
        val discoverSection = ArrayList<DiscoverSection>()
        discoverSection.addAll(listOf(
            DiscoverSection("marketsepeti","Market", Color(0x3CEC5C86)),
            DiscoverSection("damacana","Su", Color(0x8893B2BE)),
            DiscoverSection("kasap","Kasap", Color(0x88FF96A2)),
            DiscoverSection("manav","Manav", Color(0x88A1E9A3)),
            DiscoverSection("petshop","Petshop", Color(0x88FFFAA3)),
            DiscoverSection("kuruyemis","Kuruyemiş", Color(0x88F0B5AF))
        ))

        return@withContext discoverSection
    }

}