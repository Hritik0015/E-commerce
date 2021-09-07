package com.Hritik.onlineclothingapplication.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.Hritik.onlineclothingapplication.models.Product


@Dao
interface ProductDAO {

    @Query("SELECT * FROM Product")
    fun retrieveProducts():LiveData<List<Product>>

    @Query("SELECT * FROM Product WHERE _id=(:id)")
    fun retrieveProductById(id: String):LiveData<Product>

    @Query("SELECT * FROM Product WHERE category LIKE '%' || :category || '%'")
    fun retrieveProductsOfCategory(category: String):LiveData<List<Product>>

    @Insert(onConflict = OnConflictStrategy.IGNORE )
    suspend fun createProduct(product: Product)

    @Query("DELETE FROM Product WHERE _id=(:id)")
    suspend fun deleteProduct(id: String)

    @Update
    suspend fun updateProduct(product: Product)


}