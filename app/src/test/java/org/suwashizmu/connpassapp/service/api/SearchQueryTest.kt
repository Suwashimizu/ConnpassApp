package org.suwashizmu.connpassapp.service.api

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

/**
 * Created by KEKE on 2018/10/03.
 */
class SearchQueryTest {

    @Test
    fun `default count value is 30`() {
        val query = SearchQuery.build { }

        assertThat(query.count).isEqualTo(30)
    }

    @Test
    fun `default order value is UPDATED`() {
        val query = SearchQuery.build { }

        assertThat(query.order).isEqualTo(SearchQuery.Order.UPDATED.value)
    }

    @Test
    fun `to map`() {
        val query = SearchQuery.build {
            eventId = 1234
            keyword = setOf("kotlin", "java")
            keywordOr = setOf("python")
            ym = setOf(2001, 1980)
            ymd = setOf(20100120)
            nickname = setOf("taro")
            ownerNickname = setOf("yamada")
            seriesId = setOf(1, 2)
            start = 5
        }.toMap()

        assertThat(query["event_id"]).isEqualTo("1234")
        assertThat(query["keyword"]).isEqualTo("kotlin,java")
        assertThat(query["keyword_or"]).isEqualTo("python")
        assertThat(query["ym"]).isEqualTo("2001,1980")
        assertThat(query["ymd"]).isEqualTo("20100120")
        assertThat(query["nickname"]).isEqualTo("taro")
        assertThat(query["owner_nickname"]).isEqualTo("yamada")
        assertThat(query["series_id"]).isEqualTo("1,2")
        assertThat(query["start"]).isEqualTo("5")
        assertThat(query["order"]).isEqualTo("1")
        assertThat(query["count"]).isEqualTo("30")
    }


    @Test
    fun `no set value is null`() {

        val query = SearchQuery.build {
            keyword = setOf("kotlin", "java")
            ym = setOf(2001, 1980)
            ymd = setOf(20100120)
            nickname = setOf("taro")
            start = 5
        }.toMap()

        assertThat(query["event_id"]).isNull()
        assertThat(query["keyword"]).isEqualTo("kotlin,java")
        assertThat(query["keyword_or"]).isNull()
        assertThat(query["ym"]).isEqualTo("2001,1980")
        assertThat(query["ymd"]).isEqualTo("20100120")
        assertThat(query["nickname"]).isEqualTo("taro")
        assertThat(query["owner_nickname"]).isNull()
        assertThat(query["series_id"]).isNull()
        assertThat(query["start"]).isEqualTo("5")
        assertThat(query["order"]).isEqualTo("1")
        assertThat(query["count"]).isEqualTo("30")
    }
}