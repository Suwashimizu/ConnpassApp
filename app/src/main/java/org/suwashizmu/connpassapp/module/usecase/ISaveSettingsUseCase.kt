package org.suwashizmu.connpassapp.module.usecase

import org.suwashizmu.connpassapp.module.input.SaveSettingsInputData

/**
 * Created by KEKE on 2018/10/21.
 * 検索の設定を保存する
 */
interface ISaveSettingsUseCase {
    fun save(inputData: SaveSettingsInputData)
}