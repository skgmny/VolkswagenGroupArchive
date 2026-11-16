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
            specsRes = R.string.vehicle_revuelto_specs,
            detailRes = R.string.vehicle_revuelto_detail
        ),
        Vehicle(
            id = "temerario",
            brandId = "lamborghini",
            imageRes = R.drawable.lamborghini_temerario,
            nameRes = R.string.vehicle_temerario_name,
            descriptionRes = R.string.vehicle_temerario_description,
            specsRes = R.string.vehicle_temerario_specs,
            detailRes = R.string.vehicle_temerario_detail
        ),

    //일단 차는 각 두개? 세개만 하자.. 생각보다 시간이...ㅜ0ㅜ
        Vehicle(
            id = "continental_gt",
            brandId = "bentley",
            imageRes = R.drawable.bentley_continential_gt,
            nameRes = R.string.vehicle_continental_gt_name,
            descriptionRes = R.string.vehicle_continental_gt_description,
            specsRes = R.string.vehicle_continental_gt_specs,
            detailRes = R.string.vehicle_continental_gt_detail
        ),

        Vehicle(
            id = "bentayga_v8",
            brandId = "bentley",
            imageRes = R.drawable.bentley_bentayga,
            nameRes = R.string.vehicle_bentayga_name,
            descriptionRes = R.string.vehicle_bentayga_description,
            specsRes = R.string.vehicle_bentayga_specs,
            detailRes = R.string.vehicle_bentayga_detail
        ),
        Vehicle(
            id = "rs_etron_performance",
            brandId = "audi",
            imageRes = R.drawable.audi_rs_etron,
            nameRes = R.string.vehicle_rs_etron_name,
            descriptionRes = R.string.vehicle_rs_etron_description,
            specsRes = R.string.vehicle_rs_etron_specs,
            detailRes = R.string.vehicle_rs_etron_detail
        ),
        Vehicle(
            id = "rs_q8_performance",
            brandId = "audi",
            imageRes = R.drawable.audi_rs_q8,
            nameRes = R.string.vehicle_rs_q8_name,
            descriptionRes = R.string.vehicle_rs_q8_description,
            specsRes = R.string.vehicle_rs_q8_specs,
            detailRes = R.string.vehicle_rs_q8_detail
        ),

        Vehicle(
            id = "golf_gti",
            brandId = "volkswagen",
            imageRes = R.drawable.volkswagen_golf_gti,
            nameRes = R.string.vehicle_golf_gti_name,
            descriptionRes = R.string.vehicle_golf_gti_description,
            specsRes = R.string.vehicle_golf_gti_specs,
            detailRes = R.string.vehicle_golf_gti_detail
        ),
        Vehicle(
            id = "tiguan_etsi",
            brandId = "volkswagen",
            imageRes = R.drawable.volkswagen_tiguan,
            nameRes = R.string.vehicle_tiguan_name,
            descriptionRes = R.string.vehicle_tiguan_description,
            specsRes = R.string.vehicle_tiguan_specs,
            detailRes = R.string.vehicle_tiguan_detail
        )


    )
}