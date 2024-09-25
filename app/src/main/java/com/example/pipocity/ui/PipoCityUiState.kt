package com.example.pipocity.ui

import com.example.pipocity.data.Categories
import com.example.pipocity.data.PipoCityNavigationCategory
import com.example.pipocity.data.Sites
import com.example.pipocity.data.local.LocalSitesDataProvider
import com.example.pipocity.data.local.LocalSitesDataProvider.defaultSite
import com.example.pipocity.ui.utils.PipoCityNavigationType

data class PipoCityUiState(
    val categories: Map<PipoCityNavigationCategory, List<Sites>> = emptyMap(),
    val currentCategory: PipoCityNavigationCategory = PipoCityNavigationCategory.BARS,
    val currentSelectedSite: Sites = defaultSite,
    val navigationType: PipoCityNavigationType = PipoCityNavigationType.BOTTOM_NAVIGATION,
    val isDetailsExpanded: Boolean = false,
){
    val currentCategorySite: List<Sites> by lazy {categories[currentCategory]!! }
}
