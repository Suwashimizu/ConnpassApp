package org.suwashizmu.connpassapp.module.repository

import android.support.v7.app.AppCompatActivity
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.suwashizmu.connpassapp.module.entity.Area
import org.suwashizmu.connpassapp.module.repository.local.LocalAreaRepository

/**
 * Created by KEKE on 2018/10/06.
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [21])
class LocalAreaRepositoryTest {

    //roborectricを使用したContext,perfへの書き込み読み込みが可能,mockでは無いのでverifyは使えない,spyもMainActivityがfinalClassのため使えなかった
    private val roboContext = Robolectric.setupActivity(AppCompatActivity::class.java)
    private val repository = LocalAreaRepository(roboContext)

    @Test
    fun getAreaList() {
        assertThat(repository.getAreaList().size).isEqualTo(47)
    }

    @Test
    fun `getArea is null when not save`() {

        val repository = LocalAreaRepository(roboContext)
        val area = repository.getArea()

        assertThat(area).isNull()
    }

    @Test
    fun `getArea is FUKUOKA when fukuoka saved`() {

        val repository = LocalAreaRepository(roboContext)

        repository.save(Area.FUKUOKA)

        val area = repository.getArea()

        assertThat(area).isEqualTo(Area.FUKUOKA)
    }

}