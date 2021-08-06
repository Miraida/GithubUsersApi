package com.geek.githubusersapi.data.remote

import com.geek.githubusersapi.BuildConfig.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    factory { provideApiService(get()) }
    factory { provideOkHttpClient() }
    single { provideRetrofitClient(get()) }
}

fun provideRetrofitClient(okHttpClient: OkHttpClient):Retrofit {
    return Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()
}

fun provideOkHttpClient(): OkHttpClient {
    val interceptor =HttpLoggingInterceptor()
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

    return OkHttpClient()
        .newBuilder()
        .connectTimeout(30,TimeUnit.SECONDS)
        .writeTimeout(30,TimeUnit.SECONDS)
        .readTimeout(30,TimeUnit.SECONDS)
        .addInterceptor(interceptor)
        .build()
}

fun provideApiService(retrofit: Retrofit):ApiService = retrofit.create(ApiService::class.java)
