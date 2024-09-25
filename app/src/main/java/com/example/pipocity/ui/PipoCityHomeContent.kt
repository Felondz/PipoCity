package com.example.pipocity.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.pipocity.R
import com.example.pipocity.data.Sites

@Composable
fun PipoCityListOnlycontent(
    pipoCityUiState: PipoCityUiState,
    viewModel: PipocityViewModel,
    onSitePressed: (Sites) -> Unit,
    modifier: Modifier = Modifier
) {
    val lazyState = rememberLazyListState()
    val sites = pipoCityUiState.currentCategorySite
    LaunchedEffect(pipoCityUiState.currentCategory) {
        lazyState.scrollToItem(0)
    }
    LazyColumn(
        modifier = modifier,
        state = lazyState,
        contentPadding = WindowInsets.safeDrawing.asPaddingValues(),
        verticalArrangement = Arrangement.spacedBy(
            dimensionResource(id = R.dimen.vertical_spacing)
        )
    ) {

        item {

        }
        items(sites, key = { site -> site.id }) { site ->
            PipoCitySiteListItem(
                site = site,
                selected = false,
                onCardClick = {
                    viewModel.onSiteSelected(site)
                    onSitePressed(site)
                })

        }
    }
}


@Composable
fun PipoCitySiteListItem(
    site: Sites,
    selected: Boolean,
    onCardClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = if (selected)
                MaterialTheme.colorScheme.primaryContainer
            else
                MaterialTheme.colorScheme.secondaryContainer
        ),
        onClick = onCardClick
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.inner_padding)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ImageSite(
                drawableResource = site.siteImage,
                description = stringResource(id = site.siteName),
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize()
            )

            Text(
                text = stringResource(id = site.siteName),
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier.padding(4.dp)
            )
            Text(
                text = stringResource(id = site.slogan),
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.outline,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}


@Composable
fun ImageSite(
    @DrawableRes drawableResource: Int,
    description: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth() // fillMaxWidth en el Box

    ) {
        Image(
            modifier = Modifier.clip(RoundedCornerShape(15.dp))
                ,
            painter = painterResource(drawableResource),
            contentDescription = description,

        )
    }
}

@Composable
fun PipoCityLogo(
    modifier: Modifier = Modifier,
) {
    Image(
        painter = painterResource(id = R.drawable.icono),
        contentDescription = stringResource(id = R.string.app_name),
        modifier = modifier
    )
}

