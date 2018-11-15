package org.suwashizmu.connpassapp.module.usecase

import com.nhaarman.mockitokotlin2.*
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.suwashizmu.connpassapp.module.entity.Area
import org.suwashizmu.connpassapp.module.entity.Event
import org.suwashizmu.connpassapp.module.entity.EventList
import org.suwashizmu.connpassapp.module.input.EventSearchInputData
import org.suwashizmu.connpassapp.module.presenter.IEventListPresenter
import org.suwashizmu.connpassapp.module.presenter.IEventSearchPresenter
import org.suwashizmu.connpassapp.module.repository.EventRepository
import org.threeten.bp.ZonedDateTime
import java.net.UnknownHostException

/**
 * Created by KEKE on 2018/10/14.
 */
class EventListInteractorTest {

    private val presenter: IEventListPresenter = mock()

    private val result = EventList(100, listOf(Event(
            1,
            "title",
            "catch",
            "ownerName",
            "description",
            "eventUrl",
            "twitterHashTag",
            ZonedDateTime.now(),
            ZonedDateTime.now(),
            10,
            "place",
            "address",
            10,
            5))
    )

    private val repository: EventRepository = mock {
        on { findEventList(any(), any(), any(), any()) } doReturn Single.create<EventList> { emitter ->
            emitter.onSuccess(result)
        }
    }

    private val eventListInteractor = EventListInteractor(presenter, repository)

    private fun makeInteractor(presenter: IEventSearchPresenter, repository: EventRepository): EventSearchInteractor = EventSearchInteractor(presenter, repository)


    @Before
    fun setup() {
        //Schedulersの差し替え
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
    }

    @Test
    fun `search`() {

        eventListInteractor.search(EventSearchInputData(keyword = setOf("kotlin"), ym = 201802, offset = 0, limit = 30, area = Area.FUKUSHIMA))

        verify(repository).findEventList(any(), any(), any(), any())
        verify(presenter).complete(check {
            assertThat(it.totalEventCount).isEqualTo(100)
        })
    }

    @Test
    fun `search error`() {

        val errorRepository: EventRepository = mock {
            on { findEventList(any(), any(), any(), any()) } doReturn Single.error(UnknownHostException("unknownHost"))
        }

        val presenter: IEventSearchPresenter = mock()

        makeInteractor(presenter, errorRepository).search(EventSearchInputData(keyword = setOf("kotlin"), ym = 201802, offset = 0, limit = 30, area = Area.FUKUSHIMA))

        verify(errorRepository).findEventList(any(), any(), any(), any())
        verify(presenter).complete(check {
            assertThat(it.error).isInstanceOf(UnknownHostException::class.java)
        })

    }
}