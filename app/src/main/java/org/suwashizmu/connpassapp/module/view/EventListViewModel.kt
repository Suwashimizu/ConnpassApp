package org.suwashizmu.connpassapp.module.view

/**
 * Created by KEKE
 * @param eventList 取得した全てのイベントを保持する
 */
data class EventListViewModel(var eventList: MutableList<Event>,
                              var hasNextEvents: Boolean) {

    data class Event(val title: String, val catch: String)
}