package org.suwashizmu.connpassapp.module.view

import org.suwashizmu.connpassapp.module.presenter.IInterestCategoriesPresenter

/**
 * Created by KEKE on 2018/10/08.
 */
interface IInterestCategoriesView {

    var presenter: IInterestCategoriesPresenter?

    fun update(viewModel: InterestCategoriesViewModel)
}