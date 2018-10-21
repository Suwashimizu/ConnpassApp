package org.suwashizmu.connpassapp.module.output

import org.suwashizmu.connpassapp.module.entity.Area
import org.suwashizmu.connpassapp.module.entity.InterestCategory

/**
 * Created by KEKE on 2018/10/18.
 */
interface SettingsOutputPort {
    fun complete(area: Area?, interestCategories: Collection<InterestCategory>?)
}