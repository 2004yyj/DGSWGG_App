package kr.hs.dgsw.presentation.util

import com.google.android.material.appbar.AppBarLayout
import kotlin.math.abs

class OnOffsetChangedStateListener(private val onChangedState: (offsetState: OffsetState) -> Unit): AppBarLayout.OnOffsetChangedListener {

    enum class OffsetState {
        EXPANDED, COLLAPSED
    }

    override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
        var state = OffsetState.COLLAPSED
        if (((abs(verticalOffset).toFloat() / appBarLayout?.totalScrollRange!!.toFloat()) * 100) >= 80) {
            state = if (state == OffsetState.EXPANDED) {
                OffsetState.COLLAPSED
            } else {
                OffsetState.EXPANDED
            }
        }
        onChangedState(state)
    }
}