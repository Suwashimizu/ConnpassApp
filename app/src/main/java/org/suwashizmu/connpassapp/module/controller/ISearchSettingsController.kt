package org.suwashizmu.connpassapp.module.controller

import org.suwashizmu.connpassapp.module.entity.Area
import org.suwashizmu.connpassapp.module.entity.InterestCategory

/**
 * Created by KEKE
 * アクションを定義する
 */
interface ISearchSettingsController {

    fun onNavigationButtonClick()

    fun loadSettings()

    fun saveSettings(area: Area, vararg interestCategories: InterestCategory)
}