package org.suwashizmu.connpassapp.view


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import android.widget.ArrayAdapter
import com.orhanobut.logger.Logger
import org.suwashizmu.connpassapp.R
import org.suwashizmu.connpassapp.databinding.WizardFragBinding
import org.suwashizmu.connpassapp.module.entity.Area
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

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

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.wizard_area, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.action_next) {

            val selectedArea = binding.spinner.selectedItem as? Area ?: return true

            presenter?.onNextButtonClick(selectedArea)

            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun update(viewModel: AreaSelectViewModel) {

        Logger.d(viewModel)

        if (binding.spinner.adapter == null) {
            binding.spinner.adapter = ArrayAdapter(requireActivity(), android.R.layout.simple_list_item_1, viewModel.areaList.toMutableList())
        }
    }
}