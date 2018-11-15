package org.suwashizmu.connpassapp.module.output

import org.suwashizmu.connpassapp.module.entity.Area
import org.suwashizmu.connpassapp.module.entity.InterestCategory

/**
 * Created by KEKE on 2018/10/18.
 */
interface SettingsOutputPort {
    fun complete(currentArea: Area?, currentInterestCategories: Collection<InterestCategory>?,
                 areaSource: Collection<Area>,
                 interestCategoriesSource: Collection<InterestCategory>)
}