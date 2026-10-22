package mx.edu.utez.crud4d.data.repository

import mx.edu.utez.crud4d.data.model.Auto

object AutoRepository {
    // Singleton
    // Asegurarse que exista una sola
    // instancia de una clase en cualquier
    // momento. Se puede acceder a esta
    // instancia desde cualquier clase.
    var lista = mutableListOf(
        Auto(1, "Mustang", "Ford", 1995, "Negro"),
        Auto(2, "Civic", "Honda", 2018, "Blanco"),
        Auto(3, "Corolla", "Toyota", 2020, "Gris"),
        Auto(4, "Camaro", "Chevrolet", 2015, "Amarillo"),
        Auto(5, "Beetle", "Volkswagen", 2012, "Rojo"),
        Auto(6, "Altima", "Nissan", 2022, "Azul")
    )

    // Métodos para el CRUD
    fun getAuto(id: Int): Auto{
        lista.forEach {
            if(it.id == id) return it
        }
        throw Exception("No se encontró el auto con el id: $id")
    }

    fun getAutos(): List<Auto>{
        return lista.toList()
    }

    fun createAuto(auto: Auto){
        val newId = if (AutoRepository.lista.isEmpty()) 1 else (AutoRepository.lista.maxOf { it.id } + 1)
        auto.id = newId
        lista.add(auto)
    }

    fun updateAuto(auto: Auto){
        if(auto.id != 0){
            for( i in 0 until lista.size){
                if(lista[i].id == auto.id){
                    lista[i] = lista[i].copy()
                    lista[i].modelo = auto.modelo
                    lista[i].marca = auto.marca
                    lista[i].color = auto.color
                    lista[i].anio = auto.anio
                }
            }
        }
    }

    fun deleteAuto(id: Int){
        for(i in 0 until lista.size){
            if(lista[i].id == id){
                lista.removeAt(i)
                return
            }
        }
    }
}