package com.kkh.clean_architecture_sample.base

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    private lateinit var baseViewModel: BaseViewModel

    abstract fun createActivity(): BaseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        baseViewModel = createActivity()
        baseViewModel.showToast.observe(this) { message ->
            Toast.makeText(this@BaseActivity, message, Toast.LENGTH_SHORT).show()
        }
    }
}