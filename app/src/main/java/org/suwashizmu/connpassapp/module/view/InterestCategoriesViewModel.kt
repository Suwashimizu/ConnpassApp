package org.suwashizmu.connpassapp.module.view

import org.suwashizmu.connpassapp.module.entity.InterestCategory

/**
 * Created by KEKE on 2018/10/08.
 */
class InterestCategoriesViewModel(
        val interestCategories: Collection<InterestCategory> = emptyList(),
        val selectCategories: Collection<InterestCategory>? = null) {

    override fun toString(): String = "List:${interestCategories.size},Selected:${selectCategories?.joinToString(",")}"
}