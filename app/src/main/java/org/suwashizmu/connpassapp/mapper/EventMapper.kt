package org.suwashizmu.connpassapp.mapper

import org.suwashizmu.connpassapp.entity.Event
import org.suwashizmu.connpassapp.service.api.SearchResult
import org.threeten.bp.ZonedDateTime

/**
 * Created by KEKE on 2018/10/02.
 */
class EventMapper {
    fun toEvent(searchResult: SearchResult): Collection<Event> =
            searchResult.events.map {
                Event(id = it.eventId,
                        address = it.address,
                        limit = it.limit,
                        accepted = it.accepted,
                        catch = it.catch,
                        description = it.description,
                        endedAt = ZonedDateTime.parse(it.endedAt),
                        eventUtl = it.eventUrl,
                        place = it.place,
                        startedAt = ZonedDateTime.parse(it.startedAt),
                        title = it.title,
                        twitterHashTag = it.twitterHashTag,
                        waiting = it.waiting)
            }
}