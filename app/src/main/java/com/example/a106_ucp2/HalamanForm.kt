package com.example.a106_ucp2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a106_ucp2.ui.theme._106_UCP2Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanForm(
    pilihanDosPem:List<String>,
    onSubmitButtonClick: (MutableList<String>) -> Unit
) {
    var namaTxt by rememberSaveable {
        mutableStateOf("")
    }

    var nimTxt by rememberSaveable {
        mutableStateOf("")
    }

    var konTxt by rememberSaveable {
        mutableStateOf("")
    }

    var judultxt by remember {
        mutableStateOf("")
    }


    var dospem1 by remember {
        mutableStateOf("")
    }

    var dospem2 by remember {
        mutableStateOf("")
    }
    var listDataTxt: MutableList<String> = mutableListOf(namaTxt, nimTxt, konTxt, judultxt, dospem1, dospem2)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Formulir Pengajuan Skripsi",
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.padding(6.dp))

        OutlinedTextField(
            value = namaTxt,
            onValueChange = {
                namaTxt = it
            },
            label = {
                Text(text = "Nama Mahasiswa")
            }
        )
        OutlinedTextField(
            value = nimTxt,
            onValueChange = {
                nimTxt = it
            },
            label = {
                Text(text = "NIM")
            }
        )
        OutlinedTextField(
            value = konTxt,
            onValueChange = {
                konTxt = it
            },
            label = {
                Text(text = "Konsentrasi")
            }
        )
        OutlinedTextField(
            value = judultxt,
            onValueChange = {
                judultxt = it
            },
            label = {
                Text(text = "Judul Skripsi")
            }
        )

        Row {
            Column {
                Text(text = "Dosen Pembimbing 1")
                pilihanDosPem.forEach{item ->
                    Row (
                        modifier = Modifier
                            .selectable(
                                selected = dospem1 == item,
                                onClick = {
                                    dospem1 = item
                                }
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = dospem1 == item,
                            onClick = {
                                dospem1 = item
                            }
                        )

                        Text(item)
                    }
                }
            }

            Column {
                Text(text = "Dosen Pembimbing 2")
                pilihanDosPem.forEach{item ->
                    Row (
                        modifier = Modifier
                            .selectable(
                                selected = dospem2 == item,
                                onClick = {
                                    dospem2 = item
                                }
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = dospem2 == item,
                            onClick = {
                                dospem2 = item
                            }
                        )

                        Text(item)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.padding(16.dp))

        Button(
            onClick = {onSubmitButtonClick(listDataTxt)}
        ) {
            Text(text = "Submit")
        }
    }
}
