package mx.edu.utez.crud4d.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AddAutoDialog(
    onAutoSaved: (String, String, String, String) -> Unit,
    onDialogDismiss: () -> Unit
) {
    //Cuando se quieren pasar valores del hijo al padre, el hijo
    //utiliza un argumento de tipo función, donde se envían los
    //valores que se quieren pasar al padre
    var modelo by remember { mutableStateOf("") }
    var marca by remember { mutableStateOf("") }
    var anio by remember { mutableStateOf("") }
    var color by remember { mutableStateOf("") }

    AlertDialog(
        icon = { },
        title = { Text("Agregar auto") },
        text = {
            Column() {
                OutlinedTextField(value = modelo, onValueChange = {modelo=it}, label = { Text("Modelo") })
                OutlinedTextField(value = marca, onValueChange = {marca=it}, label = { Text("Marca") })
                OutlinedTextField(value = anio, onValueChange = {anio=it}, label = { Text("Año") })
                OutlinedTextField(value = color, onValueChange = {color=it}, label = { Text("Color") })
            }
        },
        confirmButton = {
            Button(onClick = { onAutoSaved(modelo, marca, anio, color) }){
                Text("Guardar")
            }
        },
        dismissButton = {
            Button(onClick = { onDialogDismiss() }){
                Text("Cancelar")
            }
        },
        onDismissRequest = { onDialogDismiss() }
    )
}