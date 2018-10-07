package org.suwashizmu.connpassapp.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.orhanobut.logger.Logger
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.AndroidComponentsWeakScope
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.*
import org.suwashizmu.connpassapp.R
import org.suwashizmu.connpassapp.module.presenter.AreaSelectPresenter
import org.suwashizmu.connpassapp.module.usecase.AreaSelectInteractor
import org.suwashizmu.connpassapp.module.usecase.IAreaSelectUseCase
import org.suwashizmu.connpassapp.module.view.ISearchEventView
import org.suwashizmu.connpassapp.module.view.SearchEventViewModel


open class MainActivity : AppCompatActivity(), KodeinAware, ISearchEventView {

    private val _parentKodein by closestKodein()
    override val kodein: Kodein = Kodein.lazy {
        extend(_parentKodein)
        //presenterはAndroidComponentsWeakScopeで生成する
        bind<AreaSelectPresenter>() with scoped(AndroidComponentsWeakScope).singleton { AreaSelectPresenter() }
        bind<IAreaSelectUseCase>() with provider { AreaSelectInteractor(instance(), instance()) }
    }

    private val presenter: AreaSelectPresenter by instance()
    private val useCase: IAreaSelectUseCase by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            /*
            val eventSearchController = EventSearchController(EventSearchInteractor(
                    RemoteEventDataSource(ConnpassClient.service),
                    EventSearchPresenter(this)
            ))

            eventSearchController.eventSearch("kotlin")
            */

            val fragment = WizardFragment.newInstance()
            supportFragmentManager.beginTransaction()
                    .add(R.id.container, fragment)
                    .commit()

            presenter.useCase = useCase
            fragment.presenter = presenter

        }
    }

    override fun updated(viewModel: SearchEventViewModel) {
        Logger.d("updated!")
    }
}
