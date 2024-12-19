package kr.hs.dgsw.presentation.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kr.hs.dgsw.presentation.databinding.ActivityMainBinding
import kr.hs.dgsw.presentation.ui.navigation.setupWithNavControllerCustomAnim
import kr.hs.dgsw.presentation.util.bindings

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by bindings(ActivityMainBinding::inflate)
    private lateinit var navController: NavController
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var navHostFragment: FragmentContainerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(binding.root)

        bottomNavigationView = binding.bnvMain
        navHostFragment = binding.fragmentNavMainHost
    }

    override fun onStart() {
        super.onStart()

        navController = navHostFragment.findNavController()
        bottomNavigationView.setupWithNavControllerCustomAnim(this, navController)
    }
}