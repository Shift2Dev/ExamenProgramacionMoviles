package com.example.examenpmdm.data.remote

import com.example.examenpmdm.data.model.ProductResponse
import retrofit2.http.GET

interface PeticionesOnlineProductos {
    @GET("products")
    suspend fun getProducts(): ProductResponse
}