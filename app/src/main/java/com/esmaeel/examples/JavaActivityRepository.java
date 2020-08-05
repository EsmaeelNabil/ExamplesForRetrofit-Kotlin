package com.esmaeel.examples;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JavaActivityRepository {
    WebService webService;

    public JavaActivityRepository(WebService mservice) {
        this.webService = mservice;
    }

    // bac practice -> break single responsibility Principle
    public JavaActivityRepository() {
        this.webService = new ApiManager().getMyService();
    }

    public void getPostsWithCallBack(PostsCallBack callBack) {

        webService.getPosts().enqueue(new Callback<ArrayList<Post>>() {
            @Override
            public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
                if (response.isSuccessful()) {
                    // status code 200

                    ArrayList<Post> posts = new ArrayList<>();

                    // getting the response body "Out expected model" -> ArrayList<Post>
                    // return it to the Activity or Fragment (View)
                    callBack.onSuccess(response.body());


                } else {
                    // status is not between 200 and 299
                    // say 404 for example
                    // server has responded but with error status code
                    try {
                        String error = response.errorBody().string();
                        callBack.onError(error);
                    } catch (Exception e) {

                    }

                }
            }

            @Override
            public void onFailure(Call<ArrayList<Post>> call, Throwable t) {
                callBack.onError(t.getMessage());
            }
        });

    }

}
