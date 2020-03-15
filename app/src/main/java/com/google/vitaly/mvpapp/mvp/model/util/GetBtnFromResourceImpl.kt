package com.google.vitaly.mvpapp.mvp.model.util

import android.content.Context
import com.google.vitaly.mvpapp.R
import com.google.vitaly.mvpapp.mvp.presenter.IGetBtnFromResources

class GetBtnFromResourceImpl: IGetBtnFromResources {
    override fun getBtnById(id: Int): Int {
        return when(id){
            R.id.btn_counter1 -> 0
            R.id.btn_counter2 -> 1
            R.id.btn_counter3 -> 2
            else -> -1
        }
    }
}