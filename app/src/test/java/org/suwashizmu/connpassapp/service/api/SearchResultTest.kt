package org.suwashizmu.connpassapp.service.api

import com.squareup.moshi.JsonAdapter
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

/**
 * Created by KEKE on 2018/10/02.
 */
class SearchResultTest {

    private val jsonAdapter: JsonAdapter<SearchResult> = moshi.adapter(SearchResult::class.java)

    @Test
    fun `parse from json`() {

        val json = """{"results_returned": 1, "events": [{"event_url": "https://lets-go-study-meeting.connpass.com/event/103517/", "event_type": "participation", "owner_nickname": "shota_sato_758", "series": {"url": "https://lets-go-study-meeting.connpass.com/", "id": 3688, "title": "\u306f\u3058\u3081\u3066\u306eIT\u52c9\u5f37\u4f1a"}, "updated_at": "2018-10-01T19:51:21+09:00", "lat": "32.800398300000", "started_at": "2018-10-24T19:00:00+09:00", "hash_tag": "hajimete_it", "title": "#7 \u306f\u3058\u3081\u3066\u306eIT\u52c9\u5f37\u4f1a in \u718a\u672c(2018)", "event_id": 103517, "lon": "130.708337600000", "waiting": 0, "limit": 11, "owner_id": 37259, "owner_display_name": "shota_sato_758", "description": "<h1>\u306f\u3058\u3081\u306b</h1>\n<p><strong>\u306f\u3058\u3081\u3066\u306eIT\u52c9\u5f37\u4f1a</strong>\u306f\u3001\n\u3044\u308d\u3044\u308d\u306a\u4e0d\u5b89\u304c\u3042\u3063\u3066\u52c9\u5f37\u4f1a\u3078\u306e\u53c2\u52a0\u3092\u8e8a\u8e87\u3063\u3066\u3044\u308b\u65b9\u304c<br>\n\u6c17\u8efd\u306b\u53c2\u52a0\u3057\u3001\u300c\u4e00\u6b69\u76ee\u300d\u3092\u4f53\u9a13\u3057\u3064\u3064\u3001\u660e\u65e5\u304b\u3089\u5f79\u7acb\u3064\u77e5\u898b\u3092\u7372\u5f97\u3059\u308b\u305f\u3081\u306e\u52c9\u5f37\u4f1a\u3067\u3059\u3002<br>\n<strong>\u53c2\u52a0\u56de\u6570\u306b\u95a2\u308f\u3089\u305a\u3054\u6d3b\u7528\u3044\u305f\u3060\u3051\u308b\u5185\u5bb9\u3092\u63d0\u4f9b\u3057\u307e\u3059</strong></p>\n<ul>\n<li>\n<p>\u52c9\u5f37\u4f1a\u3063\u3066\u306a\u306b\u3059\u308b\u306e\uff1f\u3069\u3093\u306a\u96f0\u56f2\u6c17\u306a\u306e\uff1f  </p>\n</li>\n<li>\n<p>\u52c9\u5f37\u4f1a\u306b\u884c\u3063\u3066\u307f\u305f\u3044\u3051\u3069\u6016\u3044...  </p>\n</li>\n<li>\n<p>\u672c\u5f53\u306b\u306a\u306b\u3082\u308f\u304b\u3089\u306a\u3044\u3001\u77e5\u308a\u5408\u3044\u3082\u3044\u306a\u3044\u3001\u884c\u3063\u3066\u3044\u3044\u304b\u308f\u304b\u3089\u306a\u3044  </p>\n</li>\n<li>\n<p>\u300c\u307f\u3093\u306a\u81ea\u5206\u3088\u308a\u8a73\u3057\u3044\u3093\u3067\u3057\u3087\uff1f\u300d\u3068\u611f\u3058\u308b  </p>\n</li>\n<li>\n<p>\u300c\u307f\u3093\u306a\u4ef2\u826f\u3057\u306a\u3093\u3067\u3057\u3087\uff1f\u300d\u3068\u611f\u3058\u308b   </p>\n</li>\n</ul>\n<p>\u2191\u306e\u3088\u3046\u306a\u4e0d\u5b89\u3092\u611f\u3058\u305f\u3053\u3068\u306e\u3042\u308b\u4eba\u306b\u3082\u3001\u305c\u3072\u4e00\u6b69\u76ee\u3068\u3057\u3066\u3054\u53c2\u52a0\u304f\u3060\u3055\u3044\uff01  </p>\n<h1>\u4eca\u56de\u306e\u30bf\u30a4\u30c8\u30eb</h1>\n<ul>\n<li>\u300c\u306a\u306b\u305d\u308c\uff1f\u826f\u66f8\u306a\u306e\u306b\u3082\u3063\u305f\u3044\u306a\u3044\u3002\u30d7\u30ea\u30f3\u30b7\u30d7\u30eb \u30aa\u30d6 \u30d7\u30ed\u30b0\u30e9\u30df\u30f3\u30b0\u5ea7\u8ac7\u4f1a\uff01\u300d \u4f50\u85e4 \u5c06\u592a</li>\n</ul>\n<h1>\u30b9\u30b1\u30b8\u30e5\u30fc\u30eb</h1>\n<table>\n<thead>\n<tr>\n<th align=\"center\">\u958b\u59cb</th>\n<th align=\"center\">\u7d42\u4e86</th>\n<th align=\"left\">\u8a73\u7d30</th>\n</tr>\n</thead>\n<tbody>\n<tr>\n<td align=\"center\">18:30</td>\n<td align=\"center\">19:00</td>\n<td align=\"left\">\u6e96\u5099\uff06\u958b\u5834</td>\n</tr>\n<tr>\n<td align=\"center\">19:00</td>\n<td align=\"center\">19:05</td>\n<td align=\"left\">\u4e3b\u50ac\u8005\u304b\u3089\u4e00\u8a00</td>\n</tr>\n<tr>\n<td align=\"center\">19:05</td>\n<td align=\"center\">19:20</td>\n<td align=\"left\">LT1 -</td>\n</tr>\n<tr>\n<td align=\"center\">19:20</td>\n<td align=\"center\">19:30</td>\n<td align=\"left\">LT2 -</td>\n</tr>\n<tr>\n<td align=\"center\">19:30</td>\n<td align=\"center\">20:10</td>\n<td align=\"left\">(\u6e96\u5099\u4e2d)</td>\n</tr>\n<tr>\n<td align=\"center\">20:10</td>\n<td align=\"center\">21:00</td>\n<td align=\"left\">\u98f2\u3081\u3070\u98f2\u3080\u307b\u3069\u308f\u304b\u3063\u305f\u6c17\u306b\u306a\u308c\u308b\u30c7\u30b6\u30a4\u30ca\u30fc\u5411\u3051Web\u958b\u767a\u5165\u9580(\u718a\u672c\u4f1a\u5834\u306e\u307f&amp;\u4f01\u753b\u6bb5\u968e)</td>\n</tr>\n</tbody>\n</table>\n<h2>\u5185\u5bb9</h2>\n<h3>\u30d7\u30ea\u30f3\u30b7\u30d7\u30eb\u30aa\u30d6\u30d7\u30ed\u30b0\u30e9\u30df\u30f3\u30b0</h3>\n<p>\u306f\u3058\u3081\u3066\u306eIT\u52c9\u5f37\u4f1a\u3067\u3082\u53d6\u308a\u4e0a\u3052\u3066\u3044\u308b2\u518a\u76ee\u306e\u826f\u66f8\u300c\u30d7\u30ea\u30f3\u30b7\u30d7\u30eb\u30aa\u30d6\u30d7\u30ed\u30b0\u30e9\u30df\u30f3\u30b0\u300d\u3002\u3053\u3061\u3089\u306f\u6bce\u5e74\u5ea67\u6708-9\u6708\u306b\u3001\u5fc5\u305a\u3053\u306e\u66f8\u7c4d\u306e\u5185\u5bb9\u3092\u30d9\u30fc\u30b9\u306b\u3057\u305f\u52c9\u5f37\u4f1a\u3092\u958b\u50ac\u3057\u3066\u3044\u307e\u3059\u3002\u3053\u306e\u672c\u306f\u3001\u8aad\u307f\u7d42\u3048\u305f\u304b\u3089\u3068\u8a00\u3063\u3066\u30b3\u30fc\u30c9\u304c\u66f8\u3051\u308b\u3088\u3046\u306b\u306a\u308b\u672c\u3067\u306f\u3042\u308a\u307e\u305b\u3093\u3002\u3055\u3089\u306b\u7b2c3\u7ae0\u3001\u7b2c4\u7ae0\u3001\u7b2c6\u7ae0\u306f\u3001(\u30bc\u30ed\u304b\u3089\u306f\u3058\u3081\u305f\u4eba\u306f)\u8aad\u307f\u98db\u3070\u3057\u3066\u3082\u554f\u984c\u3042\u308a\u307e\u305b\u3093\u3002</p>\n<p>\u4f55\u5ea6\u8aad\u307f\u76f4\u3057\u3066\u3082\u3001\u305d\u306e\u90fd\u5ea6\u65b0\u305f\u306a\u7406\u89e3\u304c\u751f\u307e\u308c\u3001\u8aad\u307f\u305f\u3044\u672c\u3092\u63a2\u3059\u6307\u91dd\u306b\u306a\u308b\u826f\u66f8\u3067\u3059\u306e\u3067\u3001\u3053\u3061\u3089\u3082\u65e9\u3044\u6bb5\u968e\u3067\u5185\u5bb9\u3092\u78ba\u8a8d\u3044\u305f\u3057\u307e\u3057\u3087\u3046\uff01</p>\n<h1>\u4e3b\u50ac\u30b9\u30bf\u30c3\u30d5\u30d7\u30ed\u30d5\u30a3\u30fc\u30eb</h1>\n<h2>\u4f50\u85e4 \u5c06\u592a\uff08\u3055\u3068\u3046 \u3057\u3087\u3046\u305f\uff09</h2>\n<p>\u4f50\u85e4 \u5c06\u592a\uff08\u3055\u3068\u3046 \u3057\u3087\u3046\u305f\uff09\n\u30a8\u30f3\u30b8\u30cb\u30a2\u3084\u30de\u30cd\u30fc\u30b8\u30e3\u30fc\u3068\u3057\u3066\u306e\u696d\u52d9\u3092\u7d4c\u9a13\u3057\u306a\u304c\u3089\u3001\u30ea\u30fc\u30c0\u30fc\u80b2\u6210\u3001\u65b0\u4eba\u80b2\u6210\u3001\u82e5\u624b\u4e8b\u696d\u5bb6\u652f\u63f4\u3092\u884c\u3046\u306a\u3069\u5f8c\u9032\u306e\u652f\u63f4\u3092\u884c\u3046\u6d3b\u52d5\u3092\u500b\u4eba\u3067\u5c55\u958b\u3059\u308b\u30d1\u30e9\u30ec\u30eb\u30ef\u30fc\u30ab\u30fc10\u5e74\u9078\u624b\u3002  </p>\n<p><strong>OWASP Natori Meeting</strong> \u3084 <strong>CoderDojo Natori</strong> \u306a\u3069\u306e IT \u7cfb\u30a4\u30d9\u30f3\u30c8\u306e\u4e3b\u50ac\u306e\u4ed6\u3001<br>\n<strong>\u4ed9\u53f0\u30de\u30a4\u30f3\u30c9\u30de\u30c3\u30d7\u666e\u53ca\u4f1a</strong> \u306a\u3069\u3001\u5275\u9020\u6027\u3068\u8ad6\u7406\u6027\u3092\u9ad8\u3081\u308b\u30c4\u30fc\u30eb\u306e\u516c\u8a8d\u30a4\u30f3\u30b9\u30c8\u30e9\u30af\u30bf\u30fc\u30fb\u30a8\u30f4\u30a1\u30f3\u30b8\u30a7\u30ea\u30b9\u30c8\u3068\u3057\u3066\u666e\u53ca\u6d3b\u52d5\u3082\u5c55\u958b\u3002<br>\n\u30d7\u30ed\u30b0\u30e9\u30de\u30fc\u306f\u8ad6\u7406\u7684\u306a\u4ed5\u4e8b\u3067\u3042\u308a\u306a\u304c\u3089\u3001\u6700\u3082\u5275\u9020\u7684\u306a\u4ed5\u4e8b\u306e\u4e00\u3064\u3060\u3068\u8003\u3048\u3066\u3044\u308b\u3002</p>\n<h2>\u6cb3\u91ce \u5eb7\u9686\uff08\u3053\u3046\u306e \u3084\u3059\u305f\u304b\uff09</h2>\n<p>\u682a\u5f0f\u4f1a\u793edott \u6240\u5c5e\u306e\u30d7\u30ed\u30b0\u30e9\u30de\u30fc\u3002\u6700\u8fd1\u4ed9\u53f0\u304b\u3089\u90e1\u5c71\u306b\u79fb\u4f4f\u3057\u305f\u3002<br>\nJava\u3092\u30e1\u30a4\u30f3\u306bPython\u3084Kotlin\u3067\u306e\u30d0\u30c3\u30af\u30a8\u30f3\u30c9\u306e\u69cb\u7bc9\u3092\u4e3b\u306a\u8077\u52d9\u3068\u3057\u3066\u3044\u308b\u3002<br>\n\u30d7\u30ed\u30b0\u30e9\u30de\u30fc\u306b\u5fc5\u8981\u306a\u5fc3\u6280\u306e\u7372\u5f97\u652f\u63f4\u306e\u305f\u3081\u5927\u5b66\u306e\u6559\u58c7\u306b\u3082\u7acb\u306432\u6b73\u3002  </p>\n<p>\u4ed9\u53f0\u3067\u3082\u7a4d\u6975\u7684\u306b\u30b3\u30df\u30e5\u30cb\u30c6\u30a3\u6d3b\u52d5\u3092\u884c\u3063\u3066\u304a\u308a\u3001<br>\n\u904e\u53bb\u306b\u306f<strong>\u30ea\u30fc\u30c0\u30d6\u30eb\u30b3\u30fc\u30c9\u52c9\u5f37\u4f1a\u306e\u958b\u50ac</strong>\u3084\u3001\u73fe\u5728\u3067\u3082<strong>GCPUG In Sendai</strong>\u3092\u4e3b\u50ac\u3057\u3066\u3044\u308b\u3002 <br>\n\u3061\u306a\u307f\u306b\u3001GCP\u8a8d\u5b9a\u8cc7\u683c\u4fdd\u6301\u8005\u3067\u3042\u308b\u3002  </p>\n<h2>\u53ef\u91ce \u6c99\u7e54\uff08\u304b\u306e \u3055\u304a\u308a\uff09</h2>\n<p><a href=\"https://www.enspace.work/\" rel=\"nofollow\">enspace</a> Community Manager\u3002<br>\n\u306f\u3058\u3081\u3066\u306eIT\u52c9\u5f37\u4f1a\u306e\u4e3b\u8ef8\u30e1\u30f3\u30d0\u30fc\u3067  \u3001\u7279\u306b<strong>\u82e5\u624b\u652f\u63f4\u3068CS\uff08=\u30ab\u30b9\u30bf\u30de\u30fc\u30b5\u30dd\u30fc\u30c8\uff09\u3078\u306e\u60c5\u71b1</strong>\u304c\u7fa4\u3092\u629c\u3044\u3066\u3044\u308b\u30a2\u30af\u30c6\u30a3\u30d6\u30d7\u30ec\u30a4\u30e4\u30fc\u3002  </p>\n<p>\u60f3\u3044\u3092\u5f62\u306b\u3059\u308b\u3079\u304f\u3001\u5730\u5143\u5bae\u57ce\u306b\u7e4b\u304c\u308b\u6d77\u5916\u304b\u3089\u306e\u9053\u3092\u4f5c\u308d\u3046\u3068\u65e5\u672c\u8a9e\u3060\u3051\u3067\u3044\u3064\u304b\u6d77\u5916\u306b\u6311\u6226\u3057\u3088\u3046\u3068\u4f01\u3093\u3067\u3044\u308b\u6a21\u69d8\u3002<br>\n\u3061\u306a\u307f\u306b\u3001<strong>\u30d0\u30c3\u30af\u30aa\u30d5\u30a3\u30b9\u30b5\u30dd\u30fc\u30c8\u306b\u4fc2\u308b\u696d\u52d9\u306e\u4fe1\u983c\u611f\u304c\u5727\u5012\u7684</strong>\u3067\u3042\u308b\u3002</p>\n<h1>\u5f53\u65e5\u306e\u304a\u9858\u3044</h1>\n<ul>\n<li>\u30a4\u30d9\u30f3\u30c8\u306e\u53d7\u4ed8\u306e\u305f\u3081\u300c\u540d\u523a\u30922\u679a\u300d\u306e\u3054\u6e96\u5099\u3092\u304a\u9858\u3044\u3044\u305f\u3057\u307e\u3059\uff01</li>\n<li>\u5f53\u65e5\u306e\u52c9\u5f37\u4f1a\u98a8\u666f\u306b\u95a2\u3057\u307e\u3057\u3066\u3001\u4eca\u5f8c\u306e\u6d3b\u52d5\u5e83\u5831\u306e\u305f\u3081\u306b\u64ae\u5f71\u304c\u884c\u308f\u308c\u308b\u3053\u3068\u304c\u3054\u3056\u3044\u307e\u3059\u306e\u3067\u3054\u7406\u89e3\u306e\u7a0b\u3001\u3088\u308d\u3057\u304f\u304a\u9858\u3044\u3044\u305f\u3057\u307e\u3059\u3002</li>\n</ul>\n<h1>in\u718a\u672c\u304b\u3089\u306e\u304a\u9858\u3044</h1>\n<ul>\n<li>\u30e1\u30a4\u30f3\u4f1a\u5834\u306f\u4ed9\u53f0\u3067\u884c\u308f\u308c\u3066\u304a\u308a\u3001\u718a\u672c\u306f\u30ea\u30e2\u30fc\u30c8\u3067\u306e\u53c2\u52a0\u3068\u306a\u308a\u307e\u3059\u3002</li>\n<li>\u53c2\u52a0\u8cbb\u306f\u7121\u6599\u3067\u3059\u304c\u30011 drink order\u306b\u5fa1\u5354\u529b\u3092\u304a\u9858\u3044\u3044\u305f\u3057\u307e\u3059\u3002<br>\n\u30001\u676f\u306e\u307f\u306e\u5834\u5408\u3001300\u5186\u306e\u30c1\u30e3\u30fc\u30b8\u6599\u304c\u767a\u751f\u3057\u307e\u3059\u3002<br>\n\u30002\u676f\u76ee\u4ee5\u964d\u306e\u5834\u5408\u306b\u306f\u30c1\u30e3\u30fc\u30b8\u306f\u7121\u6599\u306b\u306a\u308a\u307e\u3059\u3002<br>\n\u30001drink\u57fa\u672c500\u5186\u3067\u3059\u3002</li>\n</ul>\n<h1>\u5354\u529b\u30b3\u30df\u30e5\u30cb\u30c6\u30a3(\u6771\u5317\u3067\u6d3b\u52d5\u3057\u3066\u3044\u308b\u30b3\u30df\u30e5\u30cb\u30c6\u30a3\uff01\u3082\u3063\u3068\u3042\u308b\u3088\uff01)</h1>\n<p><a href=\"http://efsta.com\" rel=\"nofollow\"><img src=\"http://hajimete-it.com/wp-content/uploads/2018/01/efsta_logo.png\" style=\"margin: 30px;\" width=\"20%\"></a>\n<a href=\"https://suku3rum-sendai.connpass.com\" rel=\"nofollow\"><img src=\"http://hajimete-it.com/wp-content/uploads/2018/01/sukusuku_logo.png\" style=\"margin: 20px;\" width=\"30%\"></a>\n<a href=\"https://devlove-sendai.doorkeeper.jp\" rel=\"nofollow\"><img src=\"http://hajimete-it.com/wp-content/uploads/2018/01/DevLove_Sendai.png\" style=\"margin: 10px;\"></a></p>\n<hr>\n<p><a href=\"http://devtesting.jp/tddbc/\" rel=\"nofollow\"><img src=\"http://hajimete-it.com/wp-content/uploads/2018/01/TDDBC-logo.png\" style=\"margin: 0px 20px;\" width=\"25%\"></a>\n<a href=\"https://www.facebook.com/tohoku.bannin/\" rel=\"nofollow\"><img src=\"http://hajimete-it.com/wp-content/uploads/2018/01/logo-bannin.png\" style=\"margin: 30px;\" width=\"25%\"></a>\n<a href=\"http://tohoku-security.techtalk.jp/\" rel=\"nofollow\"><img src=\"http://hajimete-it.com/wp-content/uploads/2018/01/customLogo-300x190.png\" style=\"margin: 30px;\" width=\"25%\"></a></p>\n<hr>\n<p><a href=\"https://knowledge-bbq.connpass.com\" rel=\"nofollow\"><img src=\"http://hajimete-it.com/wp-content/uploads/2018/01/KnowledgeBBQ_logo.png\" style=\"margin: 30px;\"></a>\n<a href=\"http://tohoku-dev.jp\" rel=\"nofollow\"><img src=\"http://hajimete-it.com/wp-content/uploads/2018/01/tdc-logo-1.png\" style=\"margin: 0px;\"></a>\n<a href=\"https://www.facebook.com/CodesSendai/\" rel=\"nofollow\"><img src=\"http://hajimete-it.com/wp-content/uploads/2018/03/Codes_logo.jpg\" style=\"margin: 0px 25px; margin-bottom: 50px;\" width=\"25%\"></a></p>\n<hr>\n<h1>\u5354\u529b\u30b3\u30df\u30e5\u30cb\u30c6\u30a3(\u718a\u672c\u7248)</h1>\n<p>\u6e96\u5099\u4e2d\u3067\u3059</p>", "address": "\u718a\u672c\u770c\u718a\u672c\u5e02\u4e0b\u901a\u308a\uff11\u4e01\u76ee\uff11\uff10\uff0d\uff11\uff10(\u9280\u5ea7\u30d7\u30e9\u30b6\u30d3\u30eb\uff18F)", "catch": "\u306a\u306b\u305d\u308c\uff1f\u826f\u66f8\u306a\u306e\u306b\u3082\u3063\u305f\u3044\u306a\u3044\u3002\u30d7\u30ea\u30f3\u30b7\u30d7\u30eb \u30aa\u30d6 \u30d7\u30ed\u30b0\u30e9\u30df\u30f3\u30b0\u52c9\u5f37\u4f1a\uff01", "accepted": 0, "ended_at": "2018-10-24T21:00:00+09:00", "place": "Bar \u30e9\u30f3\u30d0\u30ea\u30aa\u30f3"}], "results_start": 1, "results_available": 450}"""
        val searchResult: SearchResult = jsonAdapter.fromJson(json)!!

        assertThat(searchResult.resultsReturned).isEqualTo(1)
        assertThat(searchResult.events.count()).isEqualTo(1)

        val event = searchResult.events.first()

        assertThat(event.eventUrl).isEqualTo("https://lets-go-study-meeting.connpass.com/event/103517/")
        assertThat(event.ownerNickname).isEqualTo("shota_sato_758")
        assertThat(event.updatedAt).isEqualTo("2018-10-01T19:51:21+09:00")
        assertThat(event.title).isEqualTo("#7 はじめてのIT勉強会 in 熊本(2018)")
        assertThat(event.twitterHashTag).isEqualTo("hajimete_it")
        assertThat(event.eventId).isEqualTo(103517)

        /*
        Event(eventUrl=https://lets-go-study-meeting.connpass.com/event/103517/, ownerNickname=shota_sato_758, updatedAt=2018-10-01T19:51:21+09:00, startedAt=2018-10-24T19:00:00+09:00, hashTag=hajimete_it, title=#7 はじめてのIT勉強会 in 熊本(2018), eventId=103517, description=<h1>はじめに</h1>
<p><strong>はじめてのIT勉強会</strong>は、
いろいろな不安があって勉強会への参加を躊躇っている方が<br>
気軽に参加し、「一歩目」を体験しつつ、明日から役立つ知見を獲得するための勉強会です。<br>
<strong>参加回数に関わらずご活用いただける内容を提供します</strong></p>
<ul>
<li>
<p>勉強会ってなにするの？どんな雰囲気なの？  </p>
</li>
<li>
<p>勉強会に行ってみたいけど怖い...  </p>
</li>
<li>
<p>本当になにもわからない、知り合いもいない、行っていいかわからない  </p>
</li>
<li>
<p>「みんな自分より詳しいんでしょ？」と感じる  </p>
</li>
<li>
<p>「みんな仲良しなんでしょ？」と感じる   </p>
</li>
</ul>
<p>↑のような不安を感じたことのある人にも、ぜひ一歩目としてご参加ください！  </p>
<h1>今回のタイトル</h1>
<ul>
<li>「なにそれ？良書なのにもったいない。プリンシプル オブ プログラミング座談会！」 佐藤 将太</li>
</ul>
<h1>スケジュール</h1>
<table>
<thead>
<tr>
<th align="center">開始</th>
<th align="center">終了</th>
<th align="left">詳細</th>
</tr>
</thead>
<tbody>
<tr>
<td align="center">18:30</td>
<td align="center">19:00</td>
<td align="left">準備＆開場</td>
</tr>
<tr>
<td align="center">19:00</td>
<td align="center">19:05</td>
<td align="left">主催者から一言</td>
</tr>
<tr>
<td align="center">19:05</td>
<td align="center">19:20</td>
<td align="left">LT1 -</td>
</tr>
<tr>
<td align="center">19:20</td>
<td align="center">19:30</td>
<td align="left">LT2 -</td>
</tr>
<tr>
<td align="center">19:30</td>
<td align="center">20:10</td>
<td align="left">(準備中)</td>
</tr>
<tr>
<td align="center">20:10</td>
<td align="center">21:00</td>
<td align="left">飲めば飲むほどわかった気になれるデザイナー向けWeb開発入門(熊本会場のみ&amp;企画段階)</td>
</tr>
</tbody>
</table>
<h2>内容</h2>
<h3>プリンシプルオブプログラミング</h3>
<p>はじめてのIT勉強会でも取り上げている2冊目の良書「プリンシプルオブプログラミング」。こちらは毎年度7月-9月に、必ずこの書籍の内容をベースにした勉強会を開催しています。この本は、読み終えたからと言ってコードが書けるようになる本ではありません。さらに第3章、第4章、第6章は、(ゼロからはじめた人は)読み飛ばしても問題ありません。</p>
<p>何度読み直しても、その都度新たな理解が生まれ、読みたい本を探す指針になる良書ですので、こちらも早い段階で内容を確認いたしましょう！</p>
<h1>主催スタッフプロフィール</h1>
<h2>佐藤 将太（さとう しょうた）</h2>
<p>佐藤 将太（さとう しょうた）
エンジニアやマネージャーとしての業務を経験しながら、リーダー育成、新人育成、若手事業家支援を行うなど後進の支援を行う活動を個人で展開するパラレルワーカー10年選手。  </p>
<p><strong>OWASP Natori Meeting</strong> や <strong>CoderDojo Natori</strong> などの IT 系イベントの主催の他、<br>
<strong>仙台マインドマップ普及会</strong> など、創造性と論理性を高めるツールの公認インストラクター・エヴァンジェリストとして普及活動も展開。<br>
プログラマーは論理的な仕事でありながら、最も創造的な仕事の一つだと考えている。</p>
<h2>河野 康隆（こうの やすたか）</h2>
<p>株式会社dott 所属のプログラマー。最近仙台から郡山に移住した。<br>
JavaをメインにPythonやKotlinでのバックエンドの構築を主な職務としている。<br>
プログラマーに必要な心技の獲得支援のため大学の教壇にも立つ32歳。  </p>
<p>仙台でも積極的にコミュニティ活動を行っており、<br>
過去には<strong>リーダブルコード勉強会の開催</strong>や、現在でも<strong>GCPUG In Sendai</strong>を主催している。 <br>
ちなみに、GCP認定資格保持者である。  </p>
<h2>可野 沙織（かの さおり）</h2>
<p><a href="https://www.enspace.work/" rel="nofollow">enspace</a> Community Manager。<br>
はじめてのIT勉強会の主軸メンバーで  、特に<strong>若手支援とCS（=カスタマーサポート）への情熱</strong>が群を抜いているアクティブプレイヤー。  </p>
<p>想いを形にするべく、地元宮城に繋がる海外からの道を作ろうと日本語だけでいつか海外に挑戦しようと企んでいる模様。<br>
ちなみに、<strong>バックオフィスサポートに係る業務の信頼感が圧倒的</strong>である。</p>
<h1>当日のお願い</h1>
<ul>
<li>イベントの受付のため「名刺を2枚」のご準備をお願いいたします！</li>
<li>当日の勉強会風景に関しまして、今後の活動広報のために撮影が行われることがございますのでご理解の程、よろしくお願いいたします。</li>
</ul>
<h1>in熊本からのお願い</h1>
<ul>
<li>メイン会場は仙台で行われており、熊本はリモートでの参加となります。</li>
<li>参加費は無料ですが、1 drink orderに御協力をお願いいたします。<br>
　1杯のみの場合、300円のチャージ料が発生します。<br>
　2杯目以降の場合にはチャージは無料になります。<br>
　1drink基本500円です。</li>
</ul>
<h1>協力コミュニティ(東北で活動しているコミュニティ！もっとあるよ！)</h1>
<p><a href="http://efsta.com" rel="nofollow"><img src="http://hajimete-it.com/wp-content/uploads/2018/01/efsta_logo.png" style="margin: 30px;" width="20%"></a>
<a href="https://suku3rum-sendai.connpass.com" rel="nofollow"><img src="http://hajimete-it.com/wp-content/uploads/2018/01/sukusuku_logo.png" style="margin: 20px;" width="30%"></a>
<a href="https://devlove-sendai.doorkeeper.jp" rel="nofollow"><img src="http://hajimete-it.com/wp-content/uploads/2018/01/DevLove_Sendai.png" style="margin: 10px;"></a></p>
<hr>
<p><a href="http://devtesting.jp/tddbc/" rel="nofollow"><img src="http://hajimete-it.com/wp-content/uploads/2018/01/TDDBC-logo.png" style="margin: 0px 20px;" width="25%"></a>
<a href="https://www.facebook.com/tohoku.bannin/" rel="nofollow"><img src="http://hajimete-it.com/wp-content/uploads/2018/01/logo-bannin.png" style="margin: 30px;" width="25%"></a>
<a href="http://tohoku-security.techtalk.jp/" rel="nofollow"><img src="http://hajimete-it.com/wp-content/uploads/2018/01/customLogo-300x190.png" style="margin: 30px;" width="25%"></a></p>
<hr>
<p><a href="https://knowledge-bbq.connpass.com" rel="nofollow"><img src="http://hajimete-it.com/wp-content/uploads/2018/01/KnowledgeBBQ_logo.png" style="margin: 30px;"></a>
<a href="http://tohoku-dev.jp" rel="nofollow"><img src="http://hajimete-it.com/wp-content/uploads/2018/01/tdc-logo-1.png" style="margin: 0px;"></a>
<a href="https://www.facebook.com/CodesSendai/" rel="nofollow"><img src="http://hajimete-it.com/wp-content/uploads/2018/03/Codes_logo.jpg" style="margin: 0px 25px; margin-bottom: 50px;" width="25%"></a></p>
<hr>
<h1>協力コミュニティ(熊本版)</h1>
<p>準備中です</p>)
         */

    }
}