package com.Hritik.onlineclothingapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.Hritik.onlineclothingapplication.dao.CategoryDAO
import com.Hritik.onlineclothingapplication.dao.ProductDAO
import com.Hritik.onlineclothingapplication.dao.UserDAO
import com.Hritik.onlineclothingapplication.entities.User
import com.Hritik.onlineclothingapplication.models.Category
import com.Hritik.onlineclothingapplication.models.Product
import com.Hritik.onlineclothingapplication.utils.Converters


@Database(
        entities = [Product::class, Category::class, User::class],
        version = 1,
        exportSchema = false
)
@TypeConverters(Converters::class)
abstract class OnlineClothingDB: RoomDatabase() {
    abstract val productDAO: ProductDAO
    abstract val categoryDAO: CategoryDAO
    abstract val userDAO: UserDAO

    companion object {

        @Volatile
        private var INSTANCE: OnlineClothingDB? = null

        fun getInstance(context: Context): OnlineClothingDB {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                            context.applicationContext,
                            OnlineClothingDB::class.java,
                            "online_clothing_database"
                    ).build()
                }
                return instance
            }
        }
    }
}