package com.esmaeel.examples

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class KotlinActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        MainActivityRepository(ApiManager().myService).getPostsWithCallBack { posts, error ->
            Log.e("KOTLIN-TAG", "OnSuccess: ${posts?.get(0)?.body}")
        }


    }

}