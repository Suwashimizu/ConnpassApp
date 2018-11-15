package org.suwashizmu.connpassapp.module.presenter

import org.suwashizmu.connpassapp.module.view.SearchSettingsViewModel

/**
 * Created by KEKE on 2018/10/21.
 */
object SearchSettingsSubject : ViewModelSubject<SearchSettingsViewModel>() {

    override fun update(t: SearchSettingsViewModel) = subject.onNext(t)
}