package com.example.funfact.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.funfact.R
import com.example.funfact.Utils
import com.example.funfact.data.UserDataUiEvents

@Composable
fun TopBar(value:String){
Row(modifier = Modifier.fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically
){
    Text(
        text = value,
        color = Color.Black,
        fontSize=24.sp,
        fontWeight = FontWeight.Bold
    )
    Spacer(modifier = Modifier.weight(1f))
    Image(
        modifier = Modifier.size(80.dp),
        painter = painterResource(id = R.drawable.logo),
        contentDescription = "Pesindeyim(github)")
}
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview(){
    TopBar(value = String())
}

@Composable
fun TextComponent(textValue:String,
                  textSize: TextUnit,
                  colorValue:Color= Color.Black){
    Text(text = textValue,
        fontSize = textSize,
        color = colorValue,
        fontWeight=FontWeight.Normal
        )
}
@Preview(showBackground = true)
@Composable
fun TextComponentPreview(){
    TextComponent(textValue = "pesindeyim", textSize = 12.sp )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldComponent(
    onTextChanged: (name:String) -> Unit
){
    var currentValue by remember{
        mutableStateOf("")
    }
    val localFocusManager = LocalFocusManager.current
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = currentValue,
        onValueChange = {
            currentValue = it
            onTextChanged(it)
        },
        placeholder = {
            Text(text = "İsmini gir bakalım", fontSize = 18.sp)
        },
        textStyle = TextStyle.Default.copy(fontSize = 24.sp),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions {
        localFocusManager.clearFocus()
        }
    )
}

@Composable
@Preview(showBackground=true)
fun TextFieldComponentPreview(){
    TextFieldComponent(onTextChanged = {
            UserDataUiEvents.UserNameEntered(it)
    })
}

@Composable
fun AnimalCard(image:Int, selected:Boolean,
               animalSelected: (animalName:String) -> Unit
){
    val localFocusManager = LocalFocusManager.current

    Card (
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(20.dp)
            .size(120.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Box (
            Modifier
                .fillMaxSize()
                .border(
                    width = 1.dp,
                    color = if (selected) Color.Green else Color.Transparent,
                    shape = RoundedCornerShape(8.dp)
                )
        ) {
            Image(
                modifier = Modifier
                    .padding(40.dp)
                    .scale(3.1f)
                    .wrapContentHeight()
                    .wrapContentWidth()
                    .clickable {
                        val animalName = if (image == R.drawable.kedi) "Kedi" else "Köpek"
                        animalSelected(animalName)
                        localFocusManager.clearFocus()
                    },

                painter = painterResource(id = image),
                contentDescription = "Animal Image"
            )
        }
    }
}
@Preview
@Composable
fun AnimalCardPreview(){
    AnimalCard(R.drawable.kedi,false,{"Kedi"})
}

@Composable
fun ButtonComponent(
    goToDetailsScreen:()->Unit
){
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .size(50.dp),
        onClick = {
            goToDetailsScreen()
        }) {
        TextComponent(textValue = "Detaylar Ekranına Git.",
            textSize = 18.sp,
            colorValue = Color.LightGray)
    }
}
@Composable
fun TextWithShadow(value: String){
    val shadowOffset = Offset(x=1f, y=2f)
    Text(
        text = value,
        fontSize = 20.sp,
        color= Color.DarkGray,
        fontWeight = FontWeight.Normal,
        style = TextStyle(
            shadow = Shadow(Utils.generateRandomColor(),shadowOffset,2f)
        )
    )
}

@Composable
fun FactComposable(value: String){
    Card (
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier=Modifier.padding(0.dp,20.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.quote),
                contentDescription = "quote image",
                modifier = Modifier
                    .rotate(180f)
                    .scale(0.2f)
                    .padding(1.dp)
            )
        }
        Spacer(modifier = Modifier.size(0.dp))

        TextWithShadow(value = value)

        Spacer(modifier = Modifier.size(4.dp))

        Image(painter = painterResource(id = R.drawable.quote),
            contentDescription = "quote image",
            modifier = Modifier
                .scale(0.2f)
                .padding(0.dp))
    }
}

@Preview
@Composable
fun FactComposablePreview(){
    FactComposable(value = "ABCDEFS")
}

























