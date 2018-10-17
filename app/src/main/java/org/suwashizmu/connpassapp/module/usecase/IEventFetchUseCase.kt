package org.suwashizmu.connpassapp.module.usecase

import org.suwashizmu.connpassapp.module.input.EventFetchInputData

/**
 * Created by KEKE on 2018/10/14.
 *
 * イベントを取得する
 */
interface IEventFetchUseCase {
    fun fetchEvent(inputData: EventFetchInputData)
}