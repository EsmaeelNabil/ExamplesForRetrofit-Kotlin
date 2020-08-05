package com.esmaeel.examples;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class JavaActivity extends AppCompatActivity {

    // Base Url
    private static final String TAG = "JavaActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);


        // 1- Retrofit
        // 2- WebService 'Interface' -> declare out Api EndPoints



/*
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostsWebService myService = retrofit.create(PostsWebService.class);

        Call<ArrayList<Post>> postsCall = myService.getPosts();

        postsCall.enqueue(new Callback<ArrayList<Post>>() {
            @Override
            public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
                if (response.isSuccessful()) {
                    // status code 200

                    ArrayList<Post> posts = new ArrayList<>();

                    // getting the response body "Out expected model" -> ArrayList<Post>
                    posts = response.body();


                    // print the body
                    for (Post post : posts) {
                        Log.e(TAG, "onResponse: " + post.body);
                    }


                } else {
                    // status is not between 200 and 299
                    // say 404 for example
                    // server has responded but with error status code
                    try {
                        String error = response.errorBody().string();
                        Log.e(TAG, "onErrorBody: " + error);
                    } catch (Exception e) {
                        Log.e(TAG, "onErrorBody: " + e.getMessage());
                    }

                }
            }

            @Override
            public void onFailure(Call<ArrayList<Post>> call, Throwable t) {
                // it gets called when -> Network Error
                // it gets called when -> TimeOut Exception -> Laggy Network

                Log.e(TAG, "onFailure: " + t.getMessage());

            }
        });
*/



        /*------------------------------------------------------------ optimized ----------------------------------- */
/*
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostsWebService myService = retrofit.create(PostsWebService.class);

        myService.getPosts().enqueue(new Callback<ArrayList<Post>>() {
            @Override
            public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
                if (response.isSuccessful()) {
                    // status code 200

                    ArrayList<Post> posts = new ArrayList<>();

                    // getting the response body "Out expected model" -> ArrayList<Post>
                    posts = response.body();


                    // print the body
                    for (Post post : posts) {
                        Log.e(TAG, "onResponse: " + post.body);
                    }


                } else {
                    // status is not between 200 and 299
                    // say 404 for example
                    // server has responded but with error status code
                    try {
                        String error = response.errorBody().string();
                        Log.e(TAG, "onErrorBody: " + error);
                    } catch (Exception e) {
                        Log.e(TAG, "onErrorBody: " + e.getMessage());
                    }

                }
            }

            @Override
            public void onFailure(Call<ArrayList<Post>> call, Throwable t) {
                // it gets called when -> Network Error
                // it gets called when -> TimeOut Exception -> Laggy Network

                Log.e(TAG, "onFailure: " + t.getMessage());

            }
        });*/

        /*-----------------------------------------------------------  Dedicated ApiManager Class--------------------------------------------*/
/*
        WebService mService = new ApiManager().getMyService();

        mService.getPosts().enqueue(new Callback<ArrayList<Post>>() {
            @Override
            public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
                if (response.isSuccessful()) {
                    // status code 200

                    ArrayList<Post> posts = new ArrayList<>();

                    // getting the response body "Out expected model" -> ArrayList<Post>
                    posts = response.body();


                    // print the body
                    for (Post post : posts) {
                        Log.e(TAG, "onResponse: Posts " + post.getBody());
                    }


                } else {
                    // status is not between 200 and 299
                    // say 404 for example
                    // server has responded but with error status code
                    try {
                        String error = response.errorBody().string();
                        Log.e(TAG, "onErrorBody: " + error);
                    } catch (Exception e) {
                        Log.e(TAG, "onErrorBody: " + e.getMessage());
                    }

                }
            }

            @Override
            public void onFailure(Call<ArrayList<Post>> call, Throwable t) {

            }
        });

        mService.getComments().enqueue(new Callback<ArrayList<CommentResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<CommentResponse>> call, Response<ArrayList<CommentResponse>> response) {
                if (response.isSuccessful()) {
                    // status code 200

                    ArrayList<CommentResponse> comments = new ArrayList<>();

                    // getting the response body "Out expected model" -> ArrayList<Post>
                    comments = response.body();


                    // print the body
                    for (CommentResponse comment : comments) {
                        Log.e(TAG, "onResponse: Comments " + comment.getBody());
                    }


                } else {
                    // status is not between 200 and 299
                    // say 404 for example
                    // server has responded but with error status code
                    try {
                        String error = response.errorBody().string();
                        Log.e(TAG, "onErrorBody: " + error);
                    } catch (Exception e) {
                        Log.e(TAG, "onErrorBody: " + e.getMessage());
                    }

                }
            }

            @Override
            public void onFailure(Call<ArrayList<CommentResponse>> call, Throwable t) {

            }
        });

*/


        /*------------------------------------------------------------------------------- More Clean Code with Repository Pattern ------------------------------------------- */
/*
        WebService mService = new ApiManager().getMyService();


        JavaActivityRepository repository = new JavaActivityRepository(mService);


        repository.getPostsWithCallBack(new PostsCallBack() {
            @Override
            public void onSuccess(ArrayList<Post> posts) {

                Log.e(TAG, "onSuccess: " + posts.toString());
            }

            @Override
            public void onError(String errorMessage) {
                Log.e(TAG, "onError: " + errorMessage);
            }
        });
*/

        /*------------------------------------------------------------------------------- More and more Clean Code with Repository Pattern ------------------------------------------- */



        JavaActivityRepository repository = new JavaActivityRepository();


        repository.getPostsWithCallBack(new PostsCallBack() {
            @Override
            public void onSuccess(ArrayList<Post> posts) {

                Log.e(TAG, "onSuccess: " + posts.toString());
            }

            @Override
            public void onError(String errorMessage) {
                Log.e(TAG, "onError: " + errorMessage);
            }
        });

    }

}