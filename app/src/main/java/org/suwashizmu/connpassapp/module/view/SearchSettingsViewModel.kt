package org.suwashizmu.connpassapp.module.view

import org.suwashizmu.connpassapp.module.entity.Area
import org.suwashizmu.connpassapp.module.entity.InterestCategory

/**
 * Created by KEKE
 */
data class SearchSettingsViewModel(var area: Area? = null,
                                   var interestCategories: Collection<InterestCategory> = emptyList(),
                                   var areaSource: Collection<Area>? = null,
                                   var interestCategoriesSource: Collection<InterestCategory>? = null,
                                   var isShowInterestChoiceDialog: Boolean = false,
                                   var error: Throwable? = null)