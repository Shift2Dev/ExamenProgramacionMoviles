package com.example.examenpmdm.data.repository

import com.example.examenpmdm.data.model.ProductoDto
import com.example.examenpmdm.data.remote.PeticionesOnlineProductos

class ProductosRepository(private val api: PeticionesOnlineProductos) {

    suspend fun getProductos(): List<ProductoDto> {
        val response = api.getProducts()
        return response.results
    }
}