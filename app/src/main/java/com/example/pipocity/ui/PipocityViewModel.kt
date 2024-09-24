package com.example.pipocity.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pipocity.data.PipoCityNavigationCategory
import com.example.pipocity.data.Sites
import com.example.pipocity.data.local.LocalSitesDataProvider
import com.example.pipocity.ui.utils.PipoCityNavigationType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


class PipocityViewModel : ViewModel() {
    private val _UiState = MutableStateFlow(
        PipoCityUiState(

        )
    )
    val uiState: StateFlow<PipoCityUiState> = _UiState.asStateFlow()

    init {
        viewModelScope.launch {

            val categories = mapOf(
                PipoCityNavigationCategory.BARS to LocalSitesDataProvider.getBarList()
                    .toMutableList(),
                PipoCityNavigationCategory.RESTORANTS to LocalSitesDataProvider.getRestorantList()
                    .toMutableList(),
                PipoCityNavigationCategory.COFEE_SHOP to LocalSitesDataProvider.getCoffeeShopList()
                    .toMutableList(),
                PipoCityNavigationCategory.CULTURAL_SITES to LocalSitesDataProvider.getCulturalSiteList()
                    .toMutableList(),
            )
            _UiState.value = PipoCityUiState(
                categories = categories,
                currentSelectedSite = categories[PipoCityNavigationCategory.BARS]?.get(0)
                    ?: LocalSitesDataProvider.defaultSite
            )

        }
    }

    fun updateCurrentCategory(pipoCityNavigationCategory: PipoCityNavigationCategory) {
        _UiState.update {
            it.copy(
                currentCategory = pipoCityNavigationCategory
            )
        }
    }

    fun resetHomeScreenStates() {
        _UiState.update {
            it.copy(
                currentSelectedSite = it.categories[it.currentCategory]?.get(0)
                    ?: LocalSitesDataProvider.defaultSite,

                )
        }

    }

    fun onDetailsExpandedChange(isExpanded: Boolean) {
        _UiState.update { currentState ->
            currentState.copy(
                isDetailsExpanded = isExpanded,

                )
        }
    }

    fun updateNavigationType(navigationType: PipoCityNavigationType) {
        _UiState.update { currentState ->
            currentState.copy(
                navigationType = navigationType
            )
        }
    }

    fun onSiteSelected(site: Sites) {
        _UiState.update { currentState ->
            currentState.copy(currentSelectedSite = site)
        }
    }
}




