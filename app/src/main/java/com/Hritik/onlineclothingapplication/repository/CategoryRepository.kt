package com.Hritik.onlineclothingapplication.repository

import com.Hritik.onlineclothingapplication.api.CategoryApi
import com.Hritik.onlineclothingapplication.api.UploadApi
import com.Hritik.onlineclothingapplication.dao.CategoryDAO
import com.Hritik.onlineclothingapplication.models.Category
import com.Hritik.onlineclothingapplication.response.*
import com.Hritik.onlineclothinglibrary.api.ApiRequest
import com.Hritik.onlineclothinglibrary.api.ServiceBuilder
import okhttp3.MultipartBody

class CategoryRepository(private val categoryDAO: CategoryDAO): ApiRequest() {
    private val categoryApi = ServiceBuilder.buildService(CategoryApi::class.java)
    private val uploadApi = ServiceBuilder.buildService(UploadApi::class.java)
    

    suspend fun uploadImage(body: MultipartBody.Part): UploadResponse {
        return apiRequest {
            uploadApi.uploadImage(body)
        }
    }

    suspend fun createCategory(
        token: String,
        name: String,
        image: String,
    ): CategoryDetailResponse {
        return apiRequest {
            categoryApi.createCategory(token, name, image)
        }
    }


    suspend fun updateCategory(
        token: String,
        id: String,
        name: String,
        image: String,
    ): CategoryDetailResponse {
        return apiRequest {
            categoryApi.updateCategory(token, id, name, image)
        }
    }


    suspend fun getCategory(): CategoryResponse {
        return apiRequest {
            categoryApi.getCategory()
        }
    }

    suspend fun getCategoryName(): CategoryNameResponse {
        return apiRequest {
            categoryApi.getCategoryName()
        }
    }

    suspend fun getCategoryId(name: String): CategoryIdResponse {
        return apiRequest {
            categoryApi.getCategoryId(name)
        }
    }

    suspend fun deleteCategory(token: String, id: String): DeleteResponse {
        return apiRequest {
            categoryApi.deleteCategory(token, id)
        }
    }

    suspend fun insertCategoryToRoom(category: Category) {
        categoryDAO.createCategory(category)
    }

    suspend fun deleteCategoryFromRoom(id: String) {
        categoryDAO.deleteCategory(id)
    }

    val retrieveCategoryFromRoom = categoryDAO.retrieveCategory()

}