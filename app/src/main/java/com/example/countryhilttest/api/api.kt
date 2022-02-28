package com.example.countryhilttest.api

import com.example.countryhilttest.model.Country
import retrofit2.Response
import retrofit2.http.GET

interface api {

    @GET("atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json")
   suspend fun getAllCountry():Response<List<Country>>
}