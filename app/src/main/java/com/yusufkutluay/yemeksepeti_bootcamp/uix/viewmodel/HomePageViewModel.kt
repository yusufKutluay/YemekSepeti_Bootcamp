package com.yusufkutluay.yemeksepeti_bootcamp.uix.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yusufkutluay.yemeksepeti_bootcamp.data.entity.CampaignsSection
import com.yusufkutluay.yemeksepeti_bootcamp.data.entity.DiscoverSection
import com.yusufkutluay.yemeksepeti_bootcamp.data.entity.KitchenSection
import com.yusufkutluay.yemeksepeti_bootcamp.data.entity.PopulerBrandsSection
import com.yusufkutluay.yemeksepeti_bootcamp.data.entity.PopulerRestaurantsSection
import com.yusufkutluay.yemeksepeti_bootcamp.data.repo.YemekSepetiRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomePageViewModel : ViewModel() {

    var ysr = YemekSepetiRepository()
    var kitchenSection = MutableLiveData<List<KitchenSection>>()
    var campaignsSection = MutableLiveData<List<CampaignsSection>>()
    var populerBrandsSection = MutableLiveData<List<PopulerBrandsSection>>()
    var populerRestaurantsSection = MutableLiveData<List<PopulerRestaurantsSection>>()
    var discoverSection = MutableLiveData<List<DiscoverSection>>()

    init {
        kitchenSectionData()
        campaignsSectionData()
        populerBrandsSectionData()
        populerRestaurantsSectionData()
        discoverSectionData()
    }

    fun kitchenSectionData(){
        CoroutineScope(Dispatchers.Main).launch {
            kitchenSection.value = ysr.kitchenSectionData()
        }
    }

    fun campaignsSectionData(){
        CoroutineScope(Dispatchers.Main).launch {
            campaignsSection.value = ysr.campaignsSectionData()
        }
    }

    fun populerBrandsSectionData(){
        CoroutineScope(Dispatchers.Main).launch {
            populerBrandsSection.value = ysr.populerBrandsSectionData()
        }
    }

    fun populerRestaurantsSectionData(){
        CoroutineScope(Dispatchers.Main).launch {
            populerRestaurantsSection.value = ysr.populerRestaurantsSectionData()
        }
    }

    fun discoverSectionData(){
        CoroutineScope(Dispatchers.Main).launch {
            discoverSection.value = ysr.discoverSectionData() as ArrayList<DiscoverSection>
        }
    }

}