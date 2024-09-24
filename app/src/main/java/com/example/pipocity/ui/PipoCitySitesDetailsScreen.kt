package com.example.pipocity.ui

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.pipocity.R
import com.example.pipocity.data.Sites

@Composable
fun PipoCityDetailsScreen(
    pipoCityUiState: PipoCityUiState,
    viewModel: PipocityViewModel,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier
) {
    BackHandler {
        onBackPressed()
        viewModel.onDetailsExpandedChange(false)}
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.inverseOnSurface)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(id = R.dimen.inner_padding))
        ) {
            PipoCityDetailsScreenTopBar(
                onBackButtonClicked = onBackPressed,
                pipoCityUiState = pipoCityUiState,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = dimensionResource(id = R.dimen.detail_expanded_subject_body_spacing))
            )
            DetailsScreenHeader(
                pipoCityUiState = pipoCityUiState,
                site = pipoCityUiState.currentSelectedSite,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun PipoCityDetailsScreenTopBar(
    onBackButtonClicked: () -> Unit,
    pipoCityUiState: PipoCityUiState,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = onBackButtonClicked,
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.detail_topbar_padding_bottom))
                .background(MaterialTheme.colorScheme.surface, shape = MaterialTheme.shapes.small)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back"
            )
        }
        Text(
            text = stringResource(pipoCityUiState.currentSelectedSite.siteName),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

    }
}

@Composable
fun DetailsScreenHeader(
    pipoCityUiState: PipoCityUiState,
    site: Sites,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(
                    horizontal = dimensionResource(id = R.dimen.subject_spacing),
                    vertical = dimensionResource(id = R.dimen.detail_subject_padding_end)
                ),
            verticalArrangement = Arrangement.Center
        ) {
            AnimatedVisibility(visible = !pipoCityUiState.isDetailsExpanded) {
                ImageSite(
                    drawableResource = site.siteImage,
                    description = stringResource(id = site.siteName),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(320.dp)
                )
            }

            Text(
                text = stringResource(id = site.slogan),
                style = MaterialTheme.typography.labelMedium,
            )
            Text(
                text = stringResource(id = site.openingHours),
                style = MaterialTheme.typography.labelMedium,
            )
            Text(
                text = stringResource(id = site.addres),
                style = MaterialTheme.typography.labelMedium,
            )
            Text(
                text = stringResource(id = site.details),
                style = MaterialTheme.typography.labelMedium,
            )
        }
    }
}
