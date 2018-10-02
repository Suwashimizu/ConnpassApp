package org.suwashizmu.connpassapp.service.api

import com.squareup.moshi.Json

/**
 * Created by KEKE on 2018/10/02.
 */
data class SearchResult(
        @Json(name = "results_returned") val resultsReturned: Int,
        @Json(name = "events") val events: Collection<Event>,
        @Json(name = "results_start") val resultsStart: Int,
        @Json(name = "results_available") val resultsAvailable: Int)

data class Event(
        @Json(name = "event_url") val eventUrl: String,
        @Json(name = "owner_nickname") val ownerNickname: String,
        @Json(name = "updated_at") val updatedAt: String,
        @Json(name = "started_at") val startedAt: String,
        @Json(name = "hash_tag") val hashTag: String,
        @Json(name = "title") val title: String,
        @Json(name = "event_id") val eventId: Int,
        @Json(name = "description") val description: String)