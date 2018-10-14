package org.suwashizmu.connpassapp.module.router

import android.support.v4.app.Fragment
import com.orhanobut.logger.Logger
import org.suwashizmu.connpassapp.R
import org.suwashizmu.connpassapp.module.assemble.WizardAssembler
import org.suwashizmu.connpassapp.view.MainActivity
import org.suwashizmu.connpassapp.view.WizardInterestFragment

/**
 * Created by KEKE on 2018/10/07.
 */
class WizardRouter : IWizardRouter {
    lateinit var fragment: Fragment

    private val assembler = WizardAssembler()

    override fun gotoInterestSelect() {
        if (fragment.isAdded.not()) return

        val nextFragment = WizardInterestFragment.newInstance()

        fragment.fragmentManager
                ?.beginTransaction()
                ?.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_left, R.anim.slide_in_right, R.anim.slide_out_right)
                ?.replace(R.id.container, nextFragment, WizardAssembler.TAG_INTEREST)
                ?.addToBackStack(null)
                ?.commit()

        val mainActivity = fragment.activity as? MainActivity ?: return

        assembler.assembleInterestCategories(mainActivity, nextFragment)
    }

    override fun gotoEnventList() {
        Logger.d("event list")
    }
}