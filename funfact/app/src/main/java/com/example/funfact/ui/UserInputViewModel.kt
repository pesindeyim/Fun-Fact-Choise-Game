package com.example.funfact.ui

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.funfact.data.UserDataUiEvents
import com.example.funfact.data.UserInputScreenState

class UserInputViewModel : ViewModel(){
    // logcat tten seçimlerin ve girişlerin yapıldığını kanıtlıyoruz.
    companion object{
        const val TAG = "UserInputViewModel"
    }
    var uiState= mutableStateOf(UserInputScreenState())

    fun onEvent(event:UserDataUiEvents){
        when(event){
            is UserDataUiEvents.UserNameEntered->{
                uiState.value=uiState.value.copy(
                    nameEntered = event.name
                )
                // bu da işte kanıtlamak için 2.aşama
                Log.d(TAG,"onEvent:UserNameEntered->> ")
                Log.d(TAG,"${uiState.value}")
            }
            is UserDataUiEvents.AnimalSelected->{
                uiState.value=uiState.value.copy(
                    animalSelected = event.animalValue
                )
                Log.d(TAG,"onEvent:AnimalSelected->> ")
                Log.d(TAG,"${uiState.value}")
            }
        }
    }

    fun isValidState():Boolean{
        return !uiState.value.nameEntered.isNullOrEmpty()&& !uiState.value.animalSelected.isNullOrEmpty()
    }
}
