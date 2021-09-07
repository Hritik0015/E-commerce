package com.Hritik.onlineclothingapplication.response

import com.Hritik.onlineclothingapplication.models.UserProfile

data class UserResponse (
        val success: Boolean,
        val userProfile: UserProfile
)