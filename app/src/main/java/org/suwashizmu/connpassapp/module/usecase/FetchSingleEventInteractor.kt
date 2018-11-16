package org.suwashizmu.connpassapp.module.usecase

import com.orhanobut.logger.Logger
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.suwashizmu.connpassapp.module.output.EventDetailsOutputData
import org.suwashizmu.connpassapp.module.output.EventDetailsOutputPort
import org.suwashizmu.connpassapp.module.repository.EventRepository

/**
 * Created by KEKE on 2018/11/16.
 */
class FetchSingleEventInteractor(private val repository: EventRepository,
                                 private val output: EventDetailsOutputPort) : IFetchSingleEventUseCase {

    override fun fetchEvent(id: Int) {
        repository.findById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            Logger.d(it)
                            output.complete(EventDetailsOutputData(
                                    title = it.title,
                                    url = it.eventUtl), null)
                        },
                        {
                            it.printStackTrace()
                            output.complete(null, it)
                        }
                )
    }
}