package com.roque.rueda.soralgorithms

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commitNow
import com.roque.rueda.soralgorithms.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.commitNow {
                replace(R.id.container, MainFragment.newInstance())
            }
        }
    }
}
