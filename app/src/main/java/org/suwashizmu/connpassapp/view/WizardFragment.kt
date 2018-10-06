package org.suwashizmu.connpassapp.view


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import org.suwashizmu.connpassapp.R
import org.suwashizmu.connpassapp.databinding.WizardFragBinding
import org.suwashizmu.connpassapp.module.presenter.IAreaSelectPresenter
import org.suwashizmu.connpassapp.module.view.AreaSelectViewModel
import org.suwashizmu.connpassapp.module.view.IAreaSelectView

/**
 * Created by KEKE on 2018/10/06.
 */
class WizardFragment : Fragment(), IAreaSelectView {

    companion object {
        fun newInstance(): WizardFragment = WizardFragment()
    }

    override var presenter: IAreaSelectPresenter? = null

    private lateinit var binding: WizardFragBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.wizard_frag, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presenter?.fetchAreaList()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun update(viewModel: AreaSelectViewModel) {

        if (binding.spinner.adapter == null) {
            binding.spinner.adapter = ArrayAdapter(requireActivity(), android.R.layout.simple_list_item_1, viewModel.areaList.toMutableList())
        }
    }
}