package org.suwashizmu.connpassapp.module.presenter

import org.suwashizmu.connpassapp.module.entity.Area
import org.suwashizmu.connpassapp.module.view.AreaSelectViewModel
import org.suwashizmu.connpassapp.module.view.IAreaSelectView

/**
 * Created by KEKE on 2018/10/06.
 */
class AreaSelectPresenter(private val view: IAreaSelectView) : IAreaSelectPresenter {

    override fun completeSelected(area: Area) {

        val viewModel = AreaSelectViewModel(area)
        view.update(viewModel)
    }
}