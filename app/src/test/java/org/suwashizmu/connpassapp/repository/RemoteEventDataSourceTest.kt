package org.suwashizmu.connpassapp.repository

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import io.reactivex.Single
import org.junit.Test
import org.suwashizmu.connpassapp.service.api.ConnpassService
import org.suwashizmu.connpassapp.service.api.SearchResult

/**
 * Created by KEKE on 2018/10/05.
 */
class RemoteEventDataSourceTest {

    private val mock: ConnpassService = mock {
        //mapperでヌルポが出るのでデータを返すようにしている
        //mapperのテストが出来ていれば確認することはメソッドのコールのみである
        on { searchEvents(any()) } doReturn Single.just(SearchResult(1, emptyList(), 2, 3))
    }
    private val remoteDataSource = RemoteEventDataSource(mock)

    @Test
    fun `find event`() {
        remoteDataSource.findEvent("kotlin")

        verify(mock).searchEvents(any())
    }
}