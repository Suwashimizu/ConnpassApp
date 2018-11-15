package org.suwashizmu.connpassapp.module.presenter

import org.suwashizmu.connpassapp.module.view.AreaSelectViewModel

/**
 * Created by KEKE on 2018/10/07.
 *
 * ViewModelの変更を通知するObserver
 */
object AreaSelectSubject : ViewModelSubject<AreaSelectViewModel>() {
    override fun update(t: AreaSelectViewModel) = subject.onNext(t)
}