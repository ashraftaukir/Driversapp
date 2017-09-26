package com.webxzen.driversapp.api;

import com.webxzen.driversapp.model.ProfileResponseModel;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by behestee on 9/22/17.
 */

public interface MyProfileAPI {

    @FormUrlEncoded
    @POST("api/v1/rider/me")
    Call<ProfileResponseModel> getProfile(
            @Header("X-ACCESS-TOKEN") String token
    );



}
