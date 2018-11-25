package org.suwashizmu.connpassapp.module.usecase

/**
 * Created by KEKE on 2018/11/16.
 */
interface IFetchSingleEventUseCase {

    /**
     * @param id 対象のEventId
     */
    fun fetchEvent(id: Int)
}