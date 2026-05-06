package com.devshady.githubapidemo.ui.products

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun ProductsList(
    uiState: ProductListViewModel.UiState
) {


    when (uiState) {
        is ProductListViewModel.UiState.Error -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(uiState.message)
            }
        }
        ProductListViewModel.UiState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Loading")
            }
        }

        is ProductListViewModel.UiState.Success -> {
            LazyColumn() {
                items(uiState.data) { product ->
                    ProductListItem(product)
                }
            }
        }
    }
}