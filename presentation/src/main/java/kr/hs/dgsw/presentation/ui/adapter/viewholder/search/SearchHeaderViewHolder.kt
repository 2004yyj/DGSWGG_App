package kr.hs.dgsw.presentation.ui.adapter.viewholder.search

import androidx.recyclerview.widget.RecyclerView
import kr.hs.dgsw.presentation.databinding.HeaderSearchBinding

class SearchHeaderViewHolder(
    private val binding: HeaderSearchBinding,
): RecyclerView.ViewHolder(binding.root) {
    fun bind(onClickDeleteAllSearch: () -> Unit) {
        binding.tvDeleteAllHeaderSearch.setOnClickListener {
            onClickDeleteAllSearch.invoke()
        }
    }
}