package com.xamma.pokedexRestKotlin.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document
data class Pokemon (
    @Id
    val id: String = ObjectId.get().toString(),
    val name: String,
    val caughtDate: LocalDateTime = LocalDateTime.now()
)