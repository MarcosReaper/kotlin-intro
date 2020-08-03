package com.stark.kotlin.entrypoint

import com.stark.kotlin.core.entity.Persona
import com.stark.kotlin.core.usecase.DeletePersonUseCase
import com.stark.kotlin.core.usecase.GetAllPersonUseCase
import com.stark.kotlin.core.usecase.GetPersonByIdUseCase
import com.stark.kotlin.core.usecase.SaveOrUpdatePersonUseCase
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
class PersonController(private val getPersonByIdUseCase: GetPersonByIdUseCase,
                        private val saveOrUpdatePersonUseCase: SaveOrUpdatePersonUseCase,
                        private val getAllPersonUseCase: GetAllPersonUseCase,
                        private val deletePersonUseCase: DeletePersonUseCase){

    companion object {
        private val log: Logger = LoggerFactory.getLogger(PersonController::class.java)
    }

    @PostMapping("/persona", produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.OK)
    fun addPersona(@RequestBody person: Persona) : Persona{
        return saveOrUpdatePersonUseCase.execute(person)
    }

    @GetMapping("/persona/{id}" , produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.OK)
    fun getPersona(@PathVariable("id") id: Long) : Persona{
        log.info("Persona a buscar ${id}")
        return getPersonByIdUseCase.execute(id)
    }

    @GetMapping("/persona", produces = [MediaType.APPLICATION_JSON_VALUE] )
    @ResponseStatus(HttpStatus.OK)
    fun getAllPersonas(): List<Persona>{
        log.info("Buscando todas las personas")
        return getAllPersonUseCase.execute()
    }

    @DeleteMapping("/persona/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun deletePerson(@PathVariable("id") id: Long): Unit = deletePersonUseCase.execute(id)
}