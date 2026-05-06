package com.devshady.githubapidemo.ui.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devshady.githubapidemo.domain.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    val repository: ProductsRepository
): ViewModel() {

    data class ProductView(
        val title: String
    )

    sealed class UiState {
        object Loading: UiState()
        data class Error(val message: String): UiState()
        data class Success(val data: List<ProductView>): UiState()
    }

    //TODO expose flow to UI through repoistory
    val uiState: StateFlow<UiState> = repository.getProducts().map { products ->
        UiState.Success(products.map { it.toView()  })
    }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = UiState.Loading
        )
}