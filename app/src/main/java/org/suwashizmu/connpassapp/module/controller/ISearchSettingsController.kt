package org.suwashizmu.connpassapp.module.controller

import org.suwashizmu.connpassapp.module.entity.Area
import org.suwashizmu.connpassapp.module.entity.InterestCategory

/**
 * Created by KEKE
 * アクションを定義する
 */
interface ISearchSettingsController {

    //画面を閉じる
    fun onNavigationButtonClick()

    //興味をクリック
    fun onInterestItemClick()

    //興味を選択
    fun onInterestSelected(interestCategories: Collection<InterestCategory>)

    //地域を選択
    fun onAreaSelected(area: Area)

    //設定の読み込み
    fun loadSettings()

    //設定の変更を保存
    fun saveSettings(area: Area, vararg interestCategories: InterestCategory)
}