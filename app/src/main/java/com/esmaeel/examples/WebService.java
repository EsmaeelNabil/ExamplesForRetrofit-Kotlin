package com.esmaeel.examples;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WebService {

    @GET("posts")
    Call<ArrayList<Post>> getPosts();


    @GET("comments")
    Call<ArrayList<CommentResponse>> getComments();

}