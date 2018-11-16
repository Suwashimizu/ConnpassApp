package org.suwashizmu.connpassapp.view

import com.orhanobut.logger.Logger

/**
 * Created by KEKE on 2018/10/17.
 *
 * 要素の最後までロードするとcallbackを返します
 */
class LoadMoreListener(private val onLoadMoreListener: () -> Unit) : androidx.recyclerview.widget.RecyclerView.OnScrollListener() {

    var isLoading = false
    private val visibleThreshold = 1

    override fun onScrolled(recyclerView: androidx.recyclerview.widget.RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val lm = recyclerView.layoutManager as? androidx.recyclerview.widget.LinearLayoutManager
                ?: return

        val totalItemCount = lm.itemCount
        val lastVisibleItem = lm.findLastVisibleItemPosition()

        if (isLoading.not() && totalItemCount <= (lastVisibleItem + visibleThreshold)) {
            onLoadMoreListener()
            isLoading = true

            Logger.d("change Loading:$isLoading")
        }
    }
}