package com.example.superheroparcial.data.repository
import com.example.superheroparcial.data.model.Superhero
import com.example.superheroparcial.data.model.toSuperheroInfo
import com.example.superheroparcial.data.source.SuperheroDataSource
import kotlinx.coroutines.CancellationException
import java.io.IOException
import retrofit2.HttpException
import javax.inject.Inject
class SuperheroRepositoryImpl @Inject constructor(private val source: SuperheroDataSource) : SuperheroRepository {
    override suspend fun getAll(): Result<List<Superhero>> = safely { source.getAll().map { it.toSuperheroInfo() } }
    override suspend fun getById(id: Int): Result<Superhero> = safely { source.getById(id).toSuperheroInfo() }
    private suspend fun <T> safely(block: suspend () -> T): Result<T> = try { Result.success(block()) }
    catch (e: CancellationException) { throw e }
    catch (e: IOException) { Result.failure(Exception("Revisa tu conexión a Internet.", e)) }
    catch (e: HttpException) { Result.failure(Exception("No se pudo consultar el servidor (${e.code()}).", e)) }
    catch (e: Exception) { Result.failure(Exception("Ocurrió un error al cargar los superhéroes.", e)) }
}
