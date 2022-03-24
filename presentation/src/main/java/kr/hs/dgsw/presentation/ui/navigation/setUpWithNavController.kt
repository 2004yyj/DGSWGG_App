package kr.hs.dgsw.presentation.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.google.android.material.bottomnavigation.BottomNavigationView
import kr.hs.dgsw.presentation.R

fun BottomNavigationView.setupWithNavControllerCustomAnim(navController: NavController) {
    val navOptionsBackAnim = NavOptions.Builder()
        .setLaunchSingleTop(true)
        .setEnterAnim(R.anim.slide_in_left)
        .setExitAnim(R.anim.slide_out_right)
        .setPopEnterAnim(R.anim.slide_in_left)
        .setPopExitAnim(R.anim.slide_out_right)
        .build()

    val navOptionsNextAnim = NavOptions.Builder()
        .setLaunchSingleTop(true)
        .setEnterAnim(R.anim.slide_in_right)
        .setExitAnim(R.anim.slide_out_left)
        .setPopEnterAnim(R.anim.slide_in_right)
        .setPopExitAnim(R.anim.slide_out_left)
        .build()

    var itemId = selectedItemId

    setOnItemSelectedListener {
        if (navController.graph.findNode(it.itemId) != null) {
            if (it.itemId > itemId) {
                navController.navigate(it.itemId, null, navOptionsNextAnim)
            } else {
                navController.navigate(it.itemId, null, navOptionsBackAnim)
            }
        }
        itemId = it.itemId
        true
    }
}