package org.suwashizmu.connpassapp.module.repository.local

import android.content.Context
import org.suwashizmu.connpassapp.module.entity.InterestCategory
import org.suwashizmu.connpassapp.module.repository.InterestCategoryRepository

/**
 * Created by KEKE on 2018/10/08.
 */
class LocalInterestCategoryRepository(private val context: Context) : InterestCategoryRepository {

    companion object {
        private const val KEY_INTEREST_CATEGORY = "interestCategory"
        private const val KEY_CURRENT_AREA_IDS = "currentInterestCategoryIds"
    }

    override fun getInterestCategories(): Collection<InterestCategory> =
            InterestCategory.values().toList()

    override fun save(vararg interestCategory: InterestCategory) {
        //選択が空のときは？
        if (interestCategory.isEmpty()) throw IllegalStateException("requires value")

        context.getSharedPreferences(KEY_INTEREST_CATEGORY, Context.MODE_PRIVATE)
                .edit()
                .putString(KEY_CURRENT_AREA_IDS, interestCategory.map { it.id }.joinToString(","))
                .apply()

    }

    override fun getCurrentInterestCategories(): Collection<InterestCategory>? {
        //idが消えたときは？→消すな,使用不可フラグを追加する

        val pref = context.getSharedPreferences(KEY_INTEREST_CATEGORY, Context.MODE_PRIVATE)

        return if (pref.contains(KEY_CURRENT_AREA_IDS)) {
            val ids = pref.getString(KEY_CURRENT_AREA_IDS, "")!!.split(",")

            ids.mapNotNull { stringId ->
                InterestCategory.values().firstOrNull { it.id == stringId.toInt() }
            }

        } else {
            null
        }

    }
}