package org.suwashizmu.connpassapp.module.router

import android.support.v4.app.Fragment
import android.widget.Toast

/**
 * Created by KEKE on 2018/10/07.
 */
class WizardRouter(private val fragment: Fragment) : IWizardRouter {
    override fun gotoInterestSelect() {
        if (fragment.isAdded.not()) return

        Toast.makeText(fragment.requireActivity(), "goto NextView!", Toast.LENGTH_SHORT).show()
    }
}