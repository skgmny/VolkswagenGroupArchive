package com.example.volkswagengrouparchive.ui

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.volkswagengrouparchive.data.VehicleDataSource

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
}