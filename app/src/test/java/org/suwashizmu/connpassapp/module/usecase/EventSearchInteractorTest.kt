package org.suwashizmu.connpassapp.module.usecase

import com.nhaarman.mockitokotlin2.*
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.suwashizmu.connpassapp.module.entity.Event
import org.suwashizmu.connpassapp.module.input.EventSearchInputData
import org.suwashizmu.connpassapp.module.presenter.IEventSearchPresenter
import org.suwashizmu.connpassapp.module.repository.EventRepository
import org.threeten.bp.ZonedDateTime
import java.net.UnknownHostException

/**
 * Created by KEKE on 2018/10/06.
 *
 * Interactorのテスト
 *
 * - repositoryへの正当な呼び出し
 * - errorハンドリング
 * - outputへ正しくデータを受け渡せているか(これはmapperでいい気ガス)
 *
 * RxのSchedulersの差し替えが必要だったり少しテクニシャン
 */
class EventSearchInteractorTest {

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

    private val repository: EventRepository = mock {
        on { findEvent(any()) } doReturn Single.create<Collection<Event>> { emitter ->
            emitter.onSuccess(result)
        }
    }
    private val presenter: IEventSearchPresenter = mock()

    private val interactor = EventSearchInteractor(repository, presenter)

    private fun makeInteractor(repository: EventRepository): EventSearchInteractor = EventSearchInteractor(repository, presenter)

    @Before
    fun setup() {
        //Schedulersの差し替え
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
    }

    @Test
    fun `search`() {

        interactor.search(EventSearchInputData(keyword = setOf("kotlin"), ym = 201802))

        verify(repository).findEvent(any())

        verify(presenter).complete(any())
    }

    @Test
    fun `search error`() {

        val errorRepository: EventRepository = mock {
            on { findEvent(any()) } doReturn Single.error(UnknownHostException("unknownHost"))
        }

        makeInteractor(errorRepository).search(EventSearchInputData(keyword = setOf("kotlin"), ym = 201802))

        verify(errorRepository).findEvent(any())

        verify(presenter, never()).complete(any())
    }
}