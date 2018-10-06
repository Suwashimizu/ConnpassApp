package org.suwashizmu.connpassapp.module.presenter

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test
import org.suwashizmu.connpassapp.module.entity.Area
import org.suwashizmu.connpassapp.module.view.IAreaSelectView

/**
 * Created by KEKE on 2018/10/06.
 */
class AreaSelectPresenterTest {

    private val view: IAreaSelectView = mock()
    private val presenter = AreaSelectPresenter(view)

    @Test
    fun completeSelected() {
        presenter.completeSelected(Area.TOKYO)

        verify(view).update(any())
    }
}