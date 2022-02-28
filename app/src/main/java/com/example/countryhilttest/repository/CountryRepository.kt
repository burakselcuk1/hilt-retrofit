package com.example.countryhilttest.repository

import com.example.countryhilttest.api.api
import javax.inject.Inject

class CountryRepository @Inject constructor(private val api: api) {
    suspend fun getAllsCountry() = api.getAllCountry()
}