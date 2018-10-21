package org.suwashizmu.connpassapp.view.dialog

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.app.AlertDialog
import org.suwashizmu.connpassapp.module.view.SearchSettingsViewModel
import org.suwashizmu.connpassapp.view.SearchSettingsFragment

/**
 * Created by KEKE on 2018/10/21.
 */
class AreaChoiceDialogFragment : DialogFragment() {

    companion object {

        private const val KEY_AREA_SOURCE = "area"

        fun newInstance(target: SearchSettingsFragment, requestCode: Int, viewModel: SearchSettingsViewModel): AreaChoiceDialogFragment {
            return AreaChoiceDialogFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(KEY_AREA_SOURCE, viewModel.areaSource?.toTypedArray())
                }
                setTargetFragment(target, requestCode)
            }
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val searchSettingsFragment = targetFragment as SearchSettingsFragment
        val areaSource = searchSettingsFragment.presenter!!.viewModel.areaSource!!
        val firstPosition = areaSource.indexOf(searchSettingsFragment.presenter?.viewModel?.area)

        return AlertDialog.Builder(requireActivity())
                .setSingleChoiceItems(areaSource.map { it.value }.toTypedArray(), firstPosition) { _, which: Int ->

                    searchSettingsFragment.presenter?.onAreaSelected(areaSource.elementAt(which))

                    dismiss()
                }
                .create()
    }
}