package org.suwashizmu.connpassapp.module.mapper

import org.suwashizmu.connpassapp.module.output.EventSearchOutputData
import org.suwashizmu.connpassapp.module.view.EventListViewModel
import org.threeten.bp.ZonedDateTime
import org.threeten.bp.format.DateTimeFormatter

/**
 * Created by KEKE on 2018/12/02.
 */
class EventItemMapper {

    private val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")

    fun toEvent(outputEvent: EventSearchOutputData.OutputEvent): EventListViewModel.Event =
            EventListViewModel.Event(
                    id = outputEvent.id,
                    catch = outputEvent.catch,
                    title = outputEvent.title,
                    startedAt = outputEvent.startedAt.format(formatter),
                    eventUrl = outputEvent.eventUrl,
                    isExpired = outputEvent.startedAt.isBefore(ZonedDateTime.now())
            )
}