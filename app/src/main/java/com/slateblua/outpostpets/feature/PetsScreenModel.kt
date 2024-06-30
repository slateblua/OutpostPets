package com.slateblua.outpostpets.feature

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.slateblua.outpostpets.data.Pet
import com.slateblua.outpostpets.data.PetRepo

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PetsScreenModel(private val petRepo: PetRepo) : ScreenModel {

    private val _state = MutableStateFlow(PetsScreenState())
    val state = _state.asStateFlow()

    init {
        updatePets()
    }
    private fun updatePets() {
        screenModelScope.launch {
            val pets = petRepo.getAllPets()
            _state.update {
                it.copy(pets = pets)
            }
        }
    }

    fun searchPet(query: String) {
        screenModelScope.launch {
            setUserMessage(query)
            val pets = petRepo.getAllPets().filter { pet ->
                pet.name.contains(query, ignoreCase = true) }
            _state.update {
                it.copy(pets = pets)
            }
        }
    }

    private fun setUserMessage(query: String) {
        _state.update {
            it.copy(userMessage = query)
        }
    }
    data class PetsScreenState(
        val pets: List<Pet> = emptyList(),
        val userMessage: String = "",
    )
}
