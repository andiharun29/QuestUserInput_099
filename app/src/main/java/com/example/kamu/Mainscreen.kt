package com.example.kamu


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = true)
@Composable
fun Mainscreen(
    modifier: Modifier = Modifier
){
    var nama by rememberSaveable { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var noHP by remember { mutableStateOf("") }
    var SelectedGender by remember { mutableStateOf("") }

    val jenisKelamin = listOf("Laki-Laki","Perempuan")

    var namaconfirm by rememberSaveable { mutableStateOf("") }
    var emailconfirm by remember { mutableStateOf("") }
    var alamatconfirm by remember { mutableStateOf("") }
    var noHPconfirm by remember { mutableStateOf("") }
    var SelectedGenderconfirm by remember { mutableStateOf("") }

    Column (modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally){
        OutlinedTextField(
            value = nama,
            onValueChange = {nama = it},
            placeholder = { Text("masukkan nama")
                          }, label = { Text("Nama") },
            modifier = Modifier.fillMaxWidth().padding(5.dp))

        Row () {
            jenisKelamin.forEach { item ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(selected = SelectedGender == item,
                        onClick = {
                            SelectedGender = item
                        })
                    Text(item)
                    }
                }
            }

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                placeholder = {
                    Text("masukkan email")
                }, label = { Text("Email") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = Modifier.fillMaxWidth().padding(5.dp)
            )

            OutlinedTextField(
                value = alamat,
                onValueChange = { alamat = it },
                placeholder = {
                    Text("masukkan alamat")
                }, label = { Text("Alamat") },
                modifier = Modifier.fillMaxWidth().padding(5.dp)
            )

            OutlinedTextField(
                value = noHP,
                onValueChange = { noHP = it },
                placeholder = {
                    Text("masukkan no HP")
                }, label = { Text("no HP") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth().padding(5.dp)
            )
        Button(onClick = {
            namaconfirm = nama
            SelectedGenderconfirm = SelectedGender
            emailconfirm = email
            alamatconfirm = alamat
            noHPconfirm = noHP


        })
        {
            Text("simpan")
        }

        Card(modifier.size(height = 300.dp, width = 400.dp)) {
            MainSection(judulParam = "nama", isiparam = namaconfirm )
            MainSection(judulParam = "Jenis Kelamin", isiparam = SelectedGenderconfirm )
            MainSection(judulParam = "Email", isiparam = emailconfirm )
            MainSection(judulParam = "Alamat", isiparam = alamatconfirm )
            MainSection(judulParam = "No HP", isiparam = noHPconfirm )
        }
    }

}

@Composable
fun MainSection(judulParam:String, isiparam:String) {
    Column(horizontalAlignment = Alignment.Start) {

        Spacer(Modifier.padding(5.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(1.dp)
                .padding(start = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = judulParam,
                modifier = Modifier.weight(0.9f)
            )
            Text(
                text = ":",
                modifier = Modifier.weight(0.2f)
            )
            Text(
                text = "$isiparam",
                modifier = Modifier.weight(2f)
            )
        }
    }
}