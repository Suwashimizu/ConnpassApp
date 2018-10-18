package org.suwashizmu.connpassapp.module.entity

/**
 * Created by KEKE on 2018/10/17.
 */
data class EventList(
        val totalEventCount: Int,
        val eventList: Collection<Event>)