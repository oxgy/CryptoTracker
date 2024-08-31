package com.oxxy.cryptotracker.service

import com.oxxy.cryptotracker.model.CryptoModel
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

interface CryptoAPI {

    @GET("atilsamancioglu/K21-JSONDataSet/master/crypto.json")

    fun getData(): Observable<List<CryptoModel>>
    //fun getData(): Call<List<CryptoModel>>

}