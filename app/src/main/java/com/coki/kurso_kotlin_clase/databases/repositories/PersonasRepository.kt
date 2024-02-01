package com.coki.kurso_kotlin_clase.databases.repositories

import androidx.lifecycle.LiveData
import com.coki.kurso_kotlin_clase.databases.daos.PersonasDao
import com.coki.kurso_kotlin_clase.databases.entities.Persona

class PersonasRepository(private val personasDao: PersonasDao) {

    val allPersonas: LiveData<List<Persona>> = personasDao.getAllPersonas()
    suspend fun insert(persona: Persona) {
        personasDao.insertPersona(persona)
    }
    suspend fun update(persona: Persona) {
        personasDao.updatePersona(persona)
    }
    suspend fun delete(uuid:String) {
        personasDao.deletePersonaByUuid(uuid)
    }
}