package com.google.vitaly.mvpapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.vitaly.mvpapp.mvp.model.CountersModel
import com.google.vitaly.mvpapp.mvp.presenter.MainPresenter
import com.google.vitaly.mvpapp.mvp.view.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {
    val presenter = MainPresenter(this, CountersModel())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setClickListeners()
    }

    private fun setClickListeners() {
        btn_counter1.setOnClickListener { presenter.handlerBtn1() }
        btn_counter2.setOnClickListener { presenter.handlerBtn2() }
        btn_counter3.setOnClickListener { presenter.handlerBtn3() }
    }

    override fun setButtonText(index: Int, text: String) {
        when(index){
            0 -> btn_counter1.text = text
            1 -> btn_counter2.text = text
            2 -> btn_counter3.text = text
        }
    }
}
