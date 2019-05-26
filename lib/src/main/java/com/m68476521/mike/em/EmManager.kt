package com.m68476521.mike.em

class EmManager(private val emService: EmService) {
    fun getPublicCharacters(limit: Int) = emService.getPublicCharacters(limit)
}