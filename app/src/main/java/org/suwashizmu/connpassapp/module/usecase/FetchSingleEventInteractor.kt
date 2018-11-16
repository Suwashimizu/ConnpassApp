package org.suwashizmu.connpassapp.module.usecase

import com.orhanobut.logger.Logger
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.suwashizmu.connpassapp.module.repository.EventRepository

/**
 * Created by KEKE on 2018/11/16.
 */
class FetchSingleEventInteractor(private val repository: EventRepository) : IFetchSingleEventUseCase {

    override fun fetchEvent(id: Int) {
        repository.findById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            Logger.d(it)
                        },
                        {
                            it.printStackTrace()
                        }
                )
    }
}