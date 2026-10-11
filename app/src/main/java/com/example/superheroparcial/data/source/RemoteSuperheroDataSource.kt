package com.example.superheroparcial.data.source
import com.example.superheroparcial.data.model.SuperheroDto
import com.example.superheroparcial.data.remote.SuperheroApi
import javax.inject.Inject
class RemoteSuperheroDataSource @Inject constructor(private val api: SuperheroApi) : SuperheroDataSource {
    override suspend fun getAll(): List<SuperheroDto> = api.getAll()
    override suspend fun getById(id: Int): SuperheroDto = api.getById(id)
}
