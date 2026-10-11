package com.example.superheroparcial.ui.preview

import com.example.superheroparcial.data.model.Superhero

object PreviewSuperhero {
    val batman = Superhero(
        id = 69,
        name = "Batman",
        fullName = "Bruce Wayne",
        publisher = "DC Comics",
        imageUrl = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/md/69-batman.jpg",
        stats = mapOf(
            "intelligence" to 100,
            "strength" to 26,
            "speed" to 27,
            "durability" to 50,
            "power" to 47,
            "combat" to 100
        ),
        appearance = com.example.superheroparcial.data.model.HeroAppearance(
            gender = "Male",
            race = "Human",
            height = listOf("6'2", "188 cm"),
            weight = listOf("210 lb", "95 kg"),
            eyeColor = "Blue",
            hairColor = "Black"
        ),
        biography = com.example.superheroparcial.data.model.HeroBiography(
            placeOfBirth = "Gotham City",
            firstAppearance = "Detective Comics #27",
            alignment = "Good",
            aliases = listOf("The Dark Knight")
        ),
        work = com.example.superheroparcial.data.model.HeroWork(
            occupation = "Businessman",
            base = "Gotham City"
        ),
        connections = com.example.superheroparcial.data.model.HeroConnections(
            groupAffiliation = "Justice League",
            relatives = "Thomas Wayne, Martha Wayne"
        )
    )
    val superman = Superhero(
        id = 644,
        name = "Superman",
        fullName = "Clark Kent",
        publisher = "DC Comics",
        imageUrl = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/md/644-superman.jpg",
        stats = mapOf("intelligence" to 94, "strength" to 100, "speed" to 100)
    )
    val heroes = listOf(batman, superman)
}
