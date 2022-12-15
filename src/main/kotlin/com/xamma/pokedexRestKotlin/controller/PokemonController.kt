package com.xamma.pokedexRestKotlin.controller

import com.xamma.pokedexRestKotlin.model.Pokemon
import com.xamma.pokedexRestKotlin.repository.PokemonRepository
import com.xamma.pokedexRestKotlin.request.PokemonRequest
import org.bson.types.ObjectId
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/pokemons")
class PokemonController(private val pokemonRepository: PokemonRepository) {

    @GetMapping
    fun getAllPokemons(): ResponseEntity<List<Pokemon>> {
        val pokemons = pokemonRepository.findAll()
        return ResponseEntity.ok(pokemons)
    }

    @GetMapping("/{id}")
    fun getOnePokemon(@PathVariable("id") id: String): ResponseEntity<Pokemon> {
        val pokemon = pokemonRepository.findOneById(ObjectId(id))
        return ResponseEntity.ok(pokemon)
    }

    @PostMapping
    fun createPokemonEntry(@RequestBody request: PokemonRequest): ResponseEntity<Pokemon> {
        val pokemon = pokemonRepository.save(Pokemon(
            name = request.name
        ))
        return ResponseEntity(pokemon, HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun updatePokemon(@RequestBody request: PokemonRequest, @PathVariable("id") id: String): ResponseEntity<Pokemon> {
        val pokemon = pokemonRepository.findOneById(ObjectId(id))
        val updatedPokemon = pokemonRepository.save(Pokemon(
            id = pokemon.id,
            name = request.name,
            caughtDate = pokemon.caughtDate
        ))
        return ResponseEntity.ok(updatedPokemon)
    }

    @DeleteMapping("/{id}")
    fun deletePokemon(@PathVariable("id") id: String): ResponseEntity<Pokemon> {
        pokemonRepository.deleteById(id)
        return ResponseEntity.noContent().build()
    }
}

