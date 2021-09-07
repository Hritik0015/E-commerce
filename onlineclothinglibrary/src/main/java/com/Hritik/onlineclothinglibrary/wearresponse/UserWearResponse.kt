package com.Hritik.onlineclothingapplication.response

import com.Hritik.onlineclothingapplication.models.UserProfile

data class UserWearResponse (
        val success: Boolean,
        val userProfile: UserProfile
)