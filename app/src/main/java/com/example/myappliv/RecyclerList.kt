package com.example.myappliv

import kotlin.TODO as TODO1

class RecyclerList {
    val items: java.util.ArrayList<RecyclerData> = TODO1()
        get() {
            TODO1()
        }

    data class RecyclerList (val items: ArrayList<RecyclerData>)
    data class RecyclerData(val name: String, val description: String, val created_at: String, val owner: Owner)
    data class Owner(val avatar_url: String)
}