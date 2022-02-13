package dmitriy.ten.testtask

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface Api {

    @GET("random")
    fun random(
        @Query("api_key") api_key: String, // api_key
        @Query("rating") rating: String, // rating
    ): Single<GiphyJsonData>

}
