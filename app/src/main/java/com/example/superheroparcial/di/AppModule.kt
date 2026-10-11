package com.example.superheroparcial.di
import com.example.superheroparcial.data.remote.SuperheroApi
import com.example.superheroparcial.data.repository.SuperheroRepository
import com.example.superheroparcial.data.repository.SuperheroRepositoryImpl
import com.example.superheroparcial.data.source.RemoteSuperheroDataSource
import com.example.superheroparcial.data.source.SuperheroDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://akabab.github.io/superhero-api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideSuperheroService(retrofit: Retrofit): SuperheroApi {
        return retrofit.create(SuperheroApi::class.java)
    }

    @Provides
    @Singleton
    fun provideSuperheroDataSource(
        source: RemoteSuperheroDataSource
    ): SuperheroDataSource {
        return source
    }

    @Provides
    @Singleton
    fun provideSuperheroRepository(
        repository: SuperheroRepositoryImpl
    ): SuperheroRepository {
        return repository
    }
}
