package org.suwashizmu.connpassapp.input

/**
 * Created by KEKE on 2018/10/05.
 *
 * 検索時の入力パラメーター
 * DTOとする(DTOは可変である)
 * 異なるレイヤー間でデーターを受け渡す
 * data classならcopyで良い気がする
 */
data class EventSearchInputData(
        var keyword: String = "",
        val ym: Int = -1)