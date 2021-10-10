package com.rnd.domain.model

/**
 * @author Vladyslav Havrylenko
 * @since 09.06.2021
 */
data class SearchData(
    val id: Int?,
    val name: String?,
    val temp: Float?,
    val country: String?,
    val shortDescription: String?,
    val longDescription: String?,
    val latitude: Float?,
    val longitude: Float?,
    val icon: String?
)