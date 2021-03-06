package com.webxzen.driversapp.api;

import com.webxzen.driversapp.model.AuthModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;


public interface AuthAPI {

    @FormUrlEncoded
    @POST("api/auth/signup/driver")
    Call<AuthModel> register(
            @Field("full_name") String fullname,
            @Field("email") String email,
            @Field("password") String password,
            @Field("mobile") String platform,
            @Field("device_token") String deviceToken
    );

    @FormUrlEncoded
    @POST("api/auth/email")
    Call<AuthModel> emaillogin(
            @Field("client_id") String clientId,
            @Field("client_secret") String clientSecret,
            @Field("scope") String scope,
            @Field("platform") String platform,
            @Field("device_token") String deviceToken,
            @Field("email") String email,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("api/auth/phone")
    Call<AuthModel> phonelogin(
            @Field("client_id") String clientId,
            @Field("client_secret") String clientSecret,
            @Field("scope") String scope,
            @Field("platform") String platform,
            @Field("device_token") String deviceToken,
            @Field("username") String email,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("api/auth/facebook")
    Call<AuthModel> fblogin(
            @Field("client_id") String clientId,
            @Field("client_secret") String clientSecret,
            @Field("scope") String scope,
            @Field("fb_access_token") String fbAccesToken,
            @Field("platform") String platform,
            @Field("device_token") String deviceToken
    );

    @FormUrlEncoded
    @POST("api/v1/logout")
    Call<AuthModel> logout(
            @Header("X-ACCESS-TOKEN") String token
    );

    @FormUrlEncoded
    @POST("api/auth/forget")
    Call<AuthModel> forgetPassword(
            @Field("emailOrMobile") String emailOrMobile


    );

}
