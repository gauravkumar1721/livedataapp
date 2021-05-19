package com.example.myappliv

import android.os.Parcel
import android.os.Parcelable
import android.telecom.Call
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import okhttp3.Response
import javax.security.auth.callback.Callback

class MainActivityViewModel() : ViewModel() {
    var recyclerListData: MutableLiveData<RecyclerList> = MutableLiveData()
    var recyclerViewAdapter : RecyclerViewAdapter = RecyclerViewAdapter()

    fun getAdapter():  RecyclerViewAdapter{
        return recyclerViewAdapter
    }

    fun setAdapterData(data: ArrayList<RecyclerList.RecyclerData>) {
        recyclerViewAdapter.setDataList(data)
        recyclerViewAdapter.notifyDataSetChanged()
    }

    fun getRecyclerListDataObserver(): MutableLiveData<RecyclerList> {
        return recyclerListData
    }

    fun makeAPICall(input : String) {
        val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
        val call = retroInstance.getDataFromAPI(input)
        val enqueue = call.enqueue(object : Callback<RecyclerList> {
            fun onFailure(call: Call<RecyclerList>, t: Throwable) {
                recyclerListData.postValue(null)
            }

            fun onResponse(call: Call<RecyclerList>, response: Response<RecyclerList>) {
                if (response.isSuccessful) {
                    recyclerListData.postValue(response.body())
                } else {
                    recyclerListData.postValue(null)
                }
            }
        })
    }

}

class RecyclerViewAdapter {
    class MyViewHolder {

    }

    fun setDataList(data: java.util.ArrayList<RecyclerList.RecyclerData>) {
        
        
    }

    fun notifyDataSetChanged() {
        
    }

}
