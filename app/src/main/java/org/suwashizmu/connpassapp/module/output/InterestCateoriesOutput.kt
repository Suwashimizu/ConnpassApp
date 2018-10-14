package org.suwashizmu.connpassapp.module.output

import org.suwashizmu.connpassapp.module.entity.InterestCategory

/**
 * Created by KEKE on 2018/10/08.
 */
data class InterestCateoriesOutput(
        val selectedCategories: Collection<InterestCategory>,
        val isComplete: Boolean)