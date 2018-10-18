package org.suwashizmu.connpassapp.module.mapper

import org.suwashizmu.connpassapp.module.entity.Event
import org.suwashizmu.connpassapp.module.entity.EventList
import org.suwashizmu.connpassapp.service.api.SearchResult
import org.threeten.bp.ZonedDateTime

/**
 * Created by KEKE on 2018/10/02.
 */
class EventMapper {
    fun toEvent(searchResult: SearchResult): EventList =
            EventList(
                    totalEventCount = searchResult.resultsAvailable,
                    eventList = searchResult.events.map {
                        Event(id = it.eventId,
                                title = it.title,
                                catch = it.catch,
                                ownerName = it.ownerNickname,
                                description = it.description,
                                eventUtl = it.eventUrl,
                                twitterHashTag = it.twitterHashTag,
                                startedAt = ZonedDateTime.parse(it.startedAt),
                                endedAt = ZonedDateTime.parse(it.endedAt),
                                limit = it.limit ?: -1,
                                place = it.place ?: "",
                                address = it.address ?: "",
                                accepted = it.accepted,
                                waiting = it.waiting)
                    }
            )

}