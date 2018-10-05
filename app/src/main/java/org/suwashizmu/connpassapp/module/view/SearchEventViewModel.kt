package org.suwashizmu.connpassapp.module.view

/**
 * Created by KEKE on 2018/10/05.
 */
class SearchEventViewModel(
        val eventList: Collection<Event>) {

    override fun toString(): String {
        return "EventCount:${eventList.size},Events:[${eventList.joinToString(",")}]"
    }

    data class Event(val title: String)
}