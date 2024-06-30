package com.slateblua.outpostpets.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class PetRepoImpl(private val httpCl: HttpClient) : PetRepo {
    override suspend fun getAllPets(): List<Pet> {
        return httpCl
            .get("https://slateblua.github.io/oupostpetsdata/outpostpetsdata.json")
            .body<List<Pet>>()
    }
}