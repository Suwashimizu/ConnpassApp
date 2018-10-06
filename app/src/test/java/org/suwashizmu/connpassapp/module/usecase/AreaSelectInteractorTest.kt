package org.suwashizmu.connpassapp.module.usecase

import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test
import org.suwashizmu.connpassapp.module.entity.Area
import org.suwashizmu.connpassapp.module.input.AreaSelectInputData
import org.suwashizmu.connpassapp.module.presenter.IAreaSelectPresenter
import org.suwashizmu.connpassapp.module.repository.AreaRepository

/**
 * Created by KEKE on 2018/10/06.
 */
class AreaSelectInteractorTest {

    private val presenter: IAreaSelectPresenter = mock()
    private val repository: AreaRepository = mock()

    private val interactor = AreaSelectInteractor(presenter, repository)

    @Test
    fun getAreaList() {
        interactor.getAreaList()

        verify(repository).getAreaList()
    }

    @Test
    fun select() {
        interactor.select(AreaSelectInputData(Area.TOKYO))

        verify(repository).save(eq(Area.TOKYO))
    }
}