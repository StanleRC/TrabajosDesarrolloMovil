package mx.edu.utez.listas4d.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import mx.edu.utez.listas4d.ui.model.Pet

@Composable
fun PetList(pets : List<Pet>){
    LazyColumn(modifier = Modifier.statusBarsPadding()) {
        items(items = pets,
            key = { pet -> pet.id }
        ){ pet ->
            PetCard(pet)
        }
    }
}