package com.aswin.transactionsapp.api;

import com.aswin.transactionsapp.model.TransactionsListResponsePojo;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface ApiInterface {

    @POST("transactions.php")
    Call<TransactionsListResponsePojo> transactionsList(@Body RequestBody accessTokenValue);

}