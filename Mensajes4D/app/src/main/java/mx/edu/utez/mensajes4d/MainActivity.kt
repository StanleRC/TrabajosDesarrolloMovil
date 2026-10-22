package mx.edu.utez.mensajes4d

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
import androidx.lifecycle.viewmodel.compose.viewModel
import mx.edu.utez.mensajes4d.ui.screen.MensajesScreen
import mx.edu.utez.mensajes4d.ui.theme.Mensajes4DTheme
import mx.edu.utez.mensajes4d.ui.viewmodel.MensajesViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Mensajes4DTheme {
                var viewModel: MensajesViewModel = viewModel()
                MensajesScreen(viewModel)
            }
        }
    }
}