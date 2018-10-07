package org.suwashizmu.connpassapp.module.view

import org.suwashizmu.connpassapp.module.entity.Area

/**
 * Created by KEKE on 2018/10/06.
 */
class AreaSelectViewModel(
        var areaList: Collection<Area> = emptyList(),
        var selectedArea: Area? = null) {

    override fun toString(): String = "AreaListSize:${areaList.size},SelectedArea:$selectedArea"
}