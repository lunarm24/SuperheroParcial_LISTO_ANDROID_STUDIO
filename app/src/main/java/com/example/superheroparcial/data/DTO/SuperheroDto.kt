package com.example.superheroparcial.data.DTO
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
