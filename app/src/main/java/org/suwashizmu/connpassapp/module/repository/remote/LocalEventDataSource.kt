package org.suwashizmu.connpassapp.module.repository.remote

import io.reactivex.Single
import org.suwashizmu.connpassapp.module.entity.Area
import org.suwashizmu.connpassapp.module.entity.Event
import org.suwashizmu.connpassapp.module.entity.EventList
import org.suwashizmu.connpassapp.module.repository.EventRepository

/**
 * Created by KEKE on 2018/11/16.
 */
class LocalEventDataSource : EventRepository {

    val cachedEvents = mutableSetOf<Event>()

    override fun findById(id: Int): Single<Event> =
            Single.create {
                val event = cachedEvents.firstOrNull()
                if (event != null) it.onSuccess(event) else it.onError(IllegalArgumentException("not found Event"))
            }

    override fun findEventList(start: Int, limit: Int, area: Area?, vararg keywordOr: String): Single<EventList> {
        //remoteから取得する
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}