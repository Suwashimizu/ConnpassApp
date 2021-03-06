package org.suwashizmu.connpassapp.view


import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.orhanobut.logger.Logger
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import org.suwashizmu.connpassapp.R
import org.suwashizmu.connpassapp.databinding.WizardFragBinding
import org.suwashizmu.connpassapp.module.entity.Area
import org.suwashizmu.connpassapp.module.presenter.AreaSelectPresenter
import org.suwashizmu.connpassapp.module.presenter.AreaSelectSubject
import org.suwashizmu.connpassapp.module.view.AreaSelectViewModel
import org.suwashizmu.connpassapp.module.view.IAreaSelectView

/**
 * Created by KEKE on 2018/10/06.
 */
class WizardFragment : androidx.fragment.app.Fragment(), IAreaSelectView {

    companion object {
        fun newInstance(): WizardFragment = WizardFragment()
    }

    //ViewModelの変化を監視
    private val disposable = CompositeDisposable()
    private val subject = AreaSelectSubject

    override var presenter: AreaSelectPresenter? = null

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
        presenter?.subject = subject

        presenter?.onCreate()
    }

    override fun onResume() {
        super.onResume()

        subject.observable
                .subscribe(this::update)
                .addTo(disposable)

        presenter?.fetchAreaList()
    }

    override fun onPause() {
        super.onPause()

        disposable.clear()
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

    override fun onDestroy() {
        super.onDestroy()
        presenter?.onDestroy()

        presenter = null
    }

    //region IAreaSelectView
    override fun update(viewModel: AreaSelectViewModel) {

        Logger.d(viewModel)

        if (binding.spinner.adapter == null) {
            binding.spinner.adapter = object : ArrayAdapter<Area>(requireActivity(), android.R.layout.simple_list_item_1, viewModel.areaList.toMutableList()) {
                //表示は日本語で表示する
                override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                    return super.getView(position, convertView, parent).apply {
                        (this as TextView).text = getItem(position)?.value
                    }
                }

                override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
                    return super.getDropDownView(position, convertView, parent).apply {
                        (this as TextView).text = getItem(position)?.value
                    }
                }
            }

            //選択位置の復元
            val currentPosition = viewModel.areaList.indexOfFirst { it.id == viewModel.selectedArea?.id }
            binding.spinner.setSelection(currentPosition)
        }
    }
    //endregion IAreaSelectView
}