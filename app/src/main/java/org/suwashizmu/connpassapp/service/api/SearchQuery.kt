package org.suwashizmu.connpassapp.service.api

/**
 * Created by KEKE on 2018/10/03.
 *
 * builderパターン
 * [https://stackoverflow.com/questions/36140791/how-to-implement-builder-pattern-in-kotlin]
 */
class SearchQuery(
        private val eventId: Int?,
        private val keyword: Set<String>?,
        private val keywordOr: Set<String>?,
        private val ym: Set<Int>?,
        private val ymd: Set<Int>?,
        private val nickname: Set<String>?,
        private val ownerNickname: Set<String>?,
        private val seriesId: Set<Int>?,
        private val start: Int,
        val order: Int,
        val count: Int) {
    private constructor(builder: Builder) : this(
            builder.eventId,
            builder.keyword,
            builder.keywordOr,
            builder.ym,
            builder.ymd,
            builder.nickname,
            builder.ownerNickname,
            builder.seriesId,
            builder.start,
            builder.order.value,
            builder.count)

    companion object {
        inline fun build(block: Builder.() -> Unit) = Builder().apply(block).build()
    }

    @Suppress("UNCHECKED_CAST")
    fun toMap(): Map<String, String> {
        val map = mapOf(
                "event_id" to eventId?.toString(),
                "keyword" to keyword?.joinToString(separator = ","),
                "keyword_or" to keywordOr?.joinToString(separator = ","),
                "ym" to ym?.joinToString(separator = ","),
                "ymd" to ymd?.joinToString(separator = ","),
                "nickname" to nickname?.joinToString(separator = ","),
                "owner_nickname" to ownerNickname?.joinToString(separator = ","),
                "series_id" to seriesId?.joinToString(separator = ","),
                "start" to start.toString(),
                "order" to order.toString(),
                "count" to count.toString()
        )

        return map.filterValues { it != null } as Map<String, String>
    }

    class Builder {

        var eventId: Int? = null
        var keyword: Set<String>? = null
        var keywordOr: Set<String>? = null
        var ym: Set<Int>? = null
        var ymd: Set<Int>? = null
        var nickname: Set<String>? = null
        var ownerNickname: Set<String>? = null
        var seriesId: Set<Int>? = null
        var start: Int = 0
        /*
        検索結果の表示順を、更新日時順、開催日時順、新着順で指定します。 | 1: 更新日時順
        2: 開催日時順
        3: 新着順
        (初期値: 1)
         */
        var order: Order = Order.UPDATED
        var count: Int = 30

        fun build() = SearchQuery(this)
    }

    enum class Order(val value: Int) {
        UPDATED(1), EVENT_DATE(2), LATEST(3)
    }
}