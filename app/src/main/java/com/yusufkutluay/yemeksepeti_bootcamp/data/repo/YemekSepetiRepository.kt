package com.yusufkutluay.yemeksepeti_bootcamp.data.repo

import com.yusufkutluay.yemeksepeti_bootcamp.data.datasource.YemekSepetiDataSource
import com.yusufkutluay.yemeksepeti_bootcamp.data.entity.CampaignsSection
import com.yusufkutluay.yemeksepeti_bootcamp.data.entity.DiscoverSection
import com.yusufkutluay.yemeksepeti_bootcamp.data.entity.KitchenSection
import com.yusufkutluay.yemeksepeti_bootcamp.data.entity.PopulerBrandsSection
import com.yusufkutluay.yemeksepeti_bootcamp.data.entity.PopulerRestaurantsSection

class YemekSepetiRepository {

    var yds = YemekSepetiDataSource()

    suspend fun kitchenSectionData() : List<KitchenSection> = yds.kitchenSectionData()

    suspend fun campaignsSectionData() : List<CampaignsSection> = yds.campaignsSectionData()

    suspend fun populerBrandsSectionData() : List<PopulerBrandsSection> = yds.populerBrandsSectionData()

    suspend fun populerRestaurantsSectionData() : List<PopulerRestaurantsSection> = yds.populerRestaurantsSectionData()

    suspend fun discoverSectionData() : List<DiscoverSection> = yds.discoverSectionData()
}