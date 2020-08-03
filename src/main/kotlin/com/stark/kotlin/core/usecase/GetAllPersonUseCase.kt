package com.stark.kotlin.core.usecase

import com.stark.kotlin.core.entity.Persona
import com.stark.kotlin.repositories.PersonCrudDatabaseRepository
import org.springframework.stereotype.Component

@Component
class GetAllPersonUseCase(private val personCrudRepository: PersonCrudDatabaseRepository) {

    fun execute(): List<Persona> = personCrudRepository.findAll().map { Persona(it.id, it.name, it.lastName) }

}