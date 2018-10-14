package org.suwashizmu.connpassapp.view

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import org.suwashizmu.connpassapp.R
import org.suwashizmu.connpassapp.databinding.EventListFragBinding
import org.suwashizmu.connpassapp.module.view.IEventListView
import org.suwashizmu.connpassapp.module.presenter.IEventListPresenter

class EventListFragment : Fragment(), IEventListView {

    companion object {
        fun newInstance(): EventListFragment = EventListFragment()
    }

    private lateinit var binding: EventListFragBinding
    override var presenter: IEventListPresenter? = null
    //ViewModelの変化を監視
    private val disposable = CompositeDisposable()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.event_list_frag, container, false)

        //setup onClickListener

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        /*
        subject.observable
                .subscribe(this::update)
                .addTo(disposable)
        */
    }

    override fun onPause() {
        super.onPause()

        disposable.clear()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.onDestroy()

        presenter = null
    }
}
