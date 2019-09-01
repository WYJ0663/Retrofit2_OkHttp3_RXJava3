package com.example.blankapp;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface PersonalProtocol {
    /**
     * 用户信息
     * @param page
     * @return
     */
    @FormUrlEncoded
    @POST("user/personal_list_info")
    Call<String> getPersonalListInfo(@Field("cur_page") int page);
}