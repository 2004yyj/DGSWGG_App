package kr.hs.dgsw.presentation.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.presentation.databinding.ActivityDetailBinding
import kr.hs.dgsw.presentation.ui.viewmodel.DetailViewModel
import kr.hs.dgsw.presentation.util.bindings

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    private val binding: ActivityDetailBinding by bindings(ActivityDetailBinding::inflate)
    private val viewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}