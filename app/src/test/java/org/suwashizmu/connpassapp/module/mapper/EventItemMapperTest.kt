package org.suwashizmu.connpassapp.module.mapper

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.suwashizmu.connpassapp.module.output.EventSearchOutputData
import org.threeten.bp.ZonedDateTime
import org.threeten.bp.format.DateTimeFormatter

/**
 * Created by KEKE on 2018/12/02.
 */
class EventItemMapperTest {

    private val mapper = EventItemMapper()

    @Test
    fun toEvent() {
        val viewModelEvent = mapper.toEvent(EventSearchOutputData.OutputEvent(
                id = 1,
                eventUrl = "url",
                startedAt = ZonedDateTime.parse("2018/12/01 18:00:00 Asia/Tokyo", DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss VV")),
                catch = "catch",
                title = "title",
                description = "description"
        ))

        assertThat(viewModelEvent.id).isEqualTo(1)
        assertThat(viewModelEvent.catch).isEqualTo("catch")
        assertThat(viewModelEvent.eventUrl).isEqualTo("url")
        assertThat(viewModelEvent.startedAt).isEqualTo("2018-12-01 18:00")
        assertThat(viewModelEvent.title).isEqualTo("title")
        assertThat(viewModelEvent.isExpired).isTrue()
    }
}