package org.suwashizmu.connpassapp.repository

import io.reactivex.Single
import org.suwashizmu.connpassapp.entity.Event

/**
 * Created by KEKE on 2018/10/05.
 *
 * interface adapter層
 */
interface EventRepository {
    fun findEvent(vararg keyword: String): Single<Collection<Event>>
}