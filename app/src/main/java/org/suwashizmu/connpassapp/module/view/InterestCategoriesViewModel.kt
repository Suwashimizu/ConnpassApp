package org.suwashizmu.connpassapp.module.view

import org.suwashizmu.connpassapp.module.entity.InterestCategory

/**
 * Created by KEKE on 2018/10/08.
 */
data class InterestCategoriesViewModel(
        var interestCategories: Collection<InterestCategory> = emptyList(),
        var selectCategories: Collection<InterestCategory>? = null,
        var inputState: InputState = InputState.WAIT) {
    
    enum class InputState {
        WAIT, ERROR, COMPLETE
    }
}