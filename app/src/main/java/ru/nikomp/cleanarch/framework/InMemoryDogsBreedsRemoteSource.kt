package ru.nikomp.cleanarch.framework

import ru.nikomp.data.DogsBreedsRemoteSource
import ru.nikomp.domain.DogsBreed

class InMemoryDogsBreedsRemoteSource: DogsBreedsRemoteSource {

    private var dogsBreeds: List<DogsBreed> = listOf(DogsBreed("akita"),DogsBreed("borzoi"), DogsBreed("boxer"))

    override fun getRemoteDogsBreeds(): List<DogsBreed> {
        return dogsBreeds
    }
}