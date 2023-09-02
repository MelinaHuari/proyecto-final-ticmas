package com.curso.android.app.practica.comparador

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.curso.android.app.practica.comparador.view.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test


@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class MainViewModelUnitTest {

    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup(){
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun mainViewModel_verificarValorInicial() = runTest {
        val comparacion = viewModel.comparador.value?.comparacion
        val primerCadena = viewModel.comparador.value?.cadena1
        val segundaCadena = viewModel.comparador.value?.cadena2
        assertEquals(comparacion, "-")
        assertEquals(primerCadena, "-")
        assertEquals(segundaCadena, "-")
    }

    @Test
    fun mainViewModel_verificaTextosIguales() = runTest {
        launch {
            viewModel.compararTextos("texto de ejemplo", "texto de ejemplo")

        }
        advanceUntilIdle()

        val comparacion = viewModel.comparador.value?.comparacion
        assertEquals(comparacion, "Los textos SÍ son iguales")
    }

}