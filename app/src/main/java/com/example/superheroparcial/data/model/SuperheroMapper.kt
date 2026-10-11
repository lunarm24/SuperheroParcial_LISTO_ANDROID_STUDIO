package com.example.superheroparcial.data.model

fun SuperheroDto.toSuperheroInfo(): Superhero = Superhero(
    id = id,
    name = name.orEmpty(),
    fullName = biography?.fullName.orEmpty(),
    publisher = biography?.publisher.orEmpty(),
    imageUrl = images?.lg?.takeIf { it.isNotBlank() }
        ?: images?.md?.takeIf { it.isNotBlank() }
        ?: images?.sm.orEmpty(),
    stats = powerstats.orEmpty().mapValues { (_, value) -> value ?: 0 },
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
