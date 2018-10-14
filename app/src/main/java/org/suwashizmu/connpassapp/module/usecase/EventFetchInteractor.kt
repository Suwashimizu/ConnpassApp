package org.suwashizmu.connpassapp.module.usecase

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.suwashizmu.connpassapp.module.output.EventSearchOutputData
import org.suwashizmu.connpassapp.module.presenter.IEventListPresenter
import org.suwashizmu.connpassapp.module.repository.AreaRepository
import org.suwashizmu.connpassapp.module.repository.EventRepository
import org.suwashizmu.connpassapp.module.repository.InterestCategoryRepository

/**
 * Created by KEKE on 2018/10/14.
 */
class EventFetchInteractor(private val presenter: IEventListPresenter,
                           private val areaRepository: AreaRepository,
                           private val interestCategoryRepository: InterestCategoryRepository,
                           private val eventRepository: EventRepository) : IEventFetchUseCase {
    override fun fetchEvent() {
        val area = areaRepository.getArea()
        val interestCategory = interestCategoryRepository.getCurrentInterestCategories()

        interestCategory ?: return
        eventRepository.findEvent(*interestCategory.map { it.name }.toTypedArray())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { eventList ->
                            presenter.complete(EventSearchOutputData(
                                    eventList = eventList.map {
                                        EventSearchOutputData.OutputEvent(
                                                it.title,
                                                it.catch,
                                                it.description)
                                    },
                                    error = null
                            ))
                        },
                        { error ->
                            presenter.complete(EventSearchOutputData(
                                    eventList = emptyList(),
                                    error = error
                            ))
                        }
                )
    }
}