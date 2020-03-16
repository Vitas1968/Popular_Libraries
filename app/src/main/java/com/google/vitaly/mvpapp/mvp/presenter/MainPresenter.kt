package com.google.vitaly.mvpapp.mvp.presenter

import com.google.vitaly.mvpapp.mvp.model.CountersModel
import com.google.vitaly.mvpapp.mvp.model.IGetBtnFromResources
import com.google.vitaly.mvpapp.mvp.view.MainView

class MainPresenter(var view: MainView?, private val model: CountersModel, private val button: IGetBtnFromResources): IMainPresenter {

    fun counterClick(id: Int){
        var index=button.getBtnById(id)
        if(index >= 0) {
            when (index) {
                0 -> updateBtnText(0)
                1 -> updateBtnText(1)
                2 -> updateBtnText(2)
            }
        }
    }

    private fun updateBtnText(index:Int) {
        val nextValue = model.next(index)
        view?.let {
            it.setButtonText(index, nextValue.toString()) }
    }

    override fun detachView() {
        view=null
    }
}