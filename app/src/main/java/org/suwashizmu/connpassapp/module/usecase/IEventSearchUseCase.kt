package org.suwashizmu.connpassapp.module.usecase

import org.suwashizmu.connpassapp.module.input.EventSearchInputData

/**
 * Created by KEKE on 2018/10/05.
 *
 * inputとoutputが対となる
 * 結果がboolの場合はoutputはなくてもよい
 */
interface IEventSearchUseCase {

    /**
     * @param inputData サーチのキーワードなどの情報
     */
    fun search(inputData: EventSearchInputData)
}