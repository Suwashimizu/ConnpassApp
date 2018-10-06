package org.suwashizmu.connpassapp.module.usecase

import org.suwashizmu.connpassapp.module.input.AreaSelectInputData
import org.suwashizmu.connpassapp.module.presenter.IAreaSelectPresenter
import org.suwashizmu.connpassapp.module.repository.AreaRepository

/**
 * Created by KEKE on 2018/10/06.
 */
class AreaSelectInteractor(private val presenter: IAreaSelectPresenter,
                           private val repository: AreaRepository) : IAreaSelectUseCase {

    override fun getAreaList() = presenter.completeAreaList(repository.getAreaList())

    override fun select(inputData: AreaSelectInputData) {
        repository.save(inputData.area)

        presenter.completeSelected(inputData.area)
    }
}