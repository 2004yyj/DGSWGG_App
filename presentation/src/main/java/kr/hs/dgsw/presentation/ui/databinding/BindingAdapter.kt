package kr.hs.dgsw.presentation.ui.databinding

import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.AdapterView
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import androidx.appcompat.widget.Toolbar
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import coil.load
import kr.hs.dgsw.presentation.ui.adapter.SpinnerArrayAdapter

@BindingAdapter("android:onEditorAction")
fun EditText.onEditorAction(onEditorAction: () -> Unit) {
    this.setOnEditorActionListener { v, actionId, event ->
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            onEditorAction()
        }
        false
    }
}

@BindingAdapter("android:onClickNavigation")
fun Toolbar.onClickNavigation(onClickNavigation: () -> Unit) {
    this.setNavigationOnClickListener {
        onClickNavigation()
    }
}

@BindingAdapter("android:image")
fun ImageView.loadImage(url: Any) {
    load(url)
}

@InverseBindingAdapter(attribute = "android:entry")
fun Spinner.getEntryString(): Int {
    val adapter = adapter as SpinnerArrayAdapter
    return adapter.getPosition(selectedItem as String)
}

@BindingAdapter("android:entryAttrChanged")
fun Spinner.setListener(entryAttrChanged: InverseBindingListener) {
    onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(parent: AdapterView<*>?) { }
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            entryAttrChanged.onChange()
        }
    }
}

@BindingAdapter("android:entry")
fun Spinner.setEntryString(selectedPosition: Int) {
    setSelection(selectedPosition)
}