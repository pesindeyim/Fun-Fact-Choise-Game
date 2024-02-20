package com.example.funfact.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.funfact.R
import com.example.funfact.ui.FactComposable
import com.example.funfact.ui.FactsViewModel
import com.example.funfact.ui.TextComponent
import com.example.funfact.ui.TextWithShadow
import com.example.funfact.ui.TopBar

@Composable
fun WelcomeScreen(username: String?, animalSelected: String?) {
    println("=====İçinde+WelcomeEkran")
    println("=====$username and $animalSelected")
    Surface (
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp)
        ) {
            TopBar(value = "Hoş Geldin $username\uD83D\uDE1D")
            Spacer(modifier = Modifier.size(50.dp))
            val finalText = if (animalSelected == "Kedi") "Sen bir Kedi aşığısın \uD83D\uDC08\u200D⬛" else "Sen bir Köpek aşığısın \uD83D\uDC15 "
            TextWithShadow(value = finalText)
            Spacer(modifier = Modifier.size(20.dp))

            val factsViewModel:FactsViewModel=viewModel()
            FactComposable(
                value = factsViewModel.generateRandomFact(animalSelected!!)
            )

        }
    }
}
@Preview
@Composable
fun WelcomeScreenPreview(){
    WelcomeScreen("username", "animalSelected")
}