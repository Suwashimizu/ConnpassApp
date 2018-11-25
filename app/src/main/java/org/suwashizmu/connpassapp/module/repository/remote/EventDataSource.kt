package org.suwashizmu.connpassapp.module.repository.remote

import io.reactivex.Single
import org.suwashizmu.connpassapp.module.entity.Area
import org.suwashizmu.connpassapp.module.entity.Event
import org.suwashizmu.connpassapp.module.entity.EventList
import org.suwashizmu.connpassapp.module.repository.EventRepository

/**
 * Created by KEKE on 2018/11/16.
 */
class EventDataSource(private val localEventDataSource: LocalEventDataSource,
                      private val remoteEventDataSource: RemoteEventDataSource) : EventRepository {

    override fun findById(id: Int): Single<Event> =
            localEventDataSource.findById(id)

    override fun findEventList(start: Int, limit: Int, area: Area?, vararg keywordOr: String): Single<EventList> =
            remoteEventDataSource.findEventList(start, limit, area, *keywordOr)
                    .doOnEvent { t1, t2 ->
                        //取得したイベントはcacheに保存する
                        if (t1 != null) {
                            localEventDataSource.cachedEvents.addAll(t1.eventList)
                        }
                    }

}