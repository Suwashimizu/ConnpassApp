package org.suwashizmu.connpassapp.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.view.*
import com.orhanobut.logger.Logger
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import org.suwashizmu.connpassapp.R
import org.suwashizmu.connpassapp.databinding.SearchSettingsFragBinding
import org.suwashizmu.connpassapp.module.presenter.ISearchSettingsPresenter
import org.suwashizmu.connpassapp.module.presenter.SearchSettingsSubject
import org.suwashizmu.connpassapp.module.view.ISearchSettingsView
import org.suwashizmu.connpassapp.module.view.SearchSettingsViewModel
import org.suwashizmu.connpassapp.view.adapter.SearchSettingsAdapter
import org.suwashizmu.connpassapp.view.dialog.AreaChoiceDialogFragment
import org.suwashizmu.connpassapp.view.dialog.InterestChoiceDialogFragment

class SearchSettingsFragment : Fragment(), ISearchSettingsView {

    companion object {

        private const val TAG_AREA = "areaDialog"
        private const val TAG_INTEREST = "interestDialog"

        private const val REQUEST_AREA = 0
        private const val REQUEST_INTEREST = 1

        fun newInstance(): SearchSettingsFragment = SearchSettingsFragment()
    }

    private lateinit var binding: SearchSettingsFragBinding
    override var presenter: ISearchSettingsPresenter? = null
    //ViewModelの変化を監視
    private val disposable = CompositeDisposable()
    private val subject: SearchSettingsSubject = SearchSettingsSubject

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.search_settings_frag, container, false)

        //setup onClickListener
        //navigationButtonを有効にする
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(true)
        (requireActivity() as AppCompatActivity).supportActionBar?.setTitle(R.string.search_settings)
        requireActivity().findViewById<Toolbar>(R.id.toolbar).setNavigationOnClickListener(navigationListener)

        binding.listView.adapter = SearchSettingsAdapter(areaItemClickListener, interestItemClickListener)
        binding.listView.layoutManager = LinearLayoutManager(requireActivity())

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presenter?.onCreate()
    }

    override fun onResume() {
        super.onResume()

        subject.observable
                .subscribe(this::update)
                .addTo(disposable)

    }

    override fun onPause() {
        super.onPause()

        presenter?.onPause()
        disposable.clear()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.onDestroy()

        presenter = null
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.search_settings, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.action_save) {
            val viewModel = presenter?.viewModel ?: return true
            presenter?.saveSettings(viewModel.area!!, *viewModel.interestCategories.toTypedArray())
        }
        return super.onOptionsItemSelected(item)
    }

    //observer経由で更新が通知される
    //ViewModelにErrorが含まれるので表示すること
    override fun update(searchSettingsViewModel: SearchSettingsViewModel) {
        Logger.d(searchSettingsViewModel)

        val adapter = binding.listView.adapter as? SearchSettingsAdapter ?: return

        adapter.viewModel = searchSettingsViewModel
        adapter.notifyDataSetChanged()

        if (searchSettingsViewModel.isShowInterestChoiceDialog) {
            if (fragmentManager?.findFragmentByTag(TAG_INTEREST) == null) {
                presenter?.viewModel?.let {

                    InterestChoiceDialogFragment.newInstance(this, REQUEST_INTEREST, it)
                            .show(fragmentManager, TAG_INTEREST)
                }
            }
        }
    }

    private val navigationListener: View.OnClickListener = View.OnClickListener {
        presenter?.onNavigationButtonClick()
    }

    private val areaItemClickListener: () -> Unit = {
        if (fragmentManager?.findFragmentByTag(TAG_AREA) == null) {
            presenter?.viewModel?.let {
                AreaChoiceDialogFragment.newInstance(this, REQUEST_AREA, it)
                        .show(fragmentManager, TAG_AREA)
            }
        }
    }

    private val interestItemClickListener: () -> Unit = {
        presenter?.onInterestItemClick()
    }
}
