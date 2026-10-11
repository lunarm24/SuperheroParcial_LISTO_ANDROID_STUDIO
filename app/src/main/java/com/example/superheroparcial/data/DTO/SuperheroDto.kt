package com.example.superheroparcial.data.DTO

import com.example.superheroparcial.data.model.HeroAppearance
import com.example.superheroparcial.data.model.HeroBiography
import com.example.superheroparcial.data.model.HeroConnections
import com.example.superheroparcial.data.model.HeroWork
import com.example.superheroparcial.data.model.Superhero
import com.google.gson.annotations.SerializedName

data class SuperheroDto(
    val id: Int,
    val name: String?,
    val biography: BiographyDto?,
    val images: ImagesDto?,
    val powerstats: Map<String, Int?>?,
    val appearance: AppearanceDto?,
    val work: WorkDto?,
    val connections: ConnectionsDto?
)

data class BiographyDto(
    @SerializedName("fullName") val fullName: String?,
    val publisher: String?,
    val placeOfBirth: String?,
    val firstAppearance: String?,
    val alignment: String?,
    val aliases: List<String>?
)

data class ImagesDto(val sm: String?, val md: String?, val lg: String?)

data class AppearanceDto(
    val gender: String?,
    val race: String?,
    val height: List<String>?,
    val weight: List<String>?,
    val eyeColor: String?,
    val hairColor: String?
)

data class WorkDto(val occupation: String?, val base: String?)

data class ConnectionsDto(val groupAffiliation: String?, val relatives: String?)

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
        fullName = biography?.fullName.orEmpty(),
        publisher = biography?.publisher.orEmpty(),
        imageUrl = imageUrl,
        stats = stats,
        appearance = HeroAppearance(
            gender = appearance?.gender.orEmpty(),
            race = appearance?.race.orEmpty(),
            height = appearance?.height.orEmpty(),
            weight = appearance?.weight.orEmpty(),
            eyeColor = appearance?.eyeColor.orEmpty(),
            hairColor = appearance?.hairColor.orEmpty()
        ),
        biography = HeroBiography(
            placeOfBirth = biography?.placeOfBirth.orEmpty(),
            firstAppearance = biography?.firstAppearance.orEmpty(),
            alignment = biography?.alignment.orEmpty(),
            aliases = biography?.aliases.orEmpty()
        ),
        work = HeroWork(
            occupation = work?.occupation.orEmpty(),
            base = work?.base.orEmpty()
        ),
        connections = HeroConnections(
            groupAffiliation = connections?.groupAffiliation.orEmpty(),
            relatives = connections?.relatives.orEmpty()
        )
    )
}
