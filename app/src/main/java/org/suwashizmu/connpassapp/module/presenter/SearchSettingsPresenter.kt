package org.suwashizmu.connpassapp.module.presenter

import org.suwashizmu.connpassapp.module.controller.ISearchSettingsController
import org.suwashizmu.connpassapp.module.entity.Area
import org.suwashizmu.connpassapp.module.entity.InterestCategory
import org.suwashizmu.connpassapp.module.output.SearchSettingsOutputPort
import org.suwashizmu.connpassapp.module.router.ISearchSettingsRouter
import org.suwashizmu.connpassapp.module.usecase.IFetchSettingsUseCase
import org.suwashizmu.connpassapp.module.usecase.ISaveSettingsUseCase

/**
 * Created by KEKE
 */
class SearchSettingsPresenter : ISearchSettingsPresenter, ISearchSettingsController, SearchSettingsOutputPort {

    //subject
    override var saveUseCase: ISaveSettingsUseCase? = null
    override var fetchSettingsUseCase: IFetchSettingsUseCase? = null
    override var router: ISearchSettingsRouter? = null

    override fun onCreate() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onResume() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onPause() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDestroy() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    //region ISearchSettingsController
    override fun loadSettings() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveSettings(area: Area, vararg interestCategory: InterestCategory) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    //endregion ISearchSettingsController

    //region SearchSettingsOutputPort
    override fun complete(error: Throwable?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    //endregion SearchSettingsOutputPort
}