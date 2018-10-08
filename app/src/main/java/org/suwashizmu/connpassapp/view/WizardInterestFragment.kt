package org.suwashizmu.connpassapp.view


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.orhanobut.logger.Logger
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import org.suwashizmu.connpassapp.module.presenter.IInterestCategoriesPresenter
import org.suwashizmu.connpassapp.module.presenter.InterestCategoriesSubject
import org.suwashizmu.connpassapp.module.view.IInterestCategoriesView
import org.suwashizmu.connpassapp.module.view.InterestCategoriesViewModel

/**
 * Created by KEKE on 2018/10/08.
 */
class WizardInterestFragment : Fragment(), IInterestCategoriesView {

    companion object {
        fun newInstance(): WizardInterestFragment =
                WizardInterestFragment()
    }

    private val subject = InterestCategoriesSubject
    private val disposable = CompositeDisposable()

    override var presenter: IInterestCategoriesPresenter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()

        //ViewModelの更新の購読
        subject.observable
                .subscribe(this::update)
                .addTo(disposable)

        presenter?.fetchInterestCategories()
    }

    override fun onPause() {
        super.onPause()

        disposable.clear()
    }

    override fun update(viewModel: InterestCategoriesViewModel) {

        //listView adapter
        Logger.d(viewModel)
    }
}