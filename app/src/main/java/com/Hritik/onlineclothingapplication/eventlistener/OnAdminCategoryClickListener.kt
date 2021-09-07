package com.Hritik.onlineclothingapplication.eventlistener

import com.Hritik.onlineclothingapplication.models.Category

interface OnAdminCategoryClickListener {
    fun onProductEditClick(position: Int, category: Category)
    fun onProductDeleteClick(position: Int, categoryId: String)
}