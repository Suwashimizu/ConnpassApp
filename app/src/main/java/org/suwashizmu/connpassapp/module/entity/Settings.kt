package org.suwashizmu.connpassapp.module.entity

/**
 * Created by KEKE on 2018/10/18.
 * アプリで保存する設定
 *
 * @param keyword フリーワード,","で区切ること
 */
data class Settings(
        val area: Area,
        val interestCategory: Collection<InterestCategory>,
        val keyword: String)