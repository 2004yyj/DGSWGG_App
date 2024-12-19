package kr.hs.dgsw.presentation.ui.adapter.itemdecoration

import android.graphics.Canvas
import android.graphics.Rect
import android.view.View
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import kr.hs.dgsw.presentation.util.dp

class RankMarginItemDecoration(private val margin: Int): RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)

        with(outRect) {
            if (parent.getChildAdapterPosition(view) == 0) {
                left = 20.dp
                right = margin.dp
            } else if (parent.getChildAdapterPosition(view) == parent.childCount - 1) {
                left = margin.dp
                right = 20.dp
            } else {
                left = margin.dp
                right = margin.dp
            }
        }
    }
}