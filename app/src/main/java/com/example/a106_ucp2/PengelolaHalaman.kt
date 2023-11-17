package com.example.a106_ucp2

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.a106_ucp2.data.DataSource
import com.example.a106_ucp2.data.UiState

enum class PengelolaHalaman {
    Home,
    Form,
    Result
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PengajuanSkripsi(
    viewModel: SkripsiViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    navController: NavHostController = rememberNavController()
) {
    Scaffold { innerPadding ->
        val uiState by viewModel.stateUI.collectAsState()
        NavHost(
            navController = navController,
            startDestination = PengelolaHalaman.Home.name,
            modifier = Modifier
                .padding(innerPadding)
        ) {
            composable(
                route = PengelolaHalaman.Home.name
            ) {
                HalamanHome(
                    onNextButtonClicked = {
                        navController.navigate(PengelolaHalaman.Form.name)
                    }
                )
            }
            composable(
                route = PengelolaHalaman.Form.name
            ) {
                val context = LocalContext.current
                HalamanForm(
                    pilihanDosPem = DataSource.Dospem.map { item ->
                        context.resources.getString(item)
                    },
                    onSubmitButtonClick = {
                        viewModel.setStudent(it)
                        navController.navigate(PengelolaHalaman.Result.name)
                    }
                )
            }
            composable(
                route = PengelolaHalaman.Result.name
            ) {
                HalamanTampilData(
                    UiState = uiState,
                    backButton = {
                        backButtonToForm(navController)
                    },
                    modifier = Modifier
                )
            }
        }
    }
}

private fun backButtonToForm(
    navController: NavHostController
) {
    navController.popBackStack(PengelolaHalaman.Form.name, inclusive = false)
}