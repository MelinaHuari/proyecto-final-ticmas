package com.curso.android.app.practica.counter.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.curso.android.app.practica.counter.model.Comparador
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    val comparador: LiveData<Comparador> get() = _comparador
    private var _comparador = MutableLiveData<Comparador>(
        Comparador("-", "-", "-")
    )

    fun compareStrings(texto1: String, texto2: String) {
        val comparacion = (texto1 == texto2)
        print(comparacion)
        updateComparator(comparacion, texto1, texto2)
    }

    private fun updateComparator(comparacion: Boolean, texto1:String, texto2:String) {
        viewModelScope.launch {
            if(comparacion) {
                _comparador.value = Comparador(texto1, texto2,"Los textos son iguales")
            } else {
                _comparador.value = Comparador(texto1, texto2,"Los textos son diferentes")
            }
        }
    }
}