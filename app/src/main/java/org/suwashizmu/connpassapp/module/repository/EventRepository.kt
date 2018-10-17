package org.suwashizmu.connpassapp.module.repository

import io.reactivex.Single
import org.suwashizmu.connpassapp.module.entity.Event

/**
 * Created by KEKE on 2018/10/05.
 *
 * interface adapter層
 */
interface EventRepository {
    fun findEvent(start: Int, limit: Int, vararg keyword: String): Single<Collection<Event>>
}