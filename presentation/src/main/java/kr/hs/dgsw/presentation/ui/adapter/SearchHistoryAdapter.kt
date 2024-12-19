package kr.hs.dgsw.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kr.hs.dgsw.presentation.databinding.HeaderSearchBinding
import kr.hs.dgsw.presentation.databinding.ItemSearchBinding
import kr.hs.dgsw.presentation.ui.adapter.viewholder.search.SearchHeaderViewHolder
import kr.hs.dgsw.presentation.ui.adapter.viewholder.search.SearchItemViewHolder
import kr.hs.dgsw.presentation.ui.uimodel.SearchUIModel
import java.lang.ClassCastException

class SearchHistoryAdapter: PagingDataAdapter<SearchUIModel, RecyclerView.ViewHolder>(diffUtil) {

    lateinit var onClickDeleteAllSearch: () -> Unit
    lateinit var onClickDeleteSearch: (Long) -> Unit
    lateinit var onClickItem: (name: String) -> Unit

    override fun getItemViewType(position: Int): Int {
        return when(getItem(position)) {
            is SearchUIModel.Header -> SEARCH_HEADER
            is SearchUIModel.SearchModel -> SEARCH_ITEM
            else -> throw ClassCastException()
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        getItem(position)?.let {
            when(holder) {
                is SearchHeaderViewHolder ->
                    holder.bind(onClickDeleteAllSearch)
                is SearchItemViewHolder ->
                    holder.bind(getItem(position) as SearchUIModel.SearchModel, onClickItem, onClickDeleteSearch)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            SEARCH_HEADER -> {
                SearchHeaderViewHolder(
                    HeaderSearchBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            SEARCH_ITEM -> {
                SearchItemViewHolder(
                    ItemSearchBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            else -> throw ClassCastException()
        }
    }

    companion object {
        const val SEARCH_HEADER = 0
        const val SEARCH_ITEM = 1
        private val diffUtil = object: DiffUtil.ItemCallback<SearchUIModel>() {
            override fun areItemsTheSame(oldItem: SearchUIModel, newItem: SearchUIModel): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: SearchUIModel, newItem: SearchUIModel): Boolean {
                return oldItem == newItem
            }

        }
    }
}