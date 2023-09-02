package com.curso.android.app.practica.comparador.view

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.curso.android.app.practica.comparador.R
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get: Rule
    var rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun mainActivity_compareEqualStrings() {
        Espresso.onView(
            ViewMatchers.withId(R.id.entrada1)
        ).perform(
            ViewActions.typeText("Texto de ejemplo")
        )
        Thread.sleep(1000)
        Espresso.onView(ViewMatchers.isRoot())
            .perform(ViewActions.pressBack())
        Thread.sleep(1000)
        Espresso.onView(
            ViewMatchers.withId(R.id.entrada2)
        ).perform(
            ViewActions.typeText("Texto de ejemplo")
        )
        Espresso.onView(ViewMatchers.isRoot())
            .perform(ViewActions.pressBack())
        Thread.sleep(1000)
        Espresso.onView(
            ViewMatchers.withId(R.id.botonComparar)
        ).perform(
            ViewActions.click()
        )
        Espresso.onView(
            ViewMatchers.withId(R.id.textoComparacion)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("Los textos son iguales")
            )
        )
    }
}