package mx.edu.utez.listas4d.ui.screens

import androidx.compose.runtime.Composable
import mx.edu.utez.listas4d.R
import mx.edu.utez.listas4d.ui.components.PetList
import mx.edu.utez.listas4d.ui.model.Pet

@Composable
fun PetScreen(){
    var petLits = listOf(
        Pet(1, "Lunes", 2, R.drawable.chowchow),
        Pet(2, "Martes", 2, R.drawable.chihuahua),
        Pet(3, "Miercoles", 2, R.drawable.iguana),
        Pet(4, "Jueves", 2, R.drawable.inu),
        Pet(5, "Viernes", 2, R.drawable.americano)
    )
    PetList(petLits)
}