package com.slateblua.outpostpets.appmodule

import com.slateblua.outpostpets.data.PetRepo
import com.slateblua.outpostpets.data.PetRepoImpl
import com.slateblua.outpostpets.feature.PetsScreenModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import org.koin.dsl.module

val commonModule = module {
    factory { PetsScreenModel(get()) }

    single<PetRepo> { PetRepoImpl(get()) }

    single {
        HttpClient() {
            install(ContentNegotiation) {
                json()
            }
        }
    }
}