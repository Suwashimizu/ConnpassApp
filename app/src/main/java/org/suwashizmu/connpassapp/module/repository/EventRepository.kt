package org.suwashizmu.connpassapp.module.repository

import io.reactivex.Single
import org.suwashizmu.connpassapp.module.entity.Area
import org.suwashizmu.connpassapp.module.entity.EventList

/**
 * Created by KEKE on 2018/10/05.
 *
 * interface adapter層
 */
interface EventRepository {
    fun findEventList(start: Int, limit: Int, area: Area?, vararg keywordOr: String): Single<EventList>
}