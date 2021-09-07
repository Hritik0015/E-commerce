package com.Hritik.onlineclothingapplication.eventlistener

import com.Hritik.onlineclothingapplication.models.Product

interface OnAdminProductClickListener {
    fun onProductEditClick(position: Int, product: Product)
    fun onProductDeleteClick(position: Int, productId: String)
}