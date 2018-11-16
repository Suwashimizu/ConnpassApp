package org.suwashizmu.connpassapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import org.suwashizmu.connpassapp.R
import org.suwashizmu.connpassapp.databinding.EventDetailsFragBinding
import org.suwashizmu.connpassapp.module.presenter.EventDetailsSubject
import org.suwashizmu.connpassapp.module.presenter.IEventDetailsPresenter
import org.suwashizmu.connpassapp.module.view.EventDetailsViewModel
import org.suwashizmu.connpassapp.module.view.IEventDetailsView

class EventDetailsFragment : Fragment(), IEventDetailsView {

    companion object {
        fun newInstance(): EventDetailsFragment = EventDetailsFragment()
    }

    private lateinit var binding: EventDetailsFragBinding
    private val subject = EventDetailsSubject

    override var presenter: IEventDetailsPresenter? = null
    //ViewModelの変化を監視
    private val disposable = CompositeDisposable()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.event_details_frag, container, false)

        //setup onClickListener

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presenter?.onCreate()
        presenter?.getEvent(getEventId())
    }

    override fun onResume() {
        super.onResume()

        presenter?.onResume()


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

    private fun getEventId(): Int =
            requireActivity().intent.getIntExtra(EventDetailsActivity.KEY_ID, -1)

    override fun update(viewModel: EventDetailsViewModel) {
        if (viewModel.error != null) {
            binding.webView.loadUrl(viewModel.eventUrl)
        }
    }
}
