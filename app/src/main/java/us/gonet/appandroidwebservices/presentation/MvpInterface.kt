package us.gonet.appandroidwebservices.presentation

import us.gonet.appandroidwebservices.data.models.ModelCrime

interface MvpInterface {

    interface View{
        fun showDataListRecyclerView(list:ArrayList<ModelCrime>)
        fun showProgressBar()
        fun showToast()
        fun hideProgressBar()
    }

    interface Presenter{
        fun handlePetition()
    }

    interface Model

}