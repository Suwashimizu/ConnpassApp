package org.suwashizmu.connpassapp.module.repository.local

import android.support.v7.app.AppCompatActivity
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.suwashizmu.connpassapp.module.entity.InterestCategory

/**
 * Created by KEKE on 2018/10/08.
 */
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [21])
class LocalInterestCategoryRepositoryTest {

    private val repository = LocalInterestCategoryRepository(Robolectric.setupActivity(AppCompatActivity::class.java))

    @Test
    fun getInterestCategories() {
        assertThat(repository.getInterestCategories().size).isGreaterThan(0)
    }


    @Test
    fun save() {
        repository.save(InterestCategory.DESIGN)

        assertThat(repository.getCurrentInterestCategories()).contains(InterestCategory.DESIGN)

        //複数保存した場合
        repository.save(InterestCategory.ANDROID, InterestCategory.ELIXIR, InterestCategory.RUBY)

        assertThat(repository.getCurrentInterestCategories()).contains(InterestCategory.ANDROID, InterestCategory.ELIXIR, InterestCategory.RUBY)
    }

    @Test
    fun `getInterestCategory is null when not save`() {
        assertThat(repository.getCurrentInterestCategories()).isNull()
    }
}