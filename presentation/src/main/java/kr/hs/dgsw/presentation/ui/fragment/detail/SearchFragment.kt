package kr.hs.dgsw.presentation.ui.fragment.detail

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.getColor
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kr.hs.dgsw.presentation.R
import kr.hs.dgsw.presentation.databinding.FragmentSearchBinding
import kr.hs.dgsw.presentation.ui.adapter.SearchHistoryAdapter
import kr.hs.dgsw.presentation.ui.adapter.itemdecoration.SearchDividerItemDecoration
import kr.hs.dgsw.presentation.ui.viewmodel.DetailViewModel
import kr.hs.dgsw.presentation.ui.viewmodel.SearchViewModel
import kr.hs.dgsw.presentation.util.EventObserver
import kr.hs.dgsw.presentation.util.bindings
import kr.hs.dgsw.presentation.util.dp

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private val searchHistoryAdapter by lazy { SearchHistoryAdapter() }
    private val binding: FragmentSearchBinding by bindings(FragmentSearchBinding::inflate)
    private val activityViewModel: DetailViewModel by activityViewModels()
    private val viewModel: SearchViewModel by viewModels()
    private val navController: NavController by lazy { findNavController() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding.vm = viewModel
        binding.activityVm = activityViewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        listener()
        observe()
        flow()
    }

    private fun flow() {
        lifecycleScope.launch {
            searchHistoryAdapter.loadStateFlow
                .collect {
                    binding.rvHistorySearch.smoothScrollToPosition(0)
                    if (it.source.refresh is LoadState.NotLoading && searchHistoryAdapter.itemCount <= 1) {
                        binding.rvHistorySearch.visibility = View.GONE
                        binding.tvHistoryNothingItemSearch.visibility = View.VISIBLE
                    } else {
                        binding.rvHistorySearch.visibility = View.VISIBLE
                        binding.tvHistoryNothingItemSearch.visibility = View.GONE
                    }
                }
        }
    }

    private fun init() {
        binding.vm = viewModel
        viewModel.getAllSearch()
        binding.rvHistorySearch.adapter = searchHistoryAdapter
        binding.rvHistorySearch.addItemDecoration(
            SearchDividerItemDecoration(
                Color.valueOf(getColor(requireContext(), R.color.line)),
                15.dp
            )
        )
    }

    private fun listener() {
        searchHistoryAdapter.onClickDeleteSearch = {
            viewModel.deleteSearch(it)
        }

        searchHistoryAdapter.onClickDeleteAllSearch = {
            viewModel.deleteAllSearch()
        }

        searchHistoryAdapter.onClickItem = {
            activityViewModel.getSummoner(it)
        }
    }

    private fun observe() {
        viewModel.searchList.observe(viewLifecycleOwner) {
            searchHistoryAdapter.submitData(lifecycle, it)
        } // 검색 히스토리 가져오기
        viewModel.eventRefresh.observe(viewLifecycleOwner) {
            searchHistoryAdapter.refresh()
        } // Reload 이벤트
        activityViewModel.eventSummoner.observe(viewLifecycleOwner, EventObserver {
            viewModel.searchText.set("")
            navController.navigate(R.id.action_searchFragment_to_summonerFragment)
        }) // 검색 성공 이벤트
        viewModel.eventFinishActivity.observe(viewLifecycleOwner) {
            requireActivity().finish()
        } // 종료 이벤트
        activityViewModel.eventFailure.observe(viewLifecycleOwner, EventObserver {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }) // 검색 실패 이벤트
    }
}