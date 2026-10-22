package mx.edu.utez.crud4d.ui.components

import androidx.activity.SystemBarStyle.Companion.auto
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mx.edu.utez.crud4d.data.model.Auto

@Composable
fun AutoCard(auto: Auto,
             onEditPressed: () -> Unit,
             onDeletePressed: () -> Unit) {
    Column(modifier = Modifier.padding(10.dp, 5.dp)) {
        Card(modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color(250,244,202,255)
            )) {
            Column(modifier = Modifier.padding(5.dp)) {
                Row(){
                    Text(modifier = Modifier.weight(1f), text = auto.modelo, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    IconButton(onClick = {onEditPressed()}) {
                        Icon(
                            imageVector = Icons.Filled.Edit,
                            contentDescription = ""
                        )
                    }
                    IconButton(onClick = {onDeletePressed()}) {
                        Icon(
                            imageVector = Icons.Filled.Delete,
                            contentDescription = ""
                        )
                    }
                }

                Text(auto.marca, fontSize = 18.sp)
                Text(auto.color, fontStyle = FontStyle.Italic)
                Column(horizontalAlignment = Alignment.End,
                    modifier = Modifier.fillMaxWidth()){
                    Text(auto.anio.toString())
                }
            }
        }
    }
}