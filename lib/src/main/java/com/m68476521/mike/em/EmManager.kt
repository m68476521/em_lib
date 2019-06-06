package com.m68476521.mike.em

class EmManager(private val emService: EmService) {
    fun init() {
    }
    fun getPublicCharacters(limit: Int) = emService.getPublicCharacters(limit)

    fun getCharacterById(id: Int) = emService.getCharacterById(id)
}