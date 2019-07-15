package us.gonet.appandroidwebservices.presentation

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import us.gonet.appandroidwebservices.data.ClientRetrofitService
import us.gonet.appandroidwebservices.data.models.ModelCrime

class BasePresenter(private var view: MvpInterface.View) : MvpInterface.Presenter {

    override fun handlePetition() {
        view.showProgressBar()
        val disposable = CompositeDisposable()
        val petition = ClientRetrofitService.getListRxWS()
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
                    view.hideProgressBar()
                }

                override fun onError(e: Throwable) {
                    Log.e("ERROR", e.stackTrace.toString())
                }

            })
        )
    }
}
