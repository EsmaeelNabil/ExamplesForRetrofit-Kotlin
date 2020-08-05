package com.esmaeel.examples

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class MainActivityRepository constructor(val webService: WebService) {


    fun getPostsWithCallBack(callBack: (ArrayList<Post?>?, String?) -> Unit) {
        webService.posts.enqueue(object : Callback<ArrayList<Post?>?> {
            override fun onResponse(
                call: Call<ArrayList<Post?>?>,
                response: Response<ArrayList<Post?>?>
            ) {
                if (response.isSuccessful) {
                    // status code 200
                    val posts = ArrayList<Post>()

                    // getting the response body "Out expected model" -> ArrayList<Post>
                    // return it to the Activity or Fragment (View)
                    callBack(response.body()!!,null)
                } else {
                    // status is not between 200 and 299
                    // say 404 for example
                    // server has responded but with error status code
                    try {
                        val error = response.errorBody()!!.string()
                        callBack(null,error)
                    } catch (e: Exception) {
                        callBack(null,e.message)
                    }
                }
            }

            override fun onFailure(
                call: Call<ArrayList<Post?>?>,
                t: Throwable
            ) {
                callBack(null,t.message)
            }
        })
    }
}