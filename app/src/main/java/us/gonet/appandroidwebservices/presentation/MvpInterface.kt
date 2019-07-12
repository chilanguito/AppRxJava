package us.gonet.appandroidwebservices.presentation

import android.content.Context
import us.gonet.appandroidwebservices.data.models.ModelCrime

interface MvpInterface {

    interface View{
        fun showDataListRecyclerView(lista:ArrayList<ModelCrime>)
        fun showProgressDialog()

    }

    interface Presenter

    interface Model

    interface BaseView{

         fun getContext(): Context

         fun showSnackBar(message: String, duration: Int)

         fun showToast(message: String, duration: Int)

         fun showProgressDialog(message: String, cancelable: Boolean)

         fun dismissProgressDialog()
    }

}