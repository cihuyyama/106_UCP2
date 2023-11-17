package com.example.a106_ucp2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.a106_ucp2.data.UiState

@Composable
fun HalamanTampilData(
    UiState: UiState,
    backButton:() -> Unit,
    modifier: Modifier
){
    val items = listOf(
        Pair("Nama Mahasiswa", UiState.nama),
        Pair("NIM", UiState.nim),
        Pair("Konsentrasi", UiState.konsentrasi),
        Pair("Judul Skripsi", UiState.judul),
        Pair("Dosen Pembimbing 1", UiState.dos1),
        Pair("Dosen Pembimbing 2", UiState.dos2)
    )

    Column (
        modifier = Modifier
            .padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items.forEach{ item ->
            Column {
                Text(item.first.uppercase(), fontWeight = FontWeight.Bold)
                Text(text = item.second.toString())
            }

            Divider()

            Spacer(
                modifier = Modifier
                    .height(8.dp)
            )

        }
        Button(
            onClick = backButton,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "Back")
        }
    }
}