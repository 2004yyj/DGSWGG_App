package kr.hs.dgsw.presentation.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import kr.hs.dgsw.presentation.databinding.FragmentSetupBinding
import kr.hs.dgsw.presentation.ui.viewmodel.SetupViewModel
import kr.hs.dgsw.presentation.util.bindings

class SetupFragment : Fragment() {

    private val viewModel: SetupViewModel by viewModels()
    private val binding: FragmentSetupBinding by bindings(FragmentSetupBinding::inflate)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

}