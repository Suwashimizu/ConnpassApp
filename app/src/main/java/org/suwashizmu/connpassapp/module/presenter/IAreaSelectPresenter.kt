package org.suwashizmu.connpassapp.module.presenter

import org.suwashizmu.connpassapp.module.entity.Area

/**
 * Created by KEKE on 2018/10/06.
 */
interface IAreaSelectPresenter {

    fun completeAreaList(list: Collection<Area>)

    fun completeSelected(area: Area)
}