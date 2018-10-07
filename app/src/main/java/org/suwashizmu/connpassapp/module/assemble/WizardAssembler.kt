package org.suwashizmu.connpassapp.module.assemble

import org.kodein.di.Kodein
import org.kodein.di.android.AndroidComponentsWeakScope
import org.kodein.di.generic.*
import org.suwashizmu.connpassapp.module.presenter.AreaSelectPresenter
import org.suwashizmu.connpassapp.module.usecase.AreaSelectInteractor
import org.suwashizmu.connpassapp.module.usecase.IAreaSelectUseCase
import org.suwashizmu.connpassapp.view.MainActivity
import org.suwashizmu.connpassapp.view.WizardFragment

/**
 * Created by KEKE on 2018/10/07.
 */
class WizardAssembler {

    fun assembleFragment(activity: MainActivity): WizardFragment {

        val kodein = Kodein.lazy {
            extend(activity.kodein)

            //presenterはAndroidComponentsWeakScopeで生成する
            bind<AreaSelectPresenter>() with scoped(AndroidComponentsWeakScope).singleton { AreaSelectPresenter() }
            bind<IAreaSelectUseCase>() with provider { AreaSelectInteractor(instance(), instance()) }
        }

        val presenter: AreaSelectPresenter by kodein.instance()
        val useCase: IAreaSelectUseCase by kodein.instance()
        presenter.useCase = useCase

        return WizardFragment.newInstance().apply {
            this.presenter = presenter
        }
    }
}