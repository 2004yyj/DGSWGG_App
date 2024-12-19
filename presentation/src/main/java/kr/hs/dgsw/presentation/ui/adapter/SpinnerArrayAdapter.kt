package kr.hs.dgsw.presentation.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.annotation.ArrayRes
import androidx.annotation.LayoutRes
import kr.hs.dgsw.presentation.databinding.DisabledSpinnerDropdownItemBinding

class SpinnerArrayAdapter(
    context: Context,
    @LayoutRes resourceId: Int,
    @ArrayRes arrayId: Int
): ArrayAdapter<String>(context, resourceId, context.resources.getStringArray(arrayId)) {
    override fun isEnabled(position: Int): Boolean {
        return position != 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        if (position == 0) {
            val context = parent.context
            val firstItem = DisabledSpinnerDropdownItemBinding
                .inflate(LayoutInflater.from(context), parent, false)
            firstItem.text1.text = getItem(position)
            return firstItem.root
        }

        return super.getView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        if (position == 0) {
            val context = parent.context
            val firstItem = DisabledSpinnerDropdownItemBinding
                .inflate(LayoutInflater.from(context), parent, false)
            firstItem.text1.text = getItem(position)
            return firstItem.root
        }
        return super.getDropDownView(position, convertView, parent)
    }
}