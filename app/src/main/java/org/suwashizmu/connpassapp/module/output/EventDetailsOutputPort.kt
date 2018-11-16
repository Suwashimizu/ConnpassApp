package org.suwashizmu.connpassapp.module.output

/**
 * Created by KEKE on 2018/11/16.
 */
interface EventDetailsOutputPort {
    fun complete(
            outputData: EventDetailsOutputData?,
            error: Throwable?
    )
}