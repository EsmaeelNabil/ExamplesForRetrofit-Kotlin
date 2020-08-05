package com.esmaeel.examples;

import java.util.ArrayList;

interface PostsCallBack {
    void onSuccess(ArrayList<Post> posts);

    void onError(String error);
}
