package com.example.pipocity.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class SitePreview(
    @StringRes val siteName: Int,
    @StringRes val slogan: Int,
    @DrawableRes val siteImage: Int,
)
