package kr.hs.dgsw.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import kr.hs.dgsw.domain.entity.summoner.Rank
import kr.hs.dgsw.presentation.databinding.ItemSummonerRankBinding
import kr.hs.dgsw.presentation.ui.adapter.viewholder.summoner.SummonerRankViewHolder

class SummonerRankAdapter: ListAdapter<Rank, SummonerRankViewHolder>(diffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SummonerRankViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SummonerRankViewHolder(ItemSummonerRankBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: SummonerRankViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val diffUtil = object: DiffUtil.ItemCallback<Rank>() {
            override fun areItemsTheSame(oldItem: Rank, newItem: Rank): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Rank, newItem: Rank): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}