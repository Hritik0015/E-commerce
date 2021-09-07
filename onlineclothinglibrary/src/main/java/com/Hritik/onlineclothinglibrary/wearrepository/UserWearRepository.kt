package com.Hritik.onlineclothinglibrary.wearrepository

import com.Hritik.onlineclothingapplication.response.UserWearResponse
import com.Hritik.onlineclothinglibrary.api.ServiceBuilder
import com.Hritik.onlineclothinglibrary.api.UserWearApi


import com.Hritik.onlineclothinglibrary.api.ApiRequest


class UserWearRepository: ApiRequest() {

    private val userApi = ServiceBuilder.buildService(UserWearApi::class.java)



    suspend fun authLogin(email: String, password: String): UserWearResponse {
        return apiRequest {
            userApi.authLogin(email, password)
        }
    }







}