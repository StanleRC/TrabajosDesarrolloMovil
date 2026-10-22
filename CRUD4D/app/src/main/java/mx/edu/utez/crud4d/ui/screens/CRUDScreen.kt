package mx.edu.utez.crud4d.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import mx.edu.utez.crud4d.data.model.Auto
import mx.edu.utez.crud4d.ui.components.AddAutoDialog
import mx.edu.utez.crud4d.ui.components.AutoCard
import mx.edu.utez.crud4d.ui.components.ConfirmDialog
import mx.edu.utez.crud4d.ui.components.EditAutoDialog
import mx.edu.utez.crud4d.ui.viewmodel.CRUDViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CRUDScreen(viewModel: CRUDViewModel) {

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { viewModel.addDialog = true }) { Text("+") }
        },
        topBar = {
            TopAppBar(title = { Text("Autos") })
        }
    ) {
        LazyColumn(modifier = Modifier.padding(it)) {
            items(items = viewModel.autos,
                key = { auto -> auto.id } ){
                AutoCard(it,
                    {
                        viewModel.autoSelect = it
                        viewModel.editDialog = true},
                    {
                        viewModel.autoSelect = it
                        viewModel.confirmDialog = true})
            }
        }
    }

    if(viewModel.addDialog){
        AddAutoDialog(
            { modelo, marca, anio, color ->
                viewModel.createAuto(Auto(0, modelo, marca, anio.toInt(), color))
                viewModel.addDialog = false
            },
            { viewModel.addDialog = false }
        )
    }

    if (viewModel.confirmDialog){
        ConfirmDialog(
            {viewModel.confirmDialog = false},
            {
                viewModel.deleteAuto(viewModel.autoSelect!!.id)
                viewModel.confirmDialog = false
            })
    }

    if(viewModel.editDialog){
        EditAutoDialog(
            viewModel.autoSelect!!,
            {id, modelo, marca, anio, color->
                viewModel.updateAuto(Auto(id, modelo, marca, anio.toInt(), color))
                viewModel.editDialog = false},
            {viewModel.editDialog = false}
        )
    }
}