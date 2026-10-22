package mx.edu.utez.crud4d.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import mx.edu.utez.crud4d.data.model.Auto
import mx.edu.utez.crud4d.data.repository.AutoRepository

class CRUDViewModel: ViewModel() {
    var autos by mutableStateOf(listOf<Auto>())
    var addDialog by mutableStateOf(false)
    var confirmDialog by mutableStateOf(false)
    var editDialog by mutableStateOf(false)
    var autoSelect by mutableStateOf<Auto?>(null)

    init{
        autos = AutoRepository.getAutos()
    }

    fun findAuto(id: Int): Auto {
        return AutoRepository.getAuto(id)
    }

    fun findAutos():List<Auto>{
        return AutoRepository.getAutos()
    }

    fun createAuto(auto:Auto){
        AutoRepository.createAuto(auto)
        autos = AutoRepository.getAutos()
    }

    fun updateAuto(auto:Auto){
        AutoRepository.updateAuto(auto)
        autos = AutoRepository.getAutos()
    }

    fun deleteAuto(id: Int){
        AutoRepository.deleteAuto(id)
        autos = AutoRepository.getAutos()
    }
}