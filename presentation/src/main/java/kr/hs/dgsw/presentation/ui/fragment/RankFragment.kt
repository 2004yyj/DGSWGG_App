package kr.hs.dgsw.presentation.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import kr.hs.dgsw.presentation.databinding.FragmentRankBinding
import kr.hs.dgsw.presentation.ui.viewmodel.RankViewModel
import kr.hs.dgsw.presentation.util.bindings

class RankFragment : Fragment() {

    private val viewModel: RankViewModel by viewModels()
    private val binding: FragmentRankBinding by bindings(FragmentRankBinding::inflate)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

}