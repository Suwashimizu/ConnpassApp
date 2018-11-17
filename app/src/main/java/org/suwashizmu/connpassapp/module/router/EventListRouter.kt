package org.suwashizmu.connpassapp.module.router

import android.app.PendingIntent
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import org.suwashizmu.connpassapp.R
import org.suwashizmu.connpassapp.module.assemble.SearchSettingsAssembler
import org.suwashizmu.connpassapp.view.EventListActivity
import org.suwashizmu.connpassapp.view.SearchSettingsFragment

/**
 * Created by KEKE
 */

class EventListRouter : IEventListRouter {

    companion object {
        const val TAG_SEARCH_SETTINGS = "settings"
    }

    var fragment: androidx.fragment.app.Fragment? = null

    override fun gotoSearchSettings() {

        if (fragment?.isAdded == false) return

        val (fragment, activity) = Pair(fragment!!, fragment!!.requireActivity() as EventListActivity)

        val searchSettingsFragment = SearchSettingsFragment.newInstance()

        fragment.requireFragmentManager().beginTransaction()
                //googleNewのアニメを参考
                .setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.slide_out_down)
                .replace(R.id.container, searchSettingsFragment, TAG_SEARCH_SETTINGS)
                .addToBackStack(null)
                .commit()

        SearchSettingsAssembler().assembleSearchSettings(activity, searchSettingsFragment)
    }

    override fun gotoEventDetails(eventId: Int, title: String, eventUrl: String) {

        val context = fragment?.activity ?: return

        //URL共有を追加
        val shareIntent = Intent(Intent.ACTION_SEND)
                .setType("text/plain")
                .putExtra(Intent.EXTRA_TEXT, eventUrl)
        val pendingIntent = PendingIntent.getActivity(context, 0, shareIntent, 0)
        val drawable = ContextCompat.getDrawable(context, R.drawable.ic_share_black_24dp)
                ?: return

        //vectorからbitmapを生成
        val icon = Bitmap.createBitmap(drawable.intrinsicWidth, drawable.intrinsicHeight, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(icon)
        drawable.setBounds(0, 0, canvas.width, canvas.height)
        drawable.draw(canvas)

        //ChromeTabsの設定
        val tabsIntent = CustomTabsIntent.Builder()
                .setShowTitle(true)
                .setToolbarColor(ContextCompat.getColor(context, R.color.colorPrimary))
                .setActionButton(icon, context.getString(R.string.share), pendingIntent)
                .build()

        tabsIntent.launchUrl(context, Uri.parse(eventUrl))
    }
}