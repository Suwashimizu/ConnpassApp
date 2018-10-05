package org.suwashizmu.connpassapp.service.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 * Created by KEKE on 2018/10/03.
 * [about api](https://connpass.com/about/api/)
 * api root https://connpass.com/api/v1/event/
 *
 * pythonを含むイベントを検索
 * https://connpass.com/api/v1/event/?keyword=python
 *
 * event_id | イベントID | 整数 | イベント毎に割り当てられた番号で検索します。複数指定可能です*1 | URLが https://connpass.com/event/364/ のイベントの場合、イベントIDは 364 になります。
keyword | キーワード (AND) | 文字列(UTF-8) | イベントのタイトル、キャッチ、概要、住所をAND条件部分一致で検索します。複数指定可能です*1 |
keyword_or | キーワード (OR) | 文字列(UTF-8) | イベントのタイトル、キャッチ、概要、住所をOR条件部分一致で検索します。複数指定可能です*1 |
ym | イベント開催年月 | 整数 | 指定した年月に開催されているイベントを検索します。複数指定可能です*1 | yyyymm
(例) 201204
ymd | イベント開催年月日 | 整数 | 指定した年月日に開催されているイベントを検索します。複数指定可能です*1 | yyyymmdd
(例) 20120406
nickname | 参加者のニックネーム | 文字列(UTF-8) | 指定したニックネームのユーザが参加しているイベントを検索します。複数指定可能です*1 |
owner_nickname | 管理者のニックネーム | 文字列(UTF-8) | 指定したニックネームのユーザが管理しているイベントを検索します。複数指定可能です*1 |
series_id | グループID | 整数 | グループ 毎に割り当てられた番号で、ひもづいたイベントを検索します。複数指定可能です*1 | URLが https://connpass.com/series/1/ のグループの場合、グループIDは 1 になります。
start | 検索の開始位置 | 整数 | 検索結果の何件目から出力するかを指定します。 | (初期値: 1)
order | 検索結果の表示順 | 整数 | 検索結果の表示順を、更新日時順、開催日時順、新着順で指定します。 | 1: 更新日時順
2: 開催日時順
3: 新着順
(初期値: 1)
count | 取得件数 | 整数 | 検索結果の最大出力データ数を指定します。 | 初期値: 10、最小値：1、最大値：100
format | レスポンス形式 | 文字列(UTF-8) | レスポンスの形式を指定します。 | jsonに固定です。

パラメータを複数指定する場合は、 name=value1&name=value2&... または name=value1,value2... のように指定できます。
 */
interface ConnpassService {
    @GET("event/?")
    fun searchEvents(@QueryMap options: Map<String, String>): Single<SearchResult>
}