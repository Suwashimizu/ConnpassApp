package org.suwashizmu.connpassapp.module.view

import org.suwashizmu.connpassapp.module.entity.InterestCategory

/**
 * Created by KEKE on 2018/10/08.
 */
class InterestCategoriesViewModel(
        var interestCategories: Collection<InterestCategory> = emptyList(),
        var selectCategories: Collection<InterestCategory>? = null) {

    override fun toString(): String = "List:${interestCategories.size},Selected:${selectCategories?.joinToString(",")}"
}