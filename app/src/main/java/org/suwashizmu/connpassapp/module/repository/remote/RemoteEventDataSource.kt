package org.suwashizmu.connpassapp.module.repository.remote

import io.reactivex.Single
import org.suwashizmu.connpassapp.module.entity.Event
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

    override fun findEvent(vararg keyword: String): Single<Collection<Event>> {
        val query = SearchQuery.build {
            this.keyword = keyword.toSet()
        }

        return client.searchEvents(query.toMap())
                .map(mapper::toEvent)
    }
}