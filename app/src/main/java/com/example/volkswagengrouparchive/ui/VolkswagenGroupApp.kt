package com.example.volkswagengrouparchive.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.volkswagengrouparchive.R
import com.example.volkswagengrouparchive.data.BrandDataSource
import com.example.volkswagengrouparchive.data.Vehicle
import com.example.volkswagengrouparchive.ui.theme.VolkswagenGroupArchiveTheme
import com.example.volkswagengrouparchive.data.Brand

@Preview(showBackground = true)
@Composable
fun GroupTopAppBarPreview() {
    VolkswagenGroupArchiveTheme {
        GroupTopAppBar(
            onBackClick = {},
            onHomeClick = {}
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun BrandListScreenPreview() {
//    VolkswagenGroupArchiveTheme {
//        BrandListScreen( onBrandClick = {}
//        )
//    }
//}

@Preview(showBackground = true)
@Composable
fun VehicleCardPreview() {
    VolkswagenGroupArchiveTheme {
        VehicleCard(
            imageRes = R.drawable.lamborghini_revuelto,
            nameRes = R.string.vehicle_revuelto_name,
            descriptionRes = R.string.vehicle_revuelto_description,
            specsRes = R.string.vehicle_revuelto_specs,
            isFavorite = true,
            onFavoriteClick = {},
            onClick = {},
        )
    }
}


//시작//
@Composable
fun VolkswagenGroupApp(
    groupViewModel: GroupViewModel = viewModel()
) {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            GroupTopAppBar(
                onBackClick = {
                    navController.navigateUp()
                },
                onHomeClick = {
                    navController.popBackStack(
                        route = "brands",
                        inclusive = false
                    )
                }
            )
        },
        content = { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = "brands",
                modifier = Modifier.padding(innerPadding),
                builder = {
                    composable(route = "brands") {
                        BrandListScreen(
                            brands = groupViewModel.brands,
                            onBrandClick = { brandId ->
                                groupViewModel.selectBrand(brandId)
                                navController.navigate("vehicles")
                            }
                        )
                    }

                    composable(route = "vehicles") {
                        VehicleListScreen(
                            vehicles = groupViewModel.selectedBrandVehicles,
                            onVehicleClick = { vehicleId ->
                                groupViewModel.selectVehicle(vehicleId)
                                navController.navigate("detail")
                            },
                            favoriteVehicleIds = groupViewModel.favoriteVehicleIds,
                            onFavoriteClick = { vehicleId ->
                                groupViewModel.toggleFavorite(vehicleId)
                            }
                        )
                    }

                    composable(route = "detail") {
                        val vehicle = groupViewModel.selectedVehicle

                        if (vehicle != null) {
                            VehicleDetailScreen(
                                vehicle = vehicle,
                                isFavorite = vehicle.id in groupViewModel.favoriteVehicleIds,
                                onFavoriteClick = {
                                    groupViewModel.toggleFavorite(vehicle.id)
                                }
                            )
                        }
                    }
                }
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GroupTopAppBar(
    onBackClick: () -> Unit,
    onHomeClick: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.group_title),
                fontFamily = FontFamily(
                    Font(R.font.songmyung_regular)
                )
            )
        },
        navigationIcon = {
            IconButton(
                onClick = onBackClick
                // 나중에 뒤로가기 동작 연결

            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.navigate_back)
                )
            }
        },
        actions = {
            IconButton(
                onClick = onHomeClick
                // 나중에 홈으로 이동하는 동작 연결

            ) {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = stringResource(R.string.navigate_home)
                )
            }
        }
    )
}

@Composable
fun BrandListScreen(
    modifier: Modifier = Modifier,
    brands: List<Brand>,
    onBrandClick: (String) -> Unit
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(
            dimensionResource(R.dimen.brand_list_padding)
        ),
        verticalArrangement = Arrangement.spacedBy(
            dimensionResource(R.dimen.brand_card_spacing)
        ),
        content ={
            items(brands) { brand ->
                BrandCard(
                    imageRes = brand.imageRes,
                    nameRes = brand.nameRes,
                    sloganRes = brand.sloganRes,
                    onClick = {
                        onBrandClick(brand.id)
                    }

                )
            }
        }
    )
}

@Composable
fun BrandCard(
    modifier: Modifier = Modifier,
    imageRes: Int,
    nameRes: Int,
    sloganRes: Int,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        content = {
            Row (
                modifier = Modifier.padding(
                    dimensionResource(R.dimen.brand_card_padding)
                ),
                horizontalArrangement = Arrangement.spacedBy(
                    dimensionResource(R.dimen.brand_image_text_spacing)
                ),
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(imageRes),
                    contentDescription = stringResource(nameRes),
                    modifier = Modifier.size(
                        dimensionResource(R.dimen.brand_image_size)
                    )
                )

                Column (
                    verticalArrangement = Arrangement.spacedBy(
                        dimensionResource(R.dimen.brand_text_spacing)
                    )
                ){
                    Text(
                        text = stringResource(nameRes),
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = stringResource(sloganRes),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    )
}

@Composable
fun VehicleListScreen(
    modifier: Modifier = Modifier,
    vehicles: List<Vehicle>,
    onVehicleClick: (String) -> Unit,
    favoriteVehicleIds: Set<String>,
    onFavoriteClick: (String) -> Unit
) {
    LazyColumn(
        modifier = modifier,
        content = {
            items(vehicles) { vehicle ->
                VehicleCard(
                    modifier = Modifier.padding(
                        bottom = dimensionResource(R.dimen.vehicle_card_bottom_spacing)
                    ),
                    imageRes = vehicle.imageRes,
                    nameRes = vehicle.nameRes,
                    descriptionRes = vehicle.descriptionRes,
                    specsRes = vehicle.specsRes,
                    isFavorite = vehicle.id in favoriteVehicleIds,
                    onFavoriteClick = {
                        onFavoriteClick(vehicle.id)
                    },
                    onClick = {
                        onVehicleClick(vehicle.id)
                    }
                )
            }
        }
    )
}

@Composable
fun VehicleCard(
    modifier: Modifier = Modifier,
    imageRes: Int,
    nameRes: Int,
    descriptionRes: Int,
    specsRes: Int,
    isFavorite: Boolean,
    onClick: () -> Unit,
    onFavoriteClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        content = {
            Column {
                Image(
                    painter = painterResource(imageRes),
                    contentDescription = stringResource(nameRes),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(
                            dimensionResource(R.dimen.vehicle_image_height)
                        ),
                    contentScale = ContentScale.Crop
                )

                Column(
                    modifier = Modifier.padding(
                        dimensionResource(R.dimen.vehicle_card_content_padding)
                    )
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Top
                    ) {
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = stringResource(nameRes),
                                style = MaterialTheme.typography.titleMedium
                            )

                            Text(
                                text = stringResource(descriptionRes),
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }

                        FavoriteButton(
                            isFavorite = isFavorite,
                            onClick = onFavoriteClick
                        )
                    }

                    Text(
                        text = stringResource(specsRes),
                        style = MaterialTheme.typography.bodyMedium,
                        fontFamily = FontFamily(
                            Font(R.font.orbitron)
                        ),
                        modifier = Modifier.padding(
                            top = dimensionResource(
                                R.dimen.vehicle_description_spacing
                            )
                        )
                    )
                }
            }
        }
    )
}

@Composable
fun FavoriteButton(
    isFavorite: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        modifier = modifier,
        onClick = onClick
    ){
        Icon(
            modifier = Modifier.size(
                dimensionResource(R.dimen.favorite_icon_size)
            ),
            imageVector = if (isFavorite) {
                Icons.Filled.Star
            } else {
                Icons.Outlined.StarBorder
            },
            contentDescription = stringResource(
                if (isFavorite) {
                    R.string.remove_from_favorites
                } else {
                    R.string.add_to_favorites
                }
            )
        )
    }
}

@Composable
fun VehicleDetailScreen(
    modifier: Modifier = Modifier,
    vehicle: Vehicle,
    isFavorite: Boolean,
    onFavoriteClick: () -> Unit
) {
    LazyColumn(
        modifier = modifier,
        content = {
            item {
                Text(
                    text = stringResource(R.string.vehicle_detail_heading),
                    fontFamily = FontFamily(
                        Font(R.font.songmyung_regular)
                    )
                )
            }
            item {
                VehicleCard(
                    imageRes = vehicle.imageRes,
                    nameRes = vehicle.nameRes,
                    descriptionRes = vehicle.descriptionRes,
                    specsRes = vehicle.specsRes,
                    isFavorite = isFavorite,
                    onFavoriteClick = onFavoriteClick,
                    onClick = {}
                )
            }
            item {
                Text(
                    text = stringResource(vehicle.detailRes),
                    style = MaterialTheme.typography.bodyLarge,
                    fontFamily = FontFamily(
                        Font(R.font.songmyung_regular)
                    ),
                    modifier = Modifier.padding(
                        dimensionResource(R.dimen.vehicle_card_content_padding)
                    )
                )
            }
        }
    )
}