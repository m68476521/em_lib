package com.m68476521.mike.em

import com.google.gson.annotations.SerializedName
import java.util.Date

data class Character(
    val code: Int,
    val status: String,
    val copyRight: String,
    val attributionText: String,
    val attributionHTML: String,
    val etag: String,
    val data: Data
)

data class Data(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<Results>
)

data class Results(
    val id: Int,
    val name: String,
    val description: String,
    val modified: Date,
    val thumbnail: Thumbnail,
    @SerializedName("resourceURI")
    val resourceUri: String,
    val comics: CollectionTypeA,
    val series: CollectionTypeA,
    val stories: CollectionTypeB,
    val event: CollectionTypeA,
    val urls: List<Url>

)

data class Thumbnail(
    val path: String,
    val extension: String
)

data class CollectionTypeA(
    val available: Int,
    @SerializedName("collectionURI")
    val collectionUri: String,
    val items: List<ItemA>,
    val returned: Int
)

data class ItemA(
    @SerializedName("resourceURI")
    val resourceUri: String,
    val name: String
)

data class CollectionTypeB(
    val available: Int,
    @SerializedName("collectionURI")
    val collectionUri: String,
    val items: List<ItemB>,
    val returned: Int
)

data class ItemB(
    @SerializedName("resourceURI")
    val resourceUri: String,
    val name: String,
    val type: String
)

data class Url(
    val type: String,
    val url: String
)