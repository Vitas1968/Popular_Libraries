package com.google.vitaly.mvpapp.mvp.presenter

import com.google.vitaly.mvpapp.mvp.model.CountersModel
import com.google.vitaly.mvpapp.mvp.view.MainView

class MainPresenter(val view: MainView, val model: CountersModel){

    fun handlerBtn1(){
        counterClick(0)
    }

    fun handlerBtn2(){
        counterClick(1)
    }

    fun handlerBtn3(){
        counterClick(2)
    }

   private fun counterClick(idx: Int){
        val nextValue = model.next(idx)
        view.setButtonText(idx, nextValue.toString())
    }
}