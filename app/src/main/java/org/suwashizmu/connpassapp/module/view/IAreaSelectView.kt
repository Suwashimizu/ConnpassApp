package org.suwashizmu.connpassapp.module.view

import org.suwashizmu.connpassapp.module.presenter.AreaSelectPresenter

/**
 * Created by KEKE on 2018/10/06.
 */
interface IAreaSelectView {

    var presenter: AreaSelectPresenter?

    fun update(viewModel: AreaSelectViewModel)
}