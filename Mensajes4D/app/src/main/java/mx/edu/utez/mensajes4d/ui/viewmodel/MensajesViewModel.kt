package mx.edu.utez.mensajes4d.ui.viewmodel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MensajesViewModel: ViewModel() {
    var mensaje by mutableStateOf("")
    var snakeIsShow by mutableStateOf(false)
    var alertIsShow by mutableStateOf(false)

    fun mostrarToast(contexto: Context){
        //1. Contexto. 2 Texto. 3. Duracion
        Toast.makeText(contexto, mensaje, Toast.LENGTH_SHORT).show()
    }

    fun mostrarLog(){
        //1. Espera recibir una etiqueta
        //2. Texto
       Log.e("MENSAJES", mensaje)
    }

    fun mostrarSnackBar(){
        snakeIsShow = true
    }

    fun mostrarAlertDialog(){
        alertIsShow = true
    }

}