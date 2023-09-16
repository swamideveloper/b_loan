package com.gopal.fast.vid.ads.client;

import com.gopal.fast.vid.ads.client.ResModel.MainResModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    @GET("getApps/gopal/pancard_loan/V5STB3790TVEY/api_v2.json")
    Call<MainResModel> doGetListData();

}
