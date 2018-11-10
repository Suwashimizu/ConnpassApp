package org.suwashizmu.connpassapp.module.repository.remote

import io.reactivex.Single
import org.suwashizmu.connpassapp.module.entity.Area
import org.suwashizmu.connpassapp.module.entity.EventList
import org.suwashizmu.connpassapp.module.mapper.EventMapper
import org.suwashizmu.connpassapp.module.repository.EventRepository
import org.suwashizmu.connpassapp.service.api.ConnpassService
import org.suwashizmu.connpassapp.service.api.SearchQuery

/**
 * Created by KEKE on 2018/10/05.
 * api経由でEventを取得する
 */
class RemoteEventDataSource(private val client: ConnpassService) : EventRepository {

    private val mapper = EventMapper()

    override fun findEventList(start: Int, limit: Int, area: Area?, vararg keywordOr: String): Single<EventList> {
        val query = SearchQuery.build {
            this.keyword = setOf(area?.value ?: "")
            this.keywordOr = keywordOr.toSet()
            this.start = start
            this.count = limit
        }

        return client.searchEvents(query.toMap())
                .map(mapper::toEvent)
    }
}