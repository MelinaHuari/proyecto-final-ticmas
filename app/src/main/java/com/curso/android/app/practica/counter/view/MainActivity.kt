package com.curso.android.app.practica.counter.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
//import com.curso.android.app.practica.comparador.databinding.ActivityMainBinding
import com.curso.android.app.practica.counter.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.comparador.observe(this) {
            binding.textoComparacion.text = it.comparacion
        }

        binding.botonComparar.setOnClickListener {
            val entradaTexto1 = binding.entrada1.text.toString()
            val entradaTexto2 = binding.entrada2.text.toString()
            mainViewModel.compareStrings(entradaTexto1, entradaTexto2)
        }
    }
}