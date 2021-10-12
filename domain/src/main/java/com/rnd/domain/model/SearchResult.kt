package com.rnd.domain.model

/**
 * @author Vladyslav Havrylenko
 * @since 09.06.2021
 */
data class SearchResult(
    val id: String?,
    val name: String?,
    val temp: String?,
    val country: String?,
    val shortDescription: String?,
    val longDescription: String?,
    val latitude: String?,
    val longitude: String?,
    val icon: String?
)