package org.suwashizmu.connpassapp.service.api

/**
 * Created by KEKE on 2018/10/03.
 *
 * builderパターン
 * [https://stackoverflow.com/questions/36140791/how-to-implement-builder-pattern-in-kotlin]
 */
class SearchQuery(
        private val eventId: Int?,
        private val keyword: String?,
        private val keywordOr: String?,
        private val ym: Int?,
        private val ymd: Int?,
        private val nickname: String?,
        private val ownerNickname: String?,
        private val seriesId: Int?,
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
                "keyword" to keyword,
                "keyword_or" to keywordOr,
                "ym" to ym?.toString(),
                "ymd" to ymd?.toString(),
                "nickname" to nickname,
                "owner_nickname" to ownerNickname,
                "series_id" to seriesId?.toString(),
                "start" to start.toString(),
                "order" to order.toString(),
                "count" to count.toString()
        )

        return map.filterValues { it != null } as Map<String, String>
    }

    class Builder {

        var eventId: Int? = null
        var keyword: String? = null
        var keywordOr: String? = null
        var ym: Int? = null
        var ymd: Int? = null
        var nickname: String? = null
        var ownerNickname: String? = null
        var seriesId: Int? = null
        var start: Int = 1
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