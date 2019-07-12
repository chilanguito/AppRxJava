package us.gonet.appandroidwebservices.data

import retrofit2.HttpException
import rx.Subscriber

abstract class RequestCallback<M> : Subscriber<M>() {

    abstract fun onRequestSuccess(model: M)
    abstract fun onRequestFailure(message: String)
    abstract fun onRequestCompleted()

    override fun onCompleted() {
        onRequestCompleted()
    }

    override fun onError(e: Throwable) {
        var message = e.message
        if (e is HttpException) {
            message = e.message
        }
        onRequestFailure(message!!)
        onRequestCompleted()
    }

    override fun onNext(m: M) {
        onRequestSuccess(m)
        onRequestCompleted()
    }
}