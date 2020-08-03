package com.stark.kotlin.repositories

import com.stark.kotlin.repositories.model.PersonDTO
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonCrudDatabaseRepository : CrudRepository<PersonDTO, Long>