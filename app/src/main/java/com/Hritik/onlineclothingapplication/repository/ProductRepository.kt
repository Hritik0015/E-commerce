package com.Hritik.onlineclothingapplication.repository


import com.Hritik.onlineclothingapplication.api.ProductApi
import com.Hritik.onlineclothingapplication.api.UploadApi
import com.Hritik.onlineclothingapplication.dao.ProductDAO
import com.Hritik.onlineclothingapplication.models.Product
import com.Hritik.onlineclothingapplication.response.DeleteResponse
import com.Hritik.onlineclothingapplication.response.ProductDetailResponse
import com.Hritik.onlineclothingapplication.response.ProductResponse
import com.Hritik.onlineclothingapplication.response.UploadResponse
import com.Hritik.onlineclothinglibrary.api.ApiRequest
import com.Hritik.onlineclothinglibrary.api.ServiceBuilder
import okhttp3.MultipartBody

class ProductRepository(private val productDAO: ProductDAO) : ApiRequest() {

    private val productApi = ServiceBuilder.buildService(ProductApi::class.java)
    private val uploadApi = ServiceBuilder.buildService(UploadApi::class.java)

    suspend fun uploadImage(body: MultipartBody.Part): UploadResponse {
        return apiRequest {
            uploadApi.uploadImage(body)
        }
    }


    suspend fun addProduct(token: String): ProductDetailResponse {
        return apiRequest {
            productApi.addProduct(token)
        }
    }

    suspend fun updateProduct(
        token: String,
        id: String,
        name: String,
        price: Double,
        description: String,
        image: String,
        brand: String,
        category: String,
        countInStock: Int
    ): ProductDetailResponse {
        return apiRequest {
            productApi.updateProduct(token, id, name, price, description, image, brand, category, countInStock)
        }
    }

    suspend fun deleteProduct(token: String, id: String): DeleteResponse {
        return apiRequest {
            productApi.deleteProduct(token, id)
        }
    }

    suspend fun getProductsOfCategory(id: String): ProductResponse {
        return apiRequest {
            productApi.getProductsOfCategory(id)
        }
    }

    suspend fun getProductById(id: String): ProductDetailResponse {
        return apiRequest {
            productApi.getProductById(id)
        }
    }

    suspend fun getAllProducts(): ProductResponse {
        return apiRequest {
            productApi.getAllProducts()
        }
    }

    suspend fun insertProductIntoRoom(product: Product) {
        productDAO.createProduct(product)
    }


    suspend fun deleteProductFromRoom(id: String) {
        productDAO.deleteProduct(id)
    }

    val retrieveProductsFromRoom = productDAO.retrieveProducts()
    fun retrieveProductByIdFromRoom(id:String) = productDAO.retrieveProductById(id)
    fun retrieveCategorizedProductsFromRoom(category: String) = productDAO.retrieveProductsOfCategory(category)

}