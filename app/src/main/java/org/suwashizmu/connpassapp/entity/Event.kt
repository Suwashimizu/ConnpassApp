package org.suwashizmu.connpassapp.entity

import java.util.*

/**
 * Created by KEKE on 2018/10/02.
 */
data class Event(
        val id: Int,
        val title: String,
        val catch: String,
        val description: String,
        val eventUtl: String,
        val twitterHashTag: String,
        val startedAt: Date,
        val endedAt: Date,
        val limit: Int,
        //seriesは別Obj
        val address: String,
        val place: String,
        val accepted: Int,
        val waiting: Int)