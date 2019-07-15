package us.gonet.appandroidwebservices.plataform

import android.annotation.SuppressLint
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import us.gonet.appandroidwebservices.data.ClientRetrofitService
import us.gonet.appandroidwebservices.data.models.ModelCrime
import us.gonet.appandroidwebservices.presentation.MvpInterface

class BasePresenter(private var view: MvpInterface.View) {

    @Suppress("UNCHECKED_CAST")
    @SuppressLint("CheckResult")
    fun onSubscribe() {
        handlePetition()
    }

    private fun handlePetition() {
        val disposable = CompositeDisposable()
        val petition = ClientRetrofitService.obtenerListaRx()
        disposable.add(petition.getListService()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribeWith(object : DisposableObserver<ArrayList<ModelCrime>>() {
                override fun onComplete() {
                    view.showToast()
                }

                override fun onNext(t: ArrayList<ModelCrime>) {
                    view.showDataListRecyclerView(t)
                    Log.d("RESPONSE", t.toString())
                }

                override fun onError(e: Throwable) {
                    Log.e("ERROR", e.stackTrace.toString())
                }

            })
        )
    }
}
