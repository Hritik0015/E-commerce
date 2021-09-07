package com.Hritik.onlineclothingapplication.response

import com.Hritik.onlineclothingapplication.models.Users

data class UserDetailsResponse(
    val success: Boolean,
    val users: List<Users>
)