package org.suwashizmu.connpassapp.module.repository.remote

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.Single
import org.junit.Test
import org.suwashizmu.connpassapp.module.entity.Area
import org.suwashizmu.connpassapp.service.api.Event
import org.suwashizmu.connpassapp.service.api.SearchResult

/**
 * Created by KEKE on 2018/11/16.
 */
class EventDataSourceTest {

    private val eventId = 100
    private val dummyResult = SearchResult(1, listOf(
            Event(
                    eventUrl = "",
                    ownerNickname = "",
                    updatedAt = "2018-10-24T19:00:00+09:00",
                    startedAt = "2018-10-24T19:00:00+09:00",
                    twitterHashTag = "",
                    title = "some event",
                    eventId = eventId,
                    address = "",
                    limit = 10,
                    accepted = 10,
                    catch = "",
                    place = "",
                    waiting = 10,
                    endedAt = "2018-10-24T19:00:00+09:00",
                    description = "htmlFormat"
            )
    ), 2, 3)

    private val dataSource: EventDataSource = EventDataSource(
            LocalEventDataSource(),
            RemoteEventDataSource(mock {
                on { searchEvents(any()) } doReturn Single.just(dummyResult)
            })
    )

    @Test
    fun `findById when cached event`() {
        val test = dataSource.findEventList(0, 0, Area.AOMORI)
                .flatMap {
                    dataSource.findById(eventId)
                }
                .test()

        test.assertNoErrors()
        test.assertValue {
            it.id == eventId && it.title == "some event"
        }
    }

    @Test
    fun `findById when before call findEventList`() {
        val test = dataSource.findById(10).test()

        test.assertError { it is IllegalArgumentException }
    }

    @Test
    fun findEventList() {
        val test = dataSource.findEventList(0, 0, Area.AOMORI).test()

        test.assertNoErrors()
        test.assertValue {
            it.totalEventCount == 3 && it.eventList.size == 1
        }
    }
}