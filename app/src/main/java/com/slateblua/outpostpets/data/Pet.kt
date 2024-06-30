package com.slateblua.outpostpets.data

import kotlinx.serialization.Serializable

@Serializable
data class Pet(
    val name: String,
    // Add type safety later
    val type: String,
    val stat: String,
    val pathToIcon: String,
) {
    companion object {
        val fakeData = Pet(
            name = "Fluffy",
            type = "MYTHIC",
            stat = "HP",
            pathToIcon = "https://cloud.appwrite.io/v1/storage/buckets/6679e463000ac473d837/files/6679e811000ca6e92699/view?project=6679e304000ef9ee666d&"
        )
    }
}
