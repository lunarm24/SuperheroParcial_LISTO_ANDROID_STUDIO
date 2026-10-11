package com.example.superheroparcial.data.source
import com.example.superheroparcial.data.DTO.SuperheroDto
import com.example.superheroparcial.data.remote.SuperheroApi
import javax.inject.Inject

interface SuperheroDataSource {
    suspend fun getAll(): List<SuperheroDto>

    suspend fun getById(id: Int): SuperheroDto
}

class RemoteSuperheroDataSource @Inject constructor(
    private val api: SuperheroApi
) : SuperheroDataSource {
    override suspend fun getAll(): List<SuperheroDto> = api.getAll()

    override suspend fun getById(id: Int): SuperheroDto = api.getById(id)
}
