package org.suwashizmu.connpassapp.view.dialog

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import org.suwashizmu.connpassapp.module.entity.Area
import org.suwashizmu.connpassapp.module.view.SearchSettingsViewModel

/**
 * Created by KEKE on 2018/10/21.
 */
class AreaChoiceDialogFragment : DialogFragment() {

    companion object {

        private const val KEY_AREA_SOURCE = "area"

        fun newInstance(target: Fragment, requestCode: Int, viewModel: SearchSettingsViewModel): AreaChoiceDialogFragment {
            return AreaChoiceDialogFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(KEY_AREA_SOURCE, viewModel.areaSource?.toTypedArray())
                }
                setTargetFragment(target, requestCode)
            }
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val source = arguments?.getSerializable(KEY_AREA_SOURCE) as Array<Area>

        return AlertDialog.Builder(requireActivity())
                .setSingleChoiceItems(source.map { it.name }.toTypedArray(), 0) { _, which: Int ->
                    targetFragment?.onActivityResult(targetRequestCode, Activity.RESULT_OK, Intent().putExtra("area", source[which]))
                    dismiss()
                }
                .create()
    }
}