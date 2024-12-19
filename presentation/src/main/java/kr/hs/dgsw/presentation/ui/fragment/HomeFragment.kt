package kr.hs.dgsw.presentation.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import kr.hs.dgsw.presentation.databinding.FragmentHomeBinding
import kr.hs.dgsw.presentation.ui.activity.DetailActivity
import kr.hs.dgsw.presentation.ui.activity.RefreshSummonerActivity
import kr.hs.dgsw.presentation.ui.viewmodel.HomeViewModel
import kr.hs.dgsw.presentation.util.bindings

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()
    private val binding: FragmentHomeBinding by bindings(FragmentHomeBinding::inflate)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding.vm = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.searchBtn.observe(viewLifecycleOwner) {
            val intent = Intent(requireActivity(), DetailActivity::class.java)
            startActivity(intent)
        }

        viewModel.refreshSummonerBtn.observe(viewLifecycleOwner) {
            val intent = Intent(requireActivity(), RefreshSummonerActivity::class.java)
            startActivity(intent)
        }
    }

}