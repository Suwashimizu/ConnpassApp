package org.suwashizmu.connpassapp.module.assemble

import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.AndroidComponentsWeakScope
import org.kodein.di.direct
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.scoped
import org.kodein.di.generic.singleton
import org.suwashizmu.connpassapp.module.presenter.EventListPresenter
import org.suwashizmu.connpassapp.module.presenter.IEventListPresenter
import org.suwashizmu.connpassapp.module.router.EventListRouter
import org.suwashizmu.connpassapp.module.router.IEventListRouter
import org.suwashizmu.connpassapp.module.usecase.EventFetchInteractor
import org.suwashizmu.connpassapp.module.usecase.IEventFetchUseCase
import org.suwashizmu.connpassapp.view.EventListFragment

/**
 * Created by KEKE
 * CleanArchitectureの構築を行う
 */
class EventListAssembler {
    fun assembleEventList(activity: KodeinAware, fragment: EventListFragment) {
        val kodein = Kodein.lazy {
            extend(activity.kodein)

            //presenterはAndroidComponentsWeakScopeで生成する
            bind<IEventListPresenter>() with scoped(AndroidComponentsWeakScope).singleton { EventListPresenter() }

            //assemble usecase here
            bind<IEventFetchUseCase>() with scoped(AndroidComponentsWeakScope).singleton {
                EventFetchInteractor(
                        presenter = instance(),
                        areaRepository = instance(),
                        interestCategoryRepository = instance(),
                        eventRepository = instance()
                )
            }

            //
            bind<IEventListRouter>() with scoped(AndroidComponentsWeakScope).singleton {
                EventListRouter().apply {
                    this.fragment = fragment
                }
            }
        }

        val presenter: IEventListPresenter by kodein.instance()

        presenter.useCase = kodein.direct.instance()
        presenter.router = kodein.direct.instance()

        fragment.presenter = presenter
    }
}