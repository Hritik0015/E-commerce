package com.Hritik.onlineclothingapplication.repository

import com.Hritik.onlineclothinglibrary.api.ApiRequest
import com.Hritik.onlineclothingapplication.api.UploadApi
import com.Hritik.onlineclothingapplication.api.UserApi
import com.Hritik.onlineclothingapplication.response.DeleteResponse
import com.Hritik.onlineclothingapplication.response.UploadResponse
import com.Hritik.onlineclothingapplication.response.UserDetailsResponse
import com.Hritik.onlineclothingapplication.response.UserResponse
import com.Hritik.onlineclothinglibrary.api.ServiceBuilder
import okhttp3.MultipartBody

class UserRepository: ApiRequest() {

    private val userApi = ServiceBuilder.buildService(UserApi::class.java)
    private val uploadApi = ServiceBuilder.buildService(UploadApi::class.java)

    suspend fun uploadImage(body: MultipartBody.Part): UploadResponse {
        return apiRequest {
            uploadApi.uploadImage(body)
        }
    }

    suspend fun authLogin(email: String, password: String): UserResponse {
        return apiRequest {
            userApi.authLogin(email, password)
        }
    }

    suspend fun allUsers(token: String): UserDetailsResponse {
        return apiRequest {
            userApi.allUsers(token)
        }
    }

    suspend fun deleteUser(token: String, id:String): DeleteResponse {
        return apiRequest {
            userApi.deleteUser(token, id)
        }
    }

    suspend fun newAccount(
            firstName: String,
            lastName: String,
            contact: String,
            username: String,
            email: String,
            password: String,
    ): UserResponse {
        return apiRequest {
            userApi.newAccount(firstName, lastName, contact, username, email, password)
        }
    }

    suspend fun updateUser(
            token: String,
            firstName: String,
            lastName: String,
            contact: String,
            username: String,
            email: String,
            password: String,
            image: String
    ): UserResponse {
        return apiRequest {
            userApi.updateUser(
                token,
                firstName,
                lastName,
                contact,
                username,
                email,
                password,
                image,
            )
        }
    }


}