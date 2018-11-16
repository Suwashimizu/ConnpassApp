package org.suwashizmu.connpassapp.module.assemble

import androidx.fragment.app.Fragment
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.AndroidComponentsWeakScope
import org.kodein.di.direct
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.scoped
import org.kodein.di.generic.singleton
import org.suwashizmu.connpassapp.module.presenter.EventDetailsPresenter
import org.suwashizmu.connpassapp.module.presenter.IEventDetailsPresenter
import org.suwashizmu.connpassapp.module.router.EventDetailsRouter
import org.suwashizmu.connpassapp.module.router.IEventDetailsRouter

/**
 * Created by KEKE
 * CleanArchitectureの構築を行う
 */
class EventDetailsAssembler {
    fun assembleEventDetails(activity: KodeinAware, fragment: Fragment) {
        val kodein = Kodein.lazy {
            extend(activity.kodein)

            //presenterはAndroidComponentsWeakScopeで生成する
            bind<IEventDetailsPresenter>() with scoped(AndroidComponentsWeakScope).singleton { EventDetailsPresenter() }

            //assemble usecase here

            //
            bind<IEventDetailsRouter>() with scoped(AndroidComponentsWeakScope).singleton { EventDetailsRouter() }
        }

        val presenter: IEventDetailsPresenter by kodein.instance()

        //presenter.usecase = kodein.direct.instance()
        presenter.router = kodein.direct.instance()

        //fragment.presenter = presenter
    }
}