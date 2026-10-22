package mx.edu.utez.listas4d.ui.components

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.content.MediaType.Companion.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mx.edu.utez.listas4d.R
import mx.edu.utez.listas4d.ui.model.Pet

@Composable
fun PetCard (pet : Pet){
    Column(modifier = Modifier.padding(10.dp, 5.dp)) {
        Card(colors = CardDefaults.cardColors(Color(141, 161, 227), Color.Black)) {
            Image(painterResource(pet.image),
                "Imagen de la mascota",
                modifier = Modifier.fillMaxWidth().height(200.dp),
                contentScale = ContentScale.Crop)

            Column(modifier = Modifier.padding(10.dp)) {
                Text(pet.name,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold)
                Text("${pet.age}",
                    fontSize = 18.sp,
                    fontStyle = FontStyle.Italic)
            }
        }
    }
}