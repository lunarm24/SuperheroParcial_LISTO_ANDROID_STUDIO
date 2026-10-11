package com.example.superheroparcial.data.DTO

import com.example.superheroparcial.data.model.Superhero

data class SuperheroDto(
    val id: Int,
    val name: String?,
    val biography: BiographyDto?,
    val images: ImagesDto?,
    val powerstats: Map<String, Int?>?
)

data class BiographyDto(
    val publisher: String?
)

data class ImagesDto(val sm: String?, val md: String?, val lg: String?)

fun SuperheroDto.toSuperheroInfo(): Superhero {
    val imageUrl = when {
        !images?.lg.isNullOrBlank() -> images.lg.orEmpty()
        !images?.md.isNullOrBlank() -> images.md.orEmpty()
        else -> images?.sm.orEmpty()
    }
    val stats = powerstats.orEmpty().map { (name, value) ->
        name to (value ?: 0)
    }.toMap()

    return Superhero(
        id = id,
        name = name.orEmpty(),
        publisher = biography?.publisher.orEmpty(),
        imageUrl = imageUrl,
        stats = stats
    )
}
