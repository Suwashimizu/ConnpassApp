package org.suwashizmu.connpassapp.module.input

/**
 * Created by KEKE on 2018/10/05.
 *
 * 検索時の入力パラメーター
 * DTOとする(DTOは可変である)
 * 異なるレイヤー間でデーターを受け渡す
 * data classならcopyで良い気がする
 */
data class EventSearchInputData(
        var keyword: Set<String> = emptySet(),
        val ym: Int = -1)