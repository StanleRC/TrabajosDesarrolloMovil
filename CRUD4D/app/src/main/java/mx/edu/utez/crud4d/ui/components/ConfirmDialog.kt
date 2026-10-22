package mx.edu.utez.crud4d.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ConfirmDialog (
    onDialogDismiss: () -> Unit,
    onAutoDelete: () -> Unit
){
    AlertDialog(
    icon = { },
    title = { Text("Confirmacion de borrado") },
    text = {
        Column() {
            Text("¿Estas seguro de querer eliminar el auto?")
        }
    },

    confirmButton = {
        Button(onClick = { onAutoDelete() }){
            Text("Si")
        }
    },

    dismissButton = {
        Button(onClick = { onDialogDismiss() }){
            Text("No")
        }
    },
    onDismissRequest = { onDialogDismiss() }
    )
}