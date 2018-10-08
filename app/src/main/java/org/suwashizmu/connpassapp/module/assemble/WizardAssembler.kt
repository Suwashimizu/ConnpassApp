package org.suwashizmu.connpassapp.module.assemble

import org.kodein.di.Kodein
import org.kodein.di.android.AndroidComponentsWeakScope
import org.kodein.di.generic.*
import org.suwashizmu.connpassapp.module.presenter.AreaSelectPresenter
import org.suwashizmu.connpassapp.module.presenter.IInterestCategoriesPresenter
import org.suwashizmu.connpassapp.module.presenter.InterestCategoriesPresenter
import org.suwashizmu.connpassapp.module.router.WizardRouter
import org.suwashizmu.connpassapp.module.usecase.AreaSelectInteractor
import org.suwashizmu.connpassapp.module.usecase.IAreaSelectUseCase
import org.suwashizmu.connpassapp.module.usecase.InterestCategoriesGetInteractor
import org.suwashizmu.connpassapp.module.usecase.InterestCategoriesGetUseCase
import org.suwashizmu.connpassapp.view.MainActivity
import org.suwashizmu.connpassapp.view.WizardFragment
import org.suwashizmu.connpassapp.view.WizardInterestFragment

/**
 * Created by KEKE on 2018/10/07.
 */
class WizardAssembler {

    companion object {
        const val TAG_FRAGMENT = "wizard"
        const val TAG_INTEREST = "interest"
    }

    fun assembleFragment(activity: MainActivity) {

        val kodein = Kodein.lazy {
            extend(activity.kodein)

            //presenterはAndroidComponentsWeakScopeで生成する
            bind<AreaSelectPresenter>() with scoped(AndroidComponentsWeakScope).singleton { AreaSelectPresenter() }
            bind<IAreaSelectUseCase>() with provider { AreaSelectInteractor(instance(), instance()) }
            bind<WizardRouter>() with scoped(AndroidComponentsWeakScope).singleton { WizardRouter() }
        }

        val presenter: AreaSelectPresenter by kodein.instance()
        val useCase: IAreaSelectUseCase by kodein.instance()
        val router: WizardRouter by kodein.instance()

        presenter.useCase = useCase
        presenter.router = router

        val f = activity.supportFragmentManager
                .findFragmentByTag(TAG_FRAGMENT) as WizardFragment
        f.presenter = presenter

        router.fragment = f
    }

    fun assembleInterestCategories(activity: MainActivity, fragment: WizardInterestFragment) {

        val kodein = Kodein.lazy {
            extend(activity.kodein)

            //presenterはAndroidComponentsWeakScopeで生成する
            bind<IInterestCategoriesPresenter>() with scoped(AndroidComponentsWeakScope).singleton { InterestCategoriesPresenter() }
            bind<InterestCategoriesGetUseCase>() with provider { InterestCategoriesGetInteractor(instance(), instance()) }
            bind<WizardRouter>() with scoped(AndroidComponentsWeakScope).singleton { WizardRouter() }
        }

        val presenter: IInterestCategoriesPresenter by kodein.instance()
        val useCase: InterestCategoriesGetUseCase by kodein.instance()

        presenter.getUseCase = useCase

        fragment.presenter = presenter

    }
}