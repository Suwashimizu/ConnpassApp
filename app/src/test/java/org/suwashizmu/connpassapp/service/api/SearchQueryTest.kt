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
            keyword = "kotlin"
            keywordOr = "python"
            ym = 2001
            ymd = 20100120
            nickname = "taro"
            ownerNickname = "yamada"
            seriesId = 1
            start = 5
        }.toMap()

        assertThat(query["event_id"]).isEqualTo("1234")
        assertThat(query["keyword"]).isEqualTo("kotlin")
        assertThat(query["keyword_or"]).isEqualTo("python")
        assertThat(query["ym"]).isEqualTo("2001")
        assertThat(query["ymd"]).isEqualTo("20100120")
        assertThat(query["nickname"]).isEqualTo("taro")
        assertThat(query["owner_nickname"]).isEqualTo("yamada")
        assertThat(query["series_id"]).isEqualTo("1")
        assertThat(query["start"]).isEqualTo("5")
        assertThat(query["order"]).isEqualTo("1")
        assertThat(query["count"]).isEqualTo("30")
    }

}