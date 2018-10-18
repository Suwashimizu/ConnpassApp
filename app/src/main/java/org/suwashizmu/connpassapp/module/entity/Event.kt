package org.suwashizmu.connpassapp.module.entity

import org.threeten.bp.ZonedDateTime


/**
 * Created by KEKE on 2018/10/02.
 *
 * @param description html,概要は自由入力なのでここから取得する,xmlパースした方が良さそう。自由入力なので無理なのでは？
 * @param eventUtl ブラウザで開ける
 * @param twitterHashTag #はアプリで付与する
 * @param place 都道府県と市区町村
 * @param address それ以下の住所
 *
 * 主催とイメージが含まれていない？
 *
 */
data class Event(
        val id: Int,
        val title: String,
        val catch: String,
        val ownerName: String,
        val description: String,
        val eventUtl: String,
        val twitterHashTag: String,
        val startedAt: ZonedDateTime,
        val endedAt: ZonedDateTime,
        val limit: Int,
        val place: String,
        val address: String,
        val accepted: Int,
        val waiting: Int)