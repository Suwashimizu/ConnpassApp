package org.suwashizmu.connpassapp.service.api

import com.squareup.moshi.Json

/**
 * Created by KEKE on 2018/10/02.
 */
data class SearchResult(
        @Json(name = "results_returned")
        val resultsReturned: Int,
        @Json(name = "events")
        val events: Collection<Event>,
        @Json(name = "results_start")
        val resultsStart: Int,
        @Json(name = "results_available")
        val resultsAvailable: Int)

data class Event(
        @Json(name = "event_url")
        val eventUrl: String,

        @Json(name = "owner_nickname")
        val ownerNickname: String,

        @Json(name = "updated_at")
        val updatedAt: String,

        @Json(name = "started_at")
        val startedAt: String,

        @Json(name = "hash_tag")
        val twitterHashTag: String,

        val title: String,

        @Json(name = "event_id")
        val eventId: Int,
        val address: String?,
        val limit: Int?,
        val accepted: Int,
        val catch: String,
        val place: String?,
        val waiting: Int,
        @Json(name = "ended_at")
        val endedAt: String,

        @Json(name = "description")
        val description: String)