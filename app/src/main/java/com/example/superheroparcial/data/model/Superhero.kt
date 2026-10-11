package com.example.superheroparcial.data.model

data class Superhero(
    val id: Int,
    val name: String,
    val fullName: String,
    val publisher: String,
    val imageUrl: String,
    val stats: Map<String, Int>,
    val appearance: HeroAppearance = HeroAppearance(),
    val biography: HeroBiography = HeroBiography(),
    val work: HeroWork = HeroWork(),
    val connections: HeroConnections = HeroConnections()
)

data class HeroAppearance(
    val gender: String = "",
    val race: String = "",
    val height: List<String> = emptyList(),
    val weight: List<String> = emptyList(),
    val eyeColor: String = "",
    val hairColor: String = ""
)

data class HeroBiography(
    val placeOfBirth: String = "",
    val firstAppearance: String = "",
    val alignment: String = "",
    val aliases: List<String> = emptyList()
)

data class HeroWork(
    val occupation: String = "",
    val base: String = ""
)

data class HeroConnections(
    val groupAffiliation: String = "",
    val relatives: String = ""
)
