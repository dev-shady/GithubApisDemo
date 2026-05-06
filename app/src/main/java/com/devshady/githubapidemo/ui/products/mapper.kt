package com.devshady.githubapidemo.ui.products

import com.devshady.githubapidemo.domain.Product


fun Product.toView(): ProductListViewModel.ProductView {
    return ProductListViewModel.ProductView(
        title
    )
}