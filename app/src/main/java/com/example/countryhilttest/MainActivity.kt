package com.example.countryhilttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countryhilttest.ViewModel.MainViewModel
import com.example.countryhilttest.adapter.CountryAdapter
import com.example.countryhilttest.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter : CountryAdapter
    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        viewModel.country.observe(this, Observer {
            binding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = CountryAdapter(it)
            binding.recyclerView.adapter = adapter
        })

    }

}