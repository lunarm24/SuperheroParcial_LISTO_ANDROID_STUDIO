package com.example.superheroparcial.data.repository

import com.example.superheroparcial.data.DTO.toSuperheroInfo
import com.example.superheroparcial.data.model.Superhero
import com.example.superheroparcial.data.source.SuperheroDataSource
import kotlinx.coroutines.CancellationException
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

interface SuperheroRepository {
    suspend fun getAll(): Result<List<Superhero>>

    suspend fun getById(id: Int): Result<Superhero>
}

class SuperheroRepositoryImpl @Inject constructor(
    private val source: SuperheroDataSource
) : SuperheroRepository {
    override suspend fun getAll(): Result<List<Superhero>> =
        requestResult { source.getAll().map { it.toSuperheroInfo() } }

    override suspend fun getById(id: Int): Result<Superhero> =
        requestResult { source.getById(id).toSuperheroInfo() }

    private suspend fun <T> requestResult(request: suspend () -> T): Result<T> {
        return try {
            Result.success(request())
        } catch (exception: CancellationException) {
            throw exception
        } catch (exception: IOException) {
            Result.failure(Exception("Revisa tu conexión a Internet.", exception))
        } catch (exception: HttpException) {
            Result.failure(
                Exception("No se pudo consultar el servidor (${exception.code()}).", exception)
            )
        } catch (exception: Exception) {
            Result.failure(Exception("Ocurrió un error al consultar superhéroes.", exception))
        }
    }
}
