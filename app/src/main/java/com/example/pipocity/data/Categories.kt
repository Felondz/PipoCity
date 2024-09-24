package com.example.pipocity.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import com.example.pipocity.R
import com.example.pipocity.data.local.LocalSitesDataProvider

/*Data Class wich represents a categories to visit*/

data class Categories(
    val categorySite: PipoCityNavigationCategory,
    val icon: Painter,
    val text: String
)

