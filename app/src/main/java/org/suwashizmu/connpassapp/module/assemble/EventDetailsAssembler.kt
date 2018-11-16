package org.suwashizmu.connpassapp.module.assemble

import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.AndroidComponentsWeakScope
import org.kodein.di.direct
import org.kodein.di.generic.*
import org.suwashizmu.connpassapp.module.presenter.EventDetailsPresenter
import org.suwashizmu.connpassapp.module.presenter.IEventDetailsPresenter
import org.suwashizmu.connpassapp.module.router.EventDetailsRouter
import org.suwashizmu.connpassapp.module.router.IEventDetailsRouter
import org.suwashizmu.connpassapp.module.usecase.FetchSingleEventInteractor
import org.suwashizmu.connpassapp.module.usecase.IFetchSingleEventUseCase
import org.suwashizmu.connpassapp.view.EventDetailsFragment

/**
 * Created by KEKE
 * CleanArchitectureの構築を行う
 */
class EventDetailsAssembler {
    fun assembleEventDetails(activity: KodeinAware, fragment: EventDetailsFragment) {
        val kodein = Kodein.lazy {
            extend(activity.kodein)

            //presenterはAndroidComponentsWeakScopeで生成する
            bind<IEventDetailsPresenter>() with scoped(AndroidComponentsWeakScope).singleton { EventDetailsPresenter() }
            bind<IFetchSingleEventUseCase>() with provider { FetchSingleEventInteractor(instance(), instance()) }
            bind<IEventDetailsRouter>() with scoped(AndroidComponentsWeakScope).singleton { EventDetailsRouter() }
        }

        val presenter: IEventDetailsPresenter by kodein.instance()

        presenter.useCase = kodein.direct.instance()
        presenter.router = kodein.direct.instance()

        fragment.presenter = presenter
    }
}