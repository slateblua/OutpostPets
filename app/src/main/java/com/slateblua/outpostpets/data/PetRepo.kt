package com.slateblua.outpostpets.data

interface PetRepo {
    suspend fun getAllPets(): List<Pet>
}