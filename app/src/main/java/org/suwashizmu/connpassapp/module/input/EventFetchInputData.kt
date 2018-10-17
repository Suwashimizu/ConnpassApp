package org.suwashizmu.connpassapp.module.input

/**
 * Created by KEKE on 2018/10/17.
 *
 * @param offset 指定するページから取得
 * @param limit 一度に取得するページ数
 */
data class EventFetchInputData(var offset: Int, var limit: Int = 30)