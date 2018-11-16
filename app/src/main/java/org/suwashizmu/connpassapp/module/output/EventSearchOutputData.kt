package org.suwashizmu.connpassapp.module.output

/**
 * Created by KEKE on 2018/10/05.
 * 検索結果の出力用データ
 *
 * @param totalEventCount 全てのイベント数
 */
data class EventSearchOutputData(
        val eventList: Collection<OutputEvent>,
        val error: Throwable?,
        val totalEventCount: Int) {

    data class OutputEvent(val id: Int,
                           val title: String,
                           val catch: String,
                           val description: String)
}