package kr.hs.dgsw.presentation.ui.fragment.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.core.graphics.drawable.DrawableCompat
import androidx.fragment.app.activityViewModels
import kr.hs.dgsw.presentation.R
import kr.hs.dgsw.presentation.ui.viewmodel.DetailViewModel
import kr.hs.dgsw.presentation.databinding.FragmentSummonerBinding
import kr.hs.dgsw.presentation.util.OnOffsetChangedStateListener
import kr.hs.dgsw.presentation.util.OnOffsetChangedStateListener.OffsetState
import kr.hs.dgsw.presentation.util.bindings
import kotlin.math.abs

class SummonerFragment : Fragment() {

    private val binding: FragmentSummonerBinding by bindings(FragmentSummonerBinding::inflate)
    private val activityViewModel: DetailViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding.activityVm = activityViewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activityViewModel.eventSummoner.observe(viewLifecycleOwner) {
            binding.summoner = it.peekContent()
        }

        binding.appBarLayoutSummoner.addOnOffsetChangedListener(
            OnOffsetChangedStateListener {
                binding.toolbarSummoner.run {
                    navigationIcon = when(it) {
                        OffsetState.COLLAPSED -> getDrawable(context, R.drawable.ic_arrow_dark)
                        OffsetState.EXPANDED -> getDrawable(context, R.drawable.ic_arrow_light)
                    }
                }

            }
        )
    }


}