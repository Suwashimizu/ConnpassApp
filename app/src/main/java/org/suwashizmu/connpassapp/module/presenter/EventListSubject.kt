package org.suwashizmu.connpassapp.module.presenter

import org.suwashizmu.connpassapp.module.view.EventListViewModel

/**
 * Created by KEKE on 2018/10/15.
 */
object EventListSubject : ViewModelSubject<EventListViewModel>() {
    override fun update(t: EventListViewModel) = subject.onNext(t)
}