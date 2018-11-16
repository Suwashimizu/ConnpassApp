package org.suwashizmu.connpassapp.module.repository.remote

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.Single
import org.junit.Test
import org.suwashizmu.connpassapp.module.entity.Area
import org.suwashizmu.connpassapp.service.api.SearchResult

/**
 * Created by KEKE on 2018/11/16.
 */
class EventDataSourceTest {

    private val dummyResult = SearchResult(1, emptyList(), 2, 3)

    private val dataSource: EventDataSource = EventDataSource(
            LocalEventDataSource(),
            RemoteEventDataSource(mock {
                on { searchEvents(any()) } doReturn Single.just(dummyResult)
            })
    )

    @Test
    fun findById() {


    }

    @Test
    fun findEventList() {
        val test = dataSource.findEventList(0, 0, Area.AOMORI).test()

        test.assertNoErrors()
        test.assertValue {
            it.totalEventCount == 3 && it.eventList.isEmpty()
        }
    }
}