package com.gibaram.mvvm2nd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.gibaram.mvvm2nd.databinding.ActivityMainBinding
import com.gibaram.mvvm2nd.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // View Model 생성 (취득)
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)


        // this.setContentView 대신 DataBindingUtil.setContentView 사용
        //  setContentView(R.layout.activity_main)
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)?.apply {
            this.lifecycleOwner = this@MainActivity // 중요.. 데이터 변경 Observe
            this.setVariable(BR.viewmodel, viewModel) // BR ???
        }
    }
}