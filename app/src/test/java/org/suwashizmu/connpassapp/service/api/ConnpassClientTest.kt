package org.suwashizmu.connpassapp.service.api

import org.junit.Ignore
import org.junit.Test

/**
 * Created by KEKE on 2018/10/03.
 */
class ConnpassClientTest {

    //networkを使用するためignore
    @Ignore
    @Test
    fun `search event`() {
        val service = ConnpassClient.service

        val test = service.searchEvents(mapOf("keyword" to "kotlin")).test()

        test.assertNoErrors()

        test.assertValue {
            print(it)
            it != null
        }
    }
}