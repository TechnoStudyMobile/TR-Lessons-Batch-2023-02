package com.example.w9d1_httprequest

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.annotations.SerializedName
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. api'a bağlan
        // 2. bir veri çek / yolla
        // 3. ekrana bastır

        val httpInterceptor = HttpLoggingInterceptor()
        httpInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        // HttpsURLConnection, Volley, Retrofit
        val okhttpClient = OkHttpClient.Builder()
            .addNetworkInterceptor(httpInterceptor)
            .addInterceptor(MyCustomInterceptor())
            .build()


        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okhttpClient)
            .build()


        // RETROFIT(okhttp)
        // okhttp ile de istek atabiliriz.
        // retrofit?
        // retrofit default okhttp
        // custom okhttp dışarıdan verebiliyorum.

        val pokemonService = retrofit.create(PokemonService::class.java)

        // Log.w("")
        pokemonService.getPokemonsFromServer().enqueue(object : Callback<PokemonResponse> {
            override fun onResponse(
                call: Call<PokemonResponse>,
                response: Response<PokemonResponse>
            ) {
                val pokemonList = response.body()?.pokemons
                pokemonList?.forEach {
                    Toast.makeText(this@MainActivity, it.name, Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {

            }
        })
    }
}

// xnakjndfksjdnfk234

interface PokemonService {

    //@Headers("Authorization: xnakjndfksjdnfk234")
    @GET("api/v2/pokemon")
    fun getPokemonsFromServer(): Call<PokemonResponse>

    @GET("api/v2/pokemon")
    fun getPokemonsFromServer2(@Header("Authorization") authorization: String): Call<PokemonResponse>
}

data class PokemonResponse(
    @SerializedName("count") val count: Int?,
    @SerializedName("next") val next: String?,
    @SerializedName("previous") val prev: String?,
    @SerializedName("results") val pokemons: List<Pokemon>?
)

data class Pokemon(
    @SerializedName("name") val name: String?,
    @SerializedName("url") val url: String?
)



























/*
// FPS -> Frame Per Second -> 60
// main/UI thread, background thread

// async programming

async {
    server.connect().onConnectListener {
        progressView.hide()
        showTweets()
    } // 3sn
}

progressView.show()

btn.setOnClickListener {

}

dbx.show()

 */