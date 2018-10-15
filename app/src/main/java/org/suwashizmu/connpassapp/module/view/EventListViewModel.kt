package org.suwashizmu.connpassapp.module.view

/**
 * Created by KEKE
 */
data class EventListViewModel(var eventList: Collection<Event>) {

    data class Event(val title: String, val catch: String)
}