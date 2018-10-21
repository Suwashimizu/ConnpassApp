package org.suwashizmu.connpassapp.module.assemble

import android.support.v4.app.Fragment
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.AndroidComponentsWeakScope
import org.kodein.di.direct
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.scoped
import org.kodein.di.generic.singleton

import org.suwashizmu.connpassapp.module.presenter.ISearchSettingsPresenter
import org.suwashizmu.connpassapp.module.presenter.SearchSettingsPresenter
import org.suwashizmu.connpassapp.module.router.ISearchSettingsRouter
import org.suwashizmu.connpassapp.module.router.SearchSettingsRouter

/**
 * Created by KEKE
 * CleanArchitectureの構築を行う
 */
class SearchSettingsAssembler {
    fun assembleSearchSettings(activity: KodeinAware, fragment: Fragment) {
        val kodein = Kodein.lazy {
            extend(activity.kodein)

            //presenterはAndroidComponentsWeakScopeで生成する
            bind<ISearchSettingsPresenter>() with scoped(AndroidComponentsWeakScope).singleton { SearchSettingsPresenter() }

            //assemble usecase here

            //
            bind<ISearchSettingsRouter>() with scoped(AndroidComponentsWeakScope).singleton { SearchSettingsRouter() }
        }

        val presenter: ISearchSettingsPresenter by kodein.instance()

        //presenter.usecase = kodein.direct.instance()
        presenter.router = kodein.direct.instance()

        //fragment.presenter = presenter
    }
}