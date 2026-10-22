package mx.edu.utez.listas4d

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import mx.edu.utez.listas4d.ui.screens.PetScreen
import mx.edu.utez.listas4d.ui.theme.Listas4DTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Listas4DTheme {
                //var listas = listOf("Uno", "Dos", "Tres")

                //Creacion de lista vacia:
                //var listaVacia = listOf<String>()

                PetScreen()
            }
        }
    }
}