package com.google.vitaly.mvpapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.vitaly.mvpapp.R
import com.google.vitaly.mvpapp.mvp.model.CountersModel
import com.google.vitaly.mvpapp.mvp.model.util.GetBtnFromResourceImpl
import com.google.vitaly.mvpapp.mvp.presenter.MainPresenter
import com.google.vitaly.mvpapp.mvp.view.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {
    private val presenter = MainPresenter(this, CountersModel(), GetBtnFromResourceImpl())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listener =crateListener()

        setListener(listener)
    }

    private fun setListener(listener: View.OnClickListener) {
        btn_counter1.setOnClickListener(listener)
        btn_counter2.setOnClickListener(listener)
        btn_counter3.setOnClickListener(listener)
    }

    private fun crateListener() = View.OnClickListener {
        presenter.counterClick(it.id)
    }

    override fun setButtonText(index: Int, text: String) {
        when(index){
            0 -> btn_counter1.text = text
            1 -> btn_counter2.text = text
            2 -> btn_counter3.text = text
        }
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }
}
