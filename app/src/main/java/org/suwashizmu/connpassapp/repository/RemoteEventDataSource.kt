package org.suwashizmu.connpassapp.repository

import io.reactivex.Single
import org.suwashizmu.connpassapp.entity.Event
import org.suwashizmu.connpassapp.mapper.EventMapper
import org.suwashizmu.connpassapp.service.api.ConnpassClient
import org.suwashizmu.connpassapp.service.api.SearchQuery

/**
 * Created by KEKE on 2018/10/05.
 * api経由でEventを取得する
 */
class RemoteEventDataSource : EventRepository {

    private val client = ConnpassClient.service
    private val mapper = EventMapper()

    override fun findEvent(vararg keyword: String): Single<Collection<Event>> {
        val query = SearchQuery.build {
            this.keyword = keyword.toSet()
        }

        return client.searchEvents(query.toMap())
                .map(mapper::toEvent)
    }
}