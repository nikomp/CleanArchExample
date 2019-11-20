package ru.nikomp.data

import ru.nikomp.domain.DogsBreed

class DogsBreedRepository (private val dogsBreedsRemoteSource: DogsBreedsRemoteSource) {
    fun requestNewDogsBreed(): List<DogsBreed> {
        return dogsBreedsRemoteSource.getRemoteDogsBreeds()
    }
}