package ru.nikomp.data

import ru.nikomp.domain.DogsBreed

interface DogsBreedsRemoteSource {
    fun getRemoteDogsBreeds(): List<DogsBreed>
}