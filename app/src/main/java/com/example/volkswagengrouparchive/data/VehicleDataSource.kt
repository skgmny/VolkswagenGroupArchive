package com.example.volkswagengrouparchive.data

import com.example.volkswagengrouparchive.R

object VehicleDataSource {
    val vehicles = listOf(
        Vehicle(
            id = "revuelto",
            brandId = "lamborghini",
            imageRes = R.drawable.lamborghini_revuelto,
            nameRes = R.string.vehicle_revuelto_name,
            descriptionRes = R.string.vehicle_revuelto_description,
            specsRes = R.string.vehicle_revuelto_specs
        )
    )
}