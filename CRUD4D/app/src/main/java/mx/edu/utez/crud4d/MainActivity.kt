package mx.edu.utez.crud4d

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
import mx.edu.utez.crud4d.ui.screens.CRUDScreen
import mx.edu.utez.crud4d.ui.theme.CRUD4DTheme
import mx.edu.utez.crud4d.ui.viewmodel.CRUDViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CRUD4DTheme {
                val viewModel: CRUDViewModel = viewModel()
                CRUDScreen(viewModel)
            }
        }
    }
}