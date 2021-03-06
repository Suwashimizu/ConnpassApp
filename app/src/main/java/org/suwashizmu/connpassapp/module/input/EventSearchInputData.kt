package org.suwashizmu.connpassapp.module.input

import org.suwashizmu.connpassapp.module.entity.Area

/**
 * Created by KEKE on 2018/10/05.
 *
 * 検索時の入力パラメーター
 * DTOとする(DTOは可変である)
 * 異なるレイヤー間でデーターを受け渡す
 * data classならcopyで良い気がする
 */
data class EventSearchInputData(
        var area: Area,
        var keyword: Set<String> = emptySet(),
        val ym: Int = -1,
        val offset: Int,
        val limit: Int)