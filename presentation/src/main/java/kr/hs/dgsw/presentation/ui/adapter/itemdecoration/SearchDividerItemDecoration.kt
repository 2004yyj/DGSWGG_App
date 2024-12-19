package kr.hs.dgsw.presentation.ui.adapter.itemdecoration

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.recyclerview.widget.RecyclerView
import kr.hs.dgsw.presentation.util.dp

class SearchDividerItemDecoration(private val color: Color, private val margin: Int) : RecyclerView.ItemDecoration() {
    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)

        val paint = Paint().apply {
            color = this@SearchDividerItemDecoration.color.toArgb()
        }
        val height = 1.dp

        for (i in 1 until parent.childCount - 1) {
            val child = parent.getChildAt(i)
            if (i != parent.childCount - 1) {

                c.drawRect(child.left.toFloat() + margin, child.bottom.toFloat(), child.right.toFloat() - margin, child.bottom.toFloat() + height, paint)
            }
        }
    }
}