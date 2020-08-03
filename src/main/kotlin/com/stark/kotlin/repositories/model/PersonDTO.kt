package com.stark.kotlin.repositories.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("persona")
data class PersonDTO(
        @Id var id: Long?,
        @Column("NOMBRE") var name: String,
        @Column("APELLIDO") val lastName: String)