package com.example.funfact.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.funfact.R
import com.example.funfact.data.UserDataUiEvents
import com.example.funfact.ui.AnimalCard
import com.example.funfact.ui.ButtonComponent
import com.example.funfact.ui.TextComponent
import com.example.funfact.ui.TextFieldComponent
import com.example.funfact.ui.TopBar
import com.example.funfact.ui.UserInputViewModel


@Composable
fun UserinputScreen(
    userInputViewModel: UserInputViewModel,
    showWelcomeScreen: (valuesPair:Pair<String,String>)
-> Unit){
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp)
        ) {
            TopBar("Merhabalar bebek \uD83D\uDE09")
            TextComponent(
                textValue = "Hadi senden bir şeyler öğrenelim !",
                textSize = 21.sp
            )
            // boşluk yapmaya yarıyor.
            Spacer(modifier = Modifier.size(10.dp))
            TextComponent(
                textValue = "Lütfen azıcık sen de eğlensene. Kırılma bana, başla.",
                textSize = 16.sp
            )
            Spacer(modifier = Modifier.size(50.dp))

            TextComponent(textValue = "İsmin nedir?", textSize = 18.sp)
            Spacer(modifier = Modifier.size(5.dp))

            TextFieldComponent(onTextChanged = {
                userInputViewModel.onEvent(
                    UserDataUiEvents.UserNameEntered(it)
                )
            })

            Spacer(modifier = Modifier.size(30.dp))
            TextComponent(textValue = "Hangisini daha çok seviyorsun?", textSize = 18.sp)

            Row(Modifier.fillMaxWidth()) {
                AnimalCard(image = R.drawable.kedi, animalSelected = {
                    userInputViewModel.onEvent(
                        UserDataUiEvents.AnimalSelected(it)
                    )
                }, selected = userInputViewModel.uiState.value.animalSelected == "Kedi")
                AnimalCard(image = R.drawable.kopek, animalSelected = {
                    userInputViewModel.onEvent(
                        UserDataUiEvents.AnimalSelected(it)
                    )
                }, selected = userInputViewModel.uiState.value.animalSelected == "Köpek")
            }
            Spacer(modifier = Modifier.weight(1f))

            if (userInputViewModel.isValidState()) {
                ButtonComponent(
                    goToDetailsScreen = {
                        println("=====buraya geliyorsunnn")
                        println("=======${userInputViewModel.uiState.value.nameEntered} and ${userInputViewModel.uiState.value.animalSelected}")
                        showWelcomeScreen(
                            Pair(
                                userInputViewModel.uiState.value.nameEntered,
                                userInputViewModel.uiState.value.animalSelected
                            )
                        )
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun UserInputScreenPreview(){
    UserinputScreen(UserInputViewModel(), showWelcomeScreen = {})
}