package org.suwashizmu.connpassapp.module.input

import org.suwashizmu.connpassapp.module.entity.Area
import org.suwashizmu.connpassapp.module.entity.InterestCategory

/**
 * Created by KEKE on 2018/10/21.
 */
data class SaveSettingsInputData(
        val area: Area,
        val interestCategory: Collection<InterestCategory>)