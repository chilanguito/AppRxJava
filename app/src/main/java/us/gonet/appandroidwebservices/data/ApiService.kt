package us.gonet.appandroidwebservices.data

import io.reactivex.Observable
import retrofit2.http.GET
import us.gonet.appandroidwebservices.data.models.ModelCrime

interface ApiService {

    @GET("/api/stops-at-location?location_id=883407&date=2018-08")
    fun getListService(): Observable<ArrayList<ModelCrime>>

}