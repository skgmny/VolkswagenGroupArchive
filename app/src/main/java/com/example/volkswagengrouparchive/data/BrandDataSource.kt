package com.example.volkswagengrouparchive.data

import com.example.volkswagengrouparchive.R

object BrandDataSource {
    val brands = listOf(
        Brand(
            id = "lamborghini",
            imageRes = R.drawable.lamborghini,
            nameRes = R.string.brand_lamborghini_name,
            sloganRes = R.string.brand_lamborghini_slogan
        ),
        Brand(
            id = "bentley",
            imageRes = R.drawable.bentley,
            nameRes = R.string.brand_bentley_name,
            sloganRes = R.string.brand_bentley_slogan
        ),
        Brand(
            id = "audi",
            imageRes = R.drawable.audi,
            nameRes = R.string.brand_audi_name,
            sloganRes = R.string.brand_audi_slogan
        ),
        Brand(
            id = "volkswagen",
            imageRes = R.drawable.volkswagen,
            nameRes = R.string.brand_volkswagen_name,
            sloganRes = R.string.brand_volkswagen_slogan
        )
    )
}