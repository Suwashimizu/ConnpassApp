package org.suwashizmu.connpassapp.module.view

/**
 * Created by KEKE
 * @param eventList 取得した全てのイベントを保持する
 * @param refreshing true is 再取得中
 */
data class EventListViewModel(var eventList: MutableList<Event>,
                              var hasNextEvents: Boolean,
                              var refreshing: Boolean) {

    data class Event(val title: String, val catch: String)
}