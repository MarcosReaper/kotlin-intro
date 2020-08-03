package com.stark.kotlin.core.usecase

import com.stark.kotlin.repositories.PersonCrudDatabaseRepository
import org.springframework.stereotype.Component

@Component
class DeletePersonUseCase(private val personCrudDatabaseRepository: PersonCrudDatabaseRepository) {

    fun execute(id: Long): Unit = personCrudDatabaseRepository.deleteById(id)
}