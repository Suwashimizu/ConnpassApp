package org.suwashizmu.connpassapp.module.repository

import org.suwashizmu.connpassapp.module.entity.Area

/**
 * Created by KEKE on 2018/10/06.
 */
interface AreaRepository {
    fun getAreaList(): Collection<Area>
    fun save(area: Area)
}