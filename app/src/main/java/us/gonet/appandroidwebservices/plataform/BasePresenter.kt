package us.gonet.appandroidwebservices.plataform

import android.annotation.SuppressLint
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import rx.Subscriber
import us.gonet.appandroidwebservices.data.ClientRetrofitService
import us.gonet.appandroidwebservices.data.models.ModelCrime
import us.gonet.appandroidwebservices.presentation.MvpInterface

class BasePresenter<V : MvpInterface.BaseView>(private var view:MvpInterface.View) {

    private var subscriber: Subscriber<*>? = null
    private var disposable: CompositeDisposable? = CompositeDisposable()

    @Suppress("UNCHECKED_CAST")
    @SuppressLint("CheckResult")
    fun onSubscribe() {
        val petition = ClientRetrofitService.obtenerListaRx()
        disposable?.add(petition.getListService()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe {
                Log.d("Llave", it.toString())
                view.showDataListRecyclerView(it as ArrayList<ModelCrime>)
            })

    }

    private fun handleResponse(list: ArrayList<ModelCrime>) {
        view.showDataListRecyclerView(list)
    }

    private fun handleError(t: Throwable) {
        t.printStackTrace()
    }

    protected fun unSubscribe() {
        if (subscriber != null) {
            subscriber!!.unsubscribe()
        }
    }
}
