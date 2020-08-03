package com.stark.kotlin.core.usecase

import com.stark.kotlin.core.entity.Persona
import com.stark.kotlin.repositories.PersonCrudDatabaseRepository
import com.stark.kotlin.repositories.model.PersonDTO
import org.springframework.stereotype.Component


@Component
class SaveOrUpdatePersonUseCase(private val personCrudRepository: PersonCrudDatabaseRepository) {

    fun execute(person: Persona): Persona {
        val person = personCrudRepository.save(PersonDTO(person.id, person.nombre, person.apellido))
        return Persona(person.id!!, person.name, person.lastName)
    }
}