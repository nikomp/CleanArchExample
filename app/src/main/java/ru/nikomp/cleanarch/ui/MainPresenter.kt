package ru.nikomp.cleanarch.ui

import ru.nikomp.domain.DogsBreed
import ru.nikomp.usecases.GetDogsBreeds
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainPresenter(
    private var view: View?,
    private val getLocations: GetDogsBreeds
) {
    interface View {
        fun renderLocations(breedsList: List<DogsBreed>)
    }

    fun onCreate() = GlobalScope.launch(Dispatchers.Main) {
        val breedsList = withContext(Dispatchers.IO) { getLocations() }
        view?.renderLocations(breedsList)
    }

    /*fun newLocationClicked() = GlobalScope.launch(Dispatchers.Main) {
        val locations = withContext(Dispatchers.IO) { requestNewLocation() }
        view?.renderLocations(locations.map(DomainLocation::toPresentationModel))
    }*/

    fun onDestroy() {
        view = null
    }
}