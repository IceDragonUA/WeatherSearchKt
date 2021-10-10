package com.rnd.domain.model

/**
 * @author Vladyslav Havrylenko
 * @since 09.06.2021
 */
data class SearchData(
    val id: Int?,
    val name: String?,
    val main: Main?,
    val sys: Country?,
    val weather: Weather?,
)

data class Main(
    val temp: Float?
)

data class Country(
    val country: String?
)

data class Weather(
    val main: String?,
    val description: String?,
    val icon: String?
)