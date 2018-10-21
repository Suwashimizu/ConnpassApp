package org.suwashizmu.connpassapp.module.view

import org.suwashizmu.connpassapp.module.entity.Area
import org.suwashizmu.connpassapp.module.entity.InterestCategory

/**
 * Created by KEKE
 */
data class SearchSettingsViewModel(var area: Area? = null,
                                   var interestCategories: Collection<InterestCategory> = emptyList(),
                                   var error: Throwable? = null)