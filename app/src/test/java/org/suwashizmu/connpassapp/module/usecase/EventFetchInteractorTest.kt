package org.suwashizmu.connpassapp.module.usecase

import com.nhaarman.mockitokotlin2.*
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.suwashizmu.connpassapp.module.entity.Event
import org.suwashizmu.connpassapp.module.presenter.IEventListPresenter
import org.suwashizmu.connpassapp.module.repository.AreaRepository
import org.suwashizmu.connpassapp.module.repository.EventRepository
import org.suwashizmu.connpassapp.module.repository.InterestCategoryRepository
import org.threeten.bp.ZonedDateTime
import java.net.UnknownHostException

/**
 * Created by KEKE on 2018/10/14.
 */
class EventFetchInteractorTest {

    private val mockPresenter: IEventListPresenter = mock()
    private val areaMock: AreaRepository = mock()
    private val interestMock: InterestCategoryRepository = mock()

    private val result = listOf(Event(
            1,
            "title",
            "catch",
            "description",
            "eventUrl",
            "twitterHashTag",
            ZonedDateTime.now(),
            ZonedDateTime.now(),
            10,
            "address",
            "place",
            10,
            5))

    private val eventMock: EventRepository = mock {
        on { findEvent(any()) } doReturn Single.just<Collection<Event>>(result)
    }

    private val interactor = EventFetchInteractor(
            presenter = mockPresenter,
            areaRepository = areaMock,
            interestCategoryRepository = interestMock,
            eventRepository = eventMock
    )

    @Before
    fun setup() {
        //Schedulersの差し替え
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
    }

    @Test
    fun fetchEvent() {

        interactor.fetchEvent()

        verify(areaMock).getArea()
        verify(interestMock).getCurrentInterestCategories()
        verify(eventMock).findEvent(any())

        verify(mockPresenter).complete(check {
            assertThat(it.error).isNull()
        })
    }


    @Test
    fun `fetchEvent when error`() {

        whenever(eventMock.findEvent(any())).thenReturn(Single.error(UnknownHostException("unknownHost")))
        interactor.fetchEvent()

        verify(areaMock).getArea()
        verify(interestMock).getCurrentInterestCategories()
        verify(eventMock).findEvent(any())

        verify(mockPresenter).complete(check {
            assertThat(it.error).isNotNull()
        })
    }
}