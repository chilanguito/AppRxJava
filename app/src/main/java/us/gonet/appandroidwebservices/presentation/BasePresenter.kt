package us.gonet.appandroidwebservices.presentation

import io.reactivex.android.schedulers.AndroidSchedulers
import rx.Observable
import rx.Subscriber
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription

import us.gonet.appandroidwebservices.data.ApiService

class BasePresenter<V : MvpInterface.BaseView> {

    private lateinit var view : MvpInterface.View
    private var compositeSubscription: CompositeSubscription? = null
    private var subscriber: Subscriber<*>? = null


    fun dettachView() {
        if (compositeSubscription != null && compositeSubscription!!.hasSubscriptions()) {
            compositeSubscription!!.unsubscribe()
        }
    }

    protected fun onSubscribe(observable: Observable<*>, subscriber: Subscriber<*>) {
        this.subscriber = subscriber

        if (compositeSubscription == null) {
            compositeSubscription = CompositeSubscription()
        }


        compositeSubscription!!.add(
            observable
                .subscribeOn(Schedulers.io())
                .observeOn( AndroidSchedulers.mainThread() as rx.Scheduler)
                .subscribe())
        //no se ha suscrito
    }

    protected fun unSubscribe() {
        if (subscriber != null) {
            subscriber!!.unsubscribe()
        }
    }
}
