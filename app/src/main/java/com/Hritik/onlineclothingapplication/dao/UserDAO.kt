package com.Hritik.onlineclothingapplication.dao

import androidx.room.Dao
import androidx.room.Insert
import com.Hritik.onlineclothingapplication.entities.User

@Dao
interface UserDAO {
    @Insert
    suspend fun insertUser(user: User)

}