package com.example.superheroparcial.data.source
import com.example.superheroparcial.data.DTO.SuperheroDto
import com.example.superheroparcial.data.remote.SuperheroApi
import javax.inject.Inject

class RemoteSuperheroDataSource @Inject constructor(private val api: SuperheroApi) : SuperheroDataSource {
    override suspend fun getAll(): List<SuperheroDto> {
        return api.getAll()
    }

    override suspend fun getById(id: Int): SuperheroDto {
        return api.getById(id)
    }
}
