package ru.nikomp.cleanarch.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main2.*
import ru.nikomp.cleanarch.R
import ru.nikomp.cleanarch.framework.InMemoryDogsBreedsRemoteSource
import ru.nikomp.data.DogsBreedRepository
import ru.nikomp.domain.DogsBreed
import ru.nikomp.usecases.GetDogsBreeds

class Main2Activity : AppCompatActivity(), MainPresenter.View {


    private val presenter: MainPresenter

    init {
        val persistence = InMemoryDogsBreedsRemoteSource()
        val locationsRepository = DogsBreedRepository(persistence)
        presenter = MainPresenter(
            this,
            GetDogsBreeds(locationsRepository)
        )
    }

    lateinit var dogsBreedsAdapter : ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        presenter.onCreate()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun renderLocations(breedsList: List<DogsBreed>) {

        var list = arrayListOf<String>()
        for (i in 0 until breedsList.size) {
            list.add(breedsList.get(i).name)
        }

        val listview = breeds

        dogsBreedsAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
        listview.adapter=dogsBreedsAdapter

    }
}
