package org.suwashizmu.connpassapp.module.presenter

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test
import org.suwashizmu.connpassapp.module.output.EventSearchOutputData
import org.suwashizmu.connpassapp.module.view.ISearchEventView
import org.threeten.bp.ZonedDateTime
import org.threeten.bp.format.DateTimeFormatter

/**
 * Created by KEKE on 2018/10/06.
 */
class EventSearchPresenterTest {

    private val view: ISearchEventView = mock()
    private val presenter = EventSearchPresenter(view)

    @Test
    fun complete() {
        presenter.complete(EventSearchOutputData(listOf(EventSearchOutputData.OutputEvent(1, "title", "catch", "description", ZonedDateTime.parse("2018/12/01 18:00:00 Asia/Tokyo", DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss VV")), "url")), null, 100))

        verify(view).updated(any())
    }
}