package org.suwashizmu.connpassapp.module.output

/**
 * Created by KEKE on 2018/10/05.
 * 検索結果の出力用データ
 */
data class EventSearchOutputData(
        val eventList: Collection<OutputEvent>,
        val error: Throwable?) {

    fun hasNext() = eventList.isNotEmpty()

    data class OutputEvent(val title: String,
                           val catch: String,
                           val description: String)
}