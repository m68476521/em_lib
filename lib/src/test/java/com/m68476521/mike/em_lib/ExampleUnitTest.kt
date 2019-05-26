package com.m68476521.mike.em_lib

import com.m68476521.mike.em.EmManager
import com.m68476521.mike.em.EmService
import org.junit.Before
import org.junit.Test

class ExampleUnitTest {
    private val url = ""
    private val key = ""
    private val hash = ""
    private lateinit var emManager: EmManager

    @Before
    fun setupApi() {
        val emService = EmService.create(url, key, hash)
        emManager = EmManager(emService)
    }

    @Test
    fun fetch20PublicCharacters() {
        emManager.getPublicCharacters(20)
            .test().assertNoErrors()
    }
}
