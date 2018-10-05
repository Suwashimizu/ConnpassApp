package org.suwashizmu.connpassapp.module.usecase

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.suwashizmu.connpassapp.module.input.EventSearchInputData
import org.suwashizmu.connpassapp.module.output.EventSearchOutputData
import org.suwashizmu.connpassapp.module.presenter.IEventSearchPresenter
import org.suwashizmu.connpassapp.module.repository.EventRepository

/**
 * Created by KEKE on 2018/10/06.
 */
class EventSearchInteractor(private val eventSearchRepository: EventRepository,
                            private val eventSearchPresenter: IEventSearchPresenter) : IEventSearchUseCase {

    override fun search(inputData: EventSearchInputData) {
        //varargには*をつけること
        eventSearchRepository.findEvent(*inputData.keyword.toTypedArray())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { eventList ->
                            eventSearchPresenter.complete(EventSearchOutputData(
                                    eventList.map { EventSearchOutputData.OutputEvent(it.title, it.catch, it.description) }
                            ))
                        },
                        { error ->
                            error.printStackTrace()
                        }
                )
    }

}