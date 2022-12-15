package com.xamma.pokedexRestKotlin.repository

import com.xamma.pokedexRestKotlin.model.Pokemon
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface PokemonRepository : MongoRepository<Pokemon, String> {
    //query method provided by Spring Data JPA
    fun findOneById(id: ObjectId) : Pokemon
    //additionally, MongoRepository provides all basic methods for CRUD operations
}