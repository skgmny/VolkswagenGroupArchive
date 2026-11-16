package com.example.volkswagengrouparchive.ui

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.volkswagengrouparchive.data.VehicleDataSource
import com.example.volkswagengrouparchive.data.BrandDataSource

class GroupViewModel : ViewModel() {
    val selectedBrandVehicles
        get() = VehicleDataSource.vehicles.filter { vehicle ->
            vehicle.brandId == selectedBrandId
        }
    var selectedBrandId by mutableStateOf<String?>(null)
        private set

    fun selectBrand(brandId: String) {
        selectedBrandId = brandId
    }
    var selectedVehicleId by mutableStateOf<String?>(null)
        private set

    fun selectVehicle(vehicleId: String) {
        selectedVehicleId = vehicleId
    }

    val selectedVehicle
        get() = VehicleDataSource.vehicles.find { vehicle ->
            vehicle.id == selectedVehicleId
        }

    var favoriteVehicleIds by mutableStateOf(setOf<String>())
        private set

    fun toggleFavorite(vehicleId: String) {
        favoriteVehicleIds = if (vehicleId in favoriteVehicleIds) {
            favoriteVehicleIds - vehicleId
        } else {
            favoriteVehicleIds + vehicleId
        }
    }

    val brands = BrandDataSource.brands
}