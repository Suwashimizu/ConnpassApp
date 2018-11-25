package org.suwashizmu.connpassapp.module.presenter

import org.suwashizmu.connpassapp.module.view.EventDetailsViewModel

/**
 * Created by KEKE
 */
object EventDetailsSubject : ViewModelSubject<EventDetailsViewModel>() {
    override fun update(t: EventDetailsViewModel) = subject.onNext(t)
}