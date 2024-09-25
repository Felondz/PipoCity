package com.example.pipocity.data

import androidx.compose.ui.graphics.painter.Painter

/*Data Class wich represents a categories to visit*/

data class Categories(
    val categorySite: PipoCityNavigationCategory,
    val icon: Painter,
    val text: String
)

