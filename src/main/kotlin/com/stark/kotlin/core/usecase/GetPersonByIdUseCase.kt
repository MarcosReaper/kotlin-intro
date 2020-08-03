package com.stark.kotlin.core.usecase

import com.stark.kotlin.core.entity.Persona
import com.stark.kotlin.repositories.PersonCrudDatabaseRepository
import org.springframework.stereotype.Component

@Component
class GetPersonByIdUseCase(private val personCrudRepository: PersonCrudDatabaseRepository) {

    fun execute(id: Long): Persona = personCrudRepository.findById(id)
            .map { Persona(it.id!!, it.name, it.lastName) }.orElseThrow()

}
