package com.example.superheroparcial.data.remote
import com.example.superheroparcial.data.model.SuperheroDto
import retrofit2.http.GET
import retrofit2.http.Path
interface SuperheroApi {
    @GET("api/all.json") suspend fun getAll(): List<SuperheroDto>
    @GET("api/id/{id}.json") suspend fun getById(@Path("id") id: Int): SuperheroDto
}
