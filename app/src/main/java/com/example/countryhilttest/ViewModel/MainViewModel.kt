package com.example.countryhilttest.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countryhilttest.model.Country
import com.example.countryhilttest.repository.CountryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: CountryRepository): ViewModel() {


    val _country = MutableLiveData<List<Country>>()

    val country:LiveData<List<Country>>
    get() = _country

    init {
        getAllCountry()
    }

    fun getAllCountry()=viewModelScope.launch{
        repository.getAllsCountry().let { response ->
            if (response.isSuccessful){
                _country.postValue(response.body())
            }else{
                Log.e("BRK:MAİNVİEWMODEL","name: $response")
            }
        }
    }

}