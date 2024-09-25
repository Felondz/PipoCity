package com.example.pipocity.data.local

import com.example.pipocity.R
import com.example.pipocity.data.PipoCityNavigationCategory
import com.example.pipocity.data.Sites

object LocalSitesDataProvider {
val defaultSite = Sites(
    id = 1,
    category = PipoCityNavigationCategory.BARS,
    siteName = R.string.bar_01,
    slogan = R.string.bar_01_Slogan,
    siteImage = R.drawable.bar_01,
    openingHours = R.string.bar_01_horario,
    addres = R.string.bar_01_direccion,
    details = R.string.bar_01_detalles,
)


    private val sites = listOf(
        Sites(
            id = 1,
            category = PipoCityNavigationCategory.BARS,
            siteName = R.string.bar_01,
            slogan = R.string.bar_01_Slogan,
            siteImage = R.drawable.bar_01,
            openingHours = R.string.bar_01_horario,
            addres = R.string.bar_01_direccion,
            details = R.string.bar_01_detalles,
        ),
        Sites(
            id = 2,
            category = PipoCityNavigationCategory.BARS,
            siteName = R.string.bar_02,
            slogan = R.string.bar_02_slogan,
            siteImage = R.drawable.cultural_01,
            openingHours = R.string.bar_02_horario,
            addres = R.string.bar_02_direccion,
            details = R.string.bar_02_detalles,
        ),
        Sites(
            id = 3,
            category = PipoCityNavigationCategory.BARS,
            siteName = R.string.bar_03,
            slogan = R.string.bar_03_slogan,
            siteImage = R.drawable.bar_03,
            openingHours = R.string.bar_03_horario,
            addres = R.string.bar_03_direccion,
            details = R.string.bar_03_detalles,
        ),
        Sites(
            id = 4,
            category = PipoCityNavigationCategory.BARS,
            siteName = R.string.bar_04,
            slogan = R.string.bar_04_slogan,
            siteImage = R.drawable.bar_04,
            openingHours = R.string.bar_04_horario,
            addres = R.string.bar_04_direccion,
            details = R.string.bar_04_detalles,
        ),
        Sites(
            id = 5,
            category = PipoCityNavigationCategory.BARS,
            siteName = R.string.bar_05,
            slogan = R.string.bar_05_slogan,
            siteImage = R.drawable.bar_05,
            openingHours = R.string.bar_05_horario,
            addres = R.string.bar_05_direccion,
            details = R.string.bar_05_detalles,
        ),

        Sites(
            id = 6,
            category = PipoCityNavigationCategory.COFEE_SHOP,
            siteName = R.string.cafe_01,
            slogan = R.string.cafe_01_slogan,
            siteImage = R.drawable.cafe_01,
            openingHours = R.string.cafe_01_horario,
            addres = R.string.cafe_01_direccion,
            details = R.string.cafe_01_detalles,
        ),
        Sites(
            id = 7,
            category = PipoCityNavigationCategory.COFEE_SHOP,
            siteName = R.string.cafe_02,
            slogan = R.string.cafe_02_slogan,
            siteImage = R.drawable.cafe_02,
            openingHours = R.string.cafe_02_horario,
            addres = R.string.cafe_02_direccion,
            details = R.string.cafe_02_detalles,
        ),
        Sites(
            id = 8,
            category = PipoCityNavigationCategory.COFEE_SHOP,
            siteName = R.string.cafe_03,
            slogan = R.string.cafe_03_slogan,
            siteImage = R.drawable.cafe_03,
            openingHours = R.string.cafe_03_horario,
            addres = R.string.cafe_03_direccion,
            details = R.string.cafe_03_detalles,
        ),
        Sites(
            id = 9,
            category = PipoCityNavigationCategory.COFEE_SHOP,
            siteName = R.string.cafe_04,
            slogan = R.string.cafe_04_slogan,
            siteImage = R.drawable.cafe_04,
            openingHours = R.string.cafe_04_horario,
            addres = R.string.cafe_04_direccion,
            details = R.string.cafe_04_detalles,
        ),
        Sites(
            id = 10,
            category = PipoCityNavigationCategory.COFEE_SHOP,
            siteName = R.string.cafe_05,
            slogan = R.string.cafe_05_slogan,
            siteImage = R.drawable.cafe_05,
            openingHours = R.string.cafe_05_horario,
            addres = R.string.cafe_05_direccion,
            details = R.string.cafe_05_detalles,
        ),


        Sites(
            id = 11,
            category = PipoCityNavigationCategory.RESTORANTS,
            siteName = R.string.resto_01,
            slogan = R.string.resto_01_slogan,
            siteImage = R.drawable.restaurante_01,
            openingHours = R.string.resto_01_horario,
            addres = R.string.resto_01_direccion,
            details = R.string.resto_01_detalles,
        ),
        Sites(
            id = 12,
            category = PipoCityNavigationCategory.RESTORANTS,
            siteName = R.string.resto_02,
            slogan = R.string.resto_02_slogan,
            siteImage = R.drawable.restaurante_02,
            openingHours = R.string.resto_02_horario,
            addres = R.string.resto_02_direccion,
            details = R.string.resto_02_detalles,
        ),
        Sites(
            id = 13,
            category = PipoCityNavigationCategory.RESTORANTS,
            siteName = R.string.resto_03,
            slogan = R.string.resto_03_slogan,
            siteImage = R.drawable.restaurante_03,
            openingHours = R.string.resto_03_horario,
            addres = R.string.resto_03_direccion,
            details = R.string.resto_03_detalles,
        ),
        Sites(
            id = 15,
            category = PipoCityNavigationCategory.RESTORANTS,
            siteName = R.string.resto_04,
            slogan = R.string.resto_04_slogan,
            siteImage = R.drawable.restaurante_04,
            openingHours = R.string.resto_04_horario,
            addres = R.string.resto_04_direccion,
            details = R.string.resto_04_detalles,
        ),
        Sites(
            id = 16,
            category = PipoCityNavigationCategory.RESTORANTS,
            siteName = R.string.resto_05,
            slogan = R.string.resto_05_slogan,
            siteImage = R.drawable.restaurante_05,
            openingHours = R.string.resto_05_horario,
            addres = R.string.resto_05_direccion,
            details = R.string.resto_05_detalles,
        ),


        Sites(
            id = 17,
            category = PipoCityNavigationCategory.CULTURAL_SITES,
            siteName = R.string.cultural_01,
            slogan = R.string.cultural_01_slogan,
            siteImage = R.drawable.cultural_01,
            openingHours = R.string.cultural_01_horario,
            addres = R.string.cultural_01_direccion,
            details = R.string.cultural_01_detalles,
        ),
        Sites(
            id = 18,
            category = PipoCityNavigationCategory.CULTURAL_SITES,
            siteName = R.string.cultural_02,
            slogan = R.string.cultural_02_slogan,
            siteImage = R.drawable.cultural_02,
            openingHours = R.string.cultural_02_horario,
            addres = R.string.cultural_02_direccion,
            details = R.string.cultural_02_detalles,
        ),
        Sites(
            id = 19,
            category = PipoCityNavigationCategory.CULTURAL_SITES,
            siteName = R.string.cultural_03,
            slogan = R.string.cultural_03_slogan,
            siteImage = R.drawable.cultural_03,
            openingHours = R.string.cultural_03_horario,
            addres = R.string.cultural_03_direccion,
            details = R.string.cultural_03_detalles,
        ),
        Sites(
            id = 20,
            category = PipoCityNavigationCategory.CULTURAL_SITES,
            siteName = R.string.cultural_04,
            slogan = R.string.cultural_04_slogan,
            siteImage = R.drawable.cultural_04,
            openingHours = R.string.cultural_04_horario,
            addres = R.string.cultural_04_direccion,
            details = R.string.cultural_04_detalles,
        ),
        Sites(
            id = 21,
            category = PipoCityNavigationCategory.CULTURAL_SITES,
            siteName = R.string.cultural_05,
            slogan = R.string.cultural_05_slogan,
            siteImage = R.drawable.cultural_05,
            openingHours = R.string.cultural_05_horario,
            addres = R.string.cultural_05_direccion,
            details = R.string.cultural_05_detalles,
        )
    )

    fun get(id: Long): Sites? {
        return sites.firstOrNull { it.id == id }
    }
    fun getBarList():List<Sites>{
       return sites.filter { it.category == PipoCityNavigationCategory.BARS }
    }
    fun getRestorantList():List<Sites>{
        return sites.filter { it.category == PipoCityNavigationCategory.RESTORANTS }
    }
    fun getCoffeeShopList():List<Sites>{
        return sites.filter { it.category == PipoCityNavigationCategory.COFEE_SHOP }
    }
    fun getCulturalSiteList():List<Sites>{
        return sites.filter { it.category == PipoCityNavigationCategory.CULTURAL_SITES }
    }
}