package com.example.superheroparcial.data.repository

import com.example.superheroparcial.data.DTO.toSuperheroInfo
import com.example.superheroparcial.data.model.Superhero
import com.example.superheroparcial.data.source.SuperheroDataSource
import kotlinx.coroutines.CancellationException
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class SuperheroRepositoryImpl @Inject constructor(
    private val source: SuperheroDataSource
) : SuperheroRepository {
    override suspend fun getAll(): Result<List<Superhero>> {
        return try {
            val heroes = source.getAll().map { it.toSuperheroInfo() }
            Result.success(heroes)
        } catch (exception: CancellationException) {
            throw exception
        } catch (exception: IOException) {
            Result.failure(Exception("Revisa tu conexión a Internet.", exception))
        } catch (exception: HttpException) {
            Result.failure(
                Exception("No se pudo consultar el servidor (${exception.code()}).", exception)
            )
        } catch (exception: Exception) {
            Result.failure(Exception("Ocurrió un error al cargar los superhéroes.", exception))
        }
    }

    override suspend fun getById(id: Int): Result<Superhero> {
        return try {
            val hero = source.getById(id).toSuperheroInfo()
            Result.success(hero)
        } catch (exception: CancellationException) {
            throw exception
        } catch (exception: IOException) {
            Result.failure(Exception("Revisa tu conexión a Internet.", exception))
        } catch (exception: HttpException) {
            Result.failure(
                Exception("No se pudo consultar el servidor (${exception.code()}).", exception)
            )
        } catch (exception: Exception) {
            Result.failure(Exception("Ocurrió un error al cargar los superhéroes.", exception))
        }
    }
}
