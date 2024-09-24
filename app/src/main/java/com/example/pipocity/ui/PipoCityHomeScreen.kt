package com.example.pipocity.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pipocity.R
import com.example.pipocity.data.Categories
import com.example.pipocity.data.PipoCityNavigationCategory
import com.example.pipocity.ui.utils.PipoCityNavigationType

@Composable
fun PipoCityHomeScreen(
    pipoCityUiState: PipoCityUiState,
    viewModel: PipocityViewModel,
    navController: NavHostController,
    onTabPressed: (PipoCityNavigationCategory) -> Unit
) {
    val navigationItemContentList = listOf(
        Categories(
            categorySite = PipoCityNavigationCategory.BARS,
            text = stringResource(id = R.string.bares_res),
            icon = painterResource(id = R.drawable.bar_icon_)
        ),
        Categories(
            categorySite = PipoCityNavigationCategory.COFEE_SHOP,
            text = stringResource(id = R.string.cafes_res),
            icon = painterResource(id = R.drawable.coffee_icon)
        ),
        Categories(
            categorySite = PipoCityNavigationCategory.RESTORANTS,
            text = stringResource(id = R.string.restaurantes_res),
            icon = painterResource(id = R.drawable.restaurant_icon)
        ),
        Categories(
            categorySite = PipoCityNavigationCategory.CULTURAL_SITES,
            text = stringResource(id = R.string.cultural_res),
            icon = painterResource(id = R.drawable.cultural_icon)
        ),
    )

    Scaffold(
        bottomBar = {
            when (pipoCityUiState.navigationType) {
                PipoCityNavigationType.BOTTOM_NAVIGATION -> {
                    PipoCityNavigationBottom(
                        currentTab = pipoCityUiState.currentCategory,
                        onTabPressed = onTabPressed,
                        navigationItemContentList = navigationItemContentList,
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                else -> {}
            }
        }
    ) { innerPadding ->

        when (pipoCityUiState.navigationType) {
            PipoCityNavigationType.PERMANENT_NAVIGATION_DRAWER -> {
                PermanentNavigationDrawer(
                    drawerContent = {
                        PermanentDrawerSheet(
                            modifier = Modifier.width(dimensionResource(id = R.dimen.drawer_width)),
                            drawerContentColor = MaterialTheme.colorScheme.inverseOnSurface
                        ) {
                            NavigationDrawerContent(
                                selectedDestination = pipoCityUiState.currentCategory,
                                onTabPressed = onTabPressed,
                                navigationItemContentList = navigationItemContentList
                            )
                        }
                    }
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        PipoCityAppContent(
                            navigationType = pipoCityUiState.navigationType,
                            pipoCityUiState = pipoCityUiState,
                            viewModel = viewModel,
                            navController = navController
                        )


                        PipoCityDetailsScreen(
                            pipoCityUiState = pipoCityUiState,
                            viewModel = viewModel,
                            onBackPressed = {
                                navController.popBackStack()
                            },
                            modifier = Modifier.weight(0.5f)
                        )

                    }
                }
            }

            else -> {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                ) {
                    when (pipoCityUiState.navigationType) {
                        PipoCityNavigationType.NAVIGATION_RAIL -> {
                            PipoCityNavigationRail(
                                currentTab = pipoCityUiState.currentCategory,
                                onTabPressed = onTabPressed,
                                navigationItemContentList = navigationItemContentList,
                                modifier = Modifier.wrapContentWidth() // Ancho natural
                            )
                        }

                        else -> {}
                    }

                    PipoCityAppContent(
                        navigationType = pipoCityUiState.navigationType,
                        pipoCityUiState = pipoCityUiState,
                        viewModel = viewModel,
                        navController = navController
                        // Ocupa el espacio restante
                    )
                }
            }
        }
    }
}

@Composable
fun PipoCityAppContent(
    navigationType: PipoCityNavigationType,
    pipoCityUiState: PipoCityUiState,
    viewModel: PipocityViewModel,
    navController: NavHostController
) {
    val configuration = LocalConfiguration.current

    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            Row(modifier = Modifier.fillMaxSize()) {
                PipoCityListOnlycontent(
                    pipoCityUiState = pipoCityUiState,
                    viewModel = viewModel,
                    onSitePressed = { site ->
                        viewModel.onSiteSelected(site)
                    },
                    modifier = Modifier.weight(1f)
                )
                DetailsScreenHeader(
                    pipoCityUiState = pipoCityUiState,
                    site = pipoCityUiState.currentSelectedSite,
                    modifier = Modifier.weight(1f)
                )
            }
        }

        Configuration.ORIENTATION_PORTRAIT -> {
            PipoCityListOnlycontent(
                pipoCityUiState = pipoCityUiState,
                viewModel = viewModel,
                onSitePressed = { site ->
                    viewModel.onSiteSelected(site)
                    navController.navigate("details_screen")
                },
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}


@Composable
fun PipoCityNavigationBottom(
    currentTab: PipoCityNavigationCategory,
    onTabPressed: ((PipoCityNavigationCategory) -> Unit),
    navigationItemContentList: List<Categories>,
    modifier: Modifier = Modifier
) {
    NavigationBar(modifier = modifier) {
        for (navItem in navigationItemContentList) {
            NavigationBarItem(
                selected = currentTab == navItem.categorySite,
                onClick = { onTabPressed(navItem.categorySite) },
                icon = {
                    Icon(
                        painter = navItem.icon,
                        contentDescription = navItem.text,
                        modifier = Modifier.size(24.dp)
                    )
                })
        }
    }
}

@Composable
fun PipoCityNavigationRail(
    currentTab: PipoCityNavigationCategory,
    onTabPressed: ((PipoCityNavigationCategory) -> Unit),
    navigationItemContentList: List<Categories>,
    modifier: Modifier = Modifier
) {
    NavigationRail(
        modifier = modifier
    )

    {
        for (navItem in navigationItemContentList) {
            NavigationRailItem(
                selected = currentTab == navItem.categorySite,
                onClick = { onTabPressed(navItem.categorySite) },
                icon = {
                    Icon(
                        painter = navItem.icon,
                        contentDescription = navItem.text,
                        modifier = Modifier.size(24.dp)

                    )
                },
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
private fun NavigationDrawerContent(
    selectedDestination: PipoCityNavigationCategory,
    onTabPressed: (PipoCityNavigationCategory) -> Unit,
    navigationItemContentList: List<Categories>
) {
    Column(modifier = Modifier) {
        NavigationDrawerHeader(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.drawer_padding_header))
        )
        for (navItem in navigationItemContentList) {
            NavigationDrawerItem(
                label = {
                    Text(
                        text = navItem.text,
                        modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.drawer_padding_content))
                    )
                },
                selected = selectedDestination == navItem.categorySite,
                onClick = { onTabPressed(navItem.categorySite) },
                colors = NavigationDrawerItemDefaults.colors(
                    unselectedContainerColor = Color.Transparent
                ),
                icon = {
                    Icon(
                        painter = navItem.icon,
                        contentDescription = navItem.text,
                        modifier = Modifier.size(24.dp)
                    )
                })
        }
    }
}

@Composable
fun NavigationDrawerHeader(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        PipoCityLogo(
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.topbar_profile_image_size))
        )
        Text(
            text = stringResource(id = R.string.app_name),
            modifier = Modifier.padding(start = dimensionResource(id = R.dimen.drawer_padding_header)),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}
