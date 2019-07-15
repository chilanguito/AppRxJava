package us.gonet.appandroidwebservices.data

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ClientRetrofitService {

    fun getListRxWS(): ApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://data.police.uk/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(ApiService::class.java)
    }
}