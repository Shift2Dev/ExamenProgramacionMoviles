package com.example.examenpmdm.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examenpmdm.data.model.ProductoDto
import com.example.examenpmdm.data.remote.RetrofitInstance
import com.example.examenpmdm.data.repository.ProductosRepository
import kotlinx.coroutines.launch

class ProductoViewModel : ViewModel() {

    private val repository = ProductosRepository(RetrofitInstance.api)
    var state by mutableStateOf<UiState<List<ProductoDto>>>(UiState.Loading)
        private set

    init {
        loadProductos() // Sin parámetros
    }

    fun loadProductos() { // Quitamos el page: Int
        viewModelScope.launch {
            state = UiState.Loading
            state = try {
                UiState.Success(repository.getProductos())
            } catch (e: Exception) {
                UiState.Error(e.message ?: "Error cargando productos")
            }
        }
    }
}