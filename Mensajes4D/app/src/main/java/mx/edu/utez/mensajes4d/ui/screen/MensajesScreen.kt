package mx.edu.utez.mensajes4d.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import mx.edu.utez.mensajes4d.R
import mx.edu.utez.mensajes4d.ui.viewmodel.MensajesViewModel

@Composable
fun MensajesScreen(viewModel: MensajesViewModel){
    val contexto = LocalContext.current
    Column(modifier = Modifier.statusBarsPadding().fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        OutlinedTextField(viewModel.mensaje, onValueChange = {viewModel.mensaje = it})

        Button(modifier = Modifier.width(280.dp), onClick = {
            viewModel.mostrarToast(contexto)
        }) {Text("Toast")}
        Button(modifier = Modifier.width(280.dp), onClick = {
            viewModel.mostrarLog()
        }) {Text("Log")}
        Button(modifier = Modifier.width(280.dp), onClick = {
            viewModel.mostrarSnackBar()
        }) {Text("SnackBar") }
        Button(modifier = Modifier.width(280.dp), onClick = {
            viewModel.mostrarAlertDialog()
        }) {Text("AlertDialog") }
    }

    if(viewModel.snakeIsShow){
        Snackbar(modifier = Modifier.statusBarsPadding(),
            action = {},
            dismissAction = {
                Button(onClick = {viewModel.snakeIsShow = false}) {Text(stringResource(R.string.str_cerrar)) }
            }){
            Text(viewModel.mensaje)
        }
    }
    if (viewModel.alertIsShow){
        AlertDialog(
            icon={},
            title= { Text(stringResource(R.string.str_titulo_alert))},
            text = {Text(viewModel.mensaje)},
            confirmButton = {
                Button(onClick = {viewModel.alertIsShow = false}) {Text(stringResource(R.string.str_aceptar)) }
            },
            dismissButton = {
                Button(onClick = {viewModel.alertIsShow = false}) {Text(stringResource(R.string.str_cancelar)) }
            },
            onDismissRequest = {
                viewModel.alertIsShow = false
            }
        )
    }
}