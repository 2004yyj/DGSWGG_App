package kr.hs.dgsw.presentation.ui.adapter.viewholder.summoner

import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.recyclerview.widget.RecyclerView
import kr.hs.dgsw.domain.entity.summoner.Rank
import kr.hs.dgsw.presentation.R
import kr.hs.dgsw.presentation.databinding.ItemSummonerRankBinding

class SummonerRankViewHolder(
    private val binding: ItemSummonerRankBinding
): RecyclerView.ViewHolder(binding.root) {
    fun bind(rank: Rank) {
        with(rank) {
            binding.rank = rank
            binding.tvRankTypeSummonerRank.text =
                itemView.resources.getString(
                    if (rank.queueType == "SOLO")
                        R.string.SOLO
                    else
                        R.string.FLEX
                )
            binding.ivRankSummonerRank.setImageDrawable(
                getDrawable(itemView.context, RankImage.valueOf(rank.tier).imageResource)
            )
        }
    }
}

enum class RankImage(val imageResource: Int) {
    Unranked(R.drawable.ic_unranked),
    Iron(R.drawable.ic_iron),
    Bronze(R.drawable.ic_bronze),
    Silver(R.drawable.ic_silver),
    Gold(R.drawable.ic_gold),
    Platinum(R.drawable.ic_platinum),
    Diamond(R.drawable.ic_diamond),
    Master(R.drawable.ic_master),
    GrandMaster(R.drawable.ic_grand_master),
    Challenger(R.drawable.ic_challenger)
}