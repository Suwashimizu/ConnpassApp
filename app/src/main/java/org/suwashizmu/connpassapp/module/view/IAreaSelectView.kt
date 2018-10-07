package org.suwashizmu.connpassapp.module.view

import org.suwashizmu.connpassapp.module.presenter.IAreaSelectPresenter

/**
 * Created by KEKE on 2018/10/06.
 */
interface IAreaSelectView {

    var presenter: IAreaSelectPresenter?

    fun update(viewModel: AreaSelectViewModel)
}