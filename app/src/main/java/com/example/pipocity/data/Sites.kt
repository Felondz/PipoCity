package com.example.pipocity.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/* Data class wich contain a preview of each site information, addres, image and opening hours*/

data class Sites(
    val id: Long,
    val category: PipoCityNavigationCategory,
    @StringRes val siteName: Int,
    @StringRes val slogan: Int,
    @DrawableRes val siteImage: Int,
    @StringRes val openingHours: Int,
    @StringRes val addres: Int,
    @StringRes val details: Int,

)