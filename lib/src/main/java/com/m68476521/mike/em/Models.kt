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

// Comics
data class ComicWrapper(
    val code: Int,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHTML: String,
    val etag: String,
    val data: ComicDataContainer
)

data class ComicDataContainer(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<Comic>
)

data class Comic(
    val id: Int,
    val digitalId: Int,
    val title: String,
    val issueNumber: Int,
    val variantDescription: String,
    val description: String,
    val modified: String,
    val isbn: String,
    val upc: String,
    val diamondCode: String,
    val ean: String,
    val issn: String,
    val format: String,
    val pageCount: Int,
    val textObjects: List<TextObject>,
    @SerializedName("resourceURI")
    val resourceUri: String,
    val urls: List<Url>,
    val series: SeriesSummary,
    val variants: List<ComicSummary>,
    val collections: List<ComicSummary>,
    val collectionsIssues: List<ComicSummary>,
    val dates: List<ComicDate>,
    val prices: List<ComicPrice>,
    val thumbnail: Image,
    val images: List<Image>,
    val creators: CreatorList,
    val characters: CharacterList,
    val stories: StoryList,
    val event: EventList

)

data class SeriesSummary(
    @SerializedName("resourceURI")
    val resourceUri: String,
    val name: String
)

data class ComicSummary(
    @SerializedName("resourceURI")
    val resourceUri: String,
    val name: String
)

data class TextObject(
    val type: String,
    val language: String,
    val text: String
)

data class ComicDate(val type: String, val date: String)

data class ComicPrice(val type: String, val price: Double)

data class CreatorList(
    val available: Int,
    val returned: Int,
    val collectionURI: String,
    val items: List<CreatorSummary>
)

data class CreatorSummary(
    @SerializedName("resourceURI")
    val resourceUri: String,
    val name: String,
    val role: String
)

data class Image(
    val path: String,
    val extension: String
)

data class CharacterList(
    val available: Int,
    val returned: Int,
    @SerializedName("collectionURI")
    val collectionUri: String,
    val items: List<CharacterSummary>
)

data class CharacterSummary(
    @SerializedName("resourceURI")
    val resourceUri: String,
    val name: String,
    val role: String
)

data class StoryList(
    val available: Int,
    val returned: Int,
    @SerializedName("collectionURI")
    val collectionUri: String,
    val items: List<StorySummary>
)

data class StorySummary(
    @SerializedName("resourceURI")
    val resourceUri: String,
    val name: String,
    val type: String
)

data class EventList(
    val available: Int,
    val returned: Int,
    @SerializedName("collectionURI")
    val collectionUri: String,
    val items: List<EventSummary>
)

data class EventSummary(
    @SerializedName("resourceURI")
    val resourceUri: String,
    val name: String
)