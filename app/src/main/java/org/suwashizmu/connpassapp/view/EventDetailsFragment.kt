package org.suwashizmu.connpassapp.view

import android.app.PendingIntent
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.orhanobut.logger.Logger
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
        if (viewModel.error == null) {

            //URL共有を追加
            val shareIntent = Intent(Intent.ACTION_SEND)
                    .setType("text/plain")
                    .putExtra(Intent.EXTRA_TEXT, viewModel.eventUrl)
            val pendingIntent = PendingIntent.getActivity(requireContext(), 0, shareIntent, 0)
            val drawable = ContextCompat.getDrawable(requireContext(), R.drawable.ic_share_black_24dp)
                    ?: return

            //vectorからbitmapを生成
            val icon = Bitmap.createBitmap(drawable.intrinsicWidth, drawable.intrinsicHeight, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(icon)
            drawable.setBounds(0, 0, canvas.width, canvas.height)
            drawable.draw(canvas)

            //ChromeTabsの設定
            val tabsIntent = CustomTabsIntent.Builder()
                    .setShowTitle(true)
                    .setToolbarColor(ContextCompat.getColor(requireActivity(), R.color.colorPrimary))
                    .setActionButton(icon, getString(R.string.share), pendingIntent)
                    .build()

            tabsIntent.launchUrl(requireActivity(), Uri.parse(viewModel.eventUrl))
        }

        Logger.d(viewModel)
    }

    //リンクを外部ブラウザで開く
    private val webViewClient = object : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(view?.url)))
            return true
        }
    }
}
