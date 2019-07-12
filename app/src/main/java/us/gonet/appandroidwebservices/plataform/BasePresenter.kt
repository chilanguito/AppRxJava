package us.gonet.appandroidwebservices.plataform

import android.annotation.SuppressLint
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import rx.Subscriber
import rx.subscriptions.CompositeSubscription
import us.gonet.appandroidwebservices.data.ClientRetrofitService
import us.gonet.appandroidwebservices.data.models.ModelCrime
import us.gonet.appandroidwebservices.presentation.MvpInterface


class BasePresenter<V : MvpInterface.BaseView> {

    private lateinit var view :MvpInterface.View
    private var compositeSubscription: CompositeSubscription? = null
    private var subscriber: Subscriber<*>? = null
    var disposable: CompositeDisposable? = CompositeDisposable()

    @Suppress("UNCHECKED_CAST")
    @SuppressLint("CheckResult")
     fun onSubscribe() {
        val peticion= ClientRetrofitService.obtenerListaRx()
      disposable?.add(peticion.getListService()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
           // .subscribe(this::handleResponse as Consumer<in ModelCrime>,this::handleError as Consumer<in Throwable>))
          .subscribe {
             Log.d("Llave", it.toString())
          })

    }

    private fun handleResponse(list:ArrayList<ModelCrime>){
            view.showDataListRecyclerView(list)
    }

    private fun handleError(t:Throwable) {
        t.printStackTrace()
    }
    protected fun unSubscribe() {
        if (subscriber != null) {
            subscriber!!.unsubscribe()
        }
    }
}
