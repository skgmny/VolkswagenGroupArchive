package com.example.volkswagengrouparchive

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.volkswagengrouparchive.ui.theme.VolkswagenGroupArchiveTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material.icons.filled.Home
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.compose.composable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.size
import androidx.compose.ui.res.dimensionResource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.Alignment



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VolkswagenGroupArchiveTheme {
                    VolkswagenGroupApp()
                }
            }
        }
    }

@Preview(showBackground = true)
@Composable
fun GroupTopAppBarPreview() {
    VolkswagenGroupArchiveTheme {
        GroupTopAppBar()
    }
}

@Preview(showBackground = true)
@Composable
fun BrandListScreenPreview() {
    VolkswagenGroupArchiveTheme {
        BrandListScreen()
    }
}


//시작//
@Composable
fun VolkswagenGroupApp() {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            GroupTopAppBar()
        },
        content = { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = "brands",
                modifier = Modifier.padding(innerPadding),
                builder = {
                    composable(route = "brands") {
                        BrandListScreen()
                    }
                }
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GroupTopAppBar() {
    TopAppBar(
        title = {
            Text(text = stringResource(R.string.group_title))
        },
        navigationIcon = {
            IconButton(
                onClick = {
                    // 나중에 뒤로가기 동작 연결
                }
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.navigate_back)
                )
            }
        },
        actions = {
            IconButton(
                onClick = {
                    // 나중에 홈으로 이동하는 동작 연결
                }
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
    modifier: Modifier = Modifier
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
            item {
                BrandCard(
                    imageRes = R.drawable.lamborghini,
                    nameRes = R.string.brand_lamborghini_name,
                    sloganRes = R.string.brand_lamborghini_slogan
                )
            }

            item {
                BrandCard(
                    imageRes = R.drawable.bentley,
                    nameRes = R.string.brand_bentley_name,
                    sloganRes = R.string.brand_bentley_slogan
                )
            }

            item {
                BrandCard(
                    imageRes = R.drawable.audi,
                    nameRes = R.string.brand_audi_name,
                    sloganRes = R.string.brand_audi_slogan
                )
            }
                item {
                    BrandCard(
                        imageRes = R.drawable.volkswagen,
                        nameRes = R.string.brand_volkswagen_name,
                        sloganRes = R.string.brand_volkswagen_slogan
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
    sloganRes: Int
) {
    Card(
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

                Column {
                    Text(
                        text = stringResource(nameRes)
                    )
                    Text(
                        text = stringResource(sloganRes)
                    )
                }
            }
        }
    )
}