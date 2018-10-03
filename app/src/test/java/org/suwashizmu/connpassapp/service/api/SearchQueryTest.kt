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


}