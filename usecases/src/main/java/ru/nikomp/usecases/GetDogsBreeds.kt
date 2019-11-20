package ru.nikomp.usecases

import ru.nikomp.data.DogsBreedRepository
import ru.nikomp.domain.DogsBreed

class GetDogsBreeds(private val dogsBreedRepository: DogsBreedRepository) {
    operator fun invoke(): List<DogsBreed> = dogsBreedRepository.requestNewDogsBreed()
}