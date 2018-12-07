package org.suwashizmu.connpassapp.module.repository

import io.reactivex.Single
import org.suwashizmu.connpassapp.module.entity.Area
import org.suwashizmu.connpassapp.module.entity.Event
import org.suwashizmu.connpassapp.module.entity.EventList
import org.threeten.bp.ZonedDateTime

/**
 * Created by KEKE on 2018/11/17.
 */
class StubEventDataSource : EventRepository {

    private val event = Event(
            id = 106516,
            title = "第6回 意思決定のためのデータ分析勉強会 in Fukuoka",
            catch = "〜 異常検知、品質向上・改善祭り 〜",
            description = "description",
            ownerName = "doradora09",
            eventUtl = "https://ishikettei.connpass.com/event/106516/",
            twitterHashTag = "ishikettei",
            startedAt = ZonedDateTime.parse("2018-11-17T14:00+09:00"),
            endedAt = ZonedDateTime.parse("2018-11-17T18:00+09:00"),
            limit = 46,
            place = "福岡システムＬＳＩ総合開発センター (４階　交流サロン)",
            address = "〒814-0001 福岡県福岡市早良区百道浜３丁目８−３３",
            accepted = 41,
            waiting = 0
    )

    private val event2 = event.copy(id = event.id + 1)

    override fun findById(id: Int): Single<Event> =
            Single.just(event)

    override fun findEventList(start: Int, limit: Int, area: Area?, vararg keywordOr: String): Single<EventList> =
            Single.just(EventList(2, listOf(event, event2)))
}