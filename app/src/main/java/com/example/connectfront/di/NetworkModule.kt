package com.example.connectfront.di

import com.example.connectfront.BuildConfig
import com.example.data.library.api.ApiService
import com.example.data.library.api.RecommendService
import com.example.data.library.retrofit.NetworkRecommendFactory
import com.example.data.library.retrofit.NetworkRecommendFactoryImpl
import com.example.data.library.retrofit.NetworkRequestFactory
import com.example.data.library.retrofit.NetworkRequestFactoryImpl
import com.example.data.library.retrofit.StringConverterFactory
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import timber.log.Timber
import java.io.IOException
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }


    @Provides
    @Singleton
    fun provideOkHttpClient(
        interceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()
        return builder.build()
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return Gson()
    }

    @Provides
    @Singleton
    @Named("INFO_RETROFIT")
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gson: Gson
    ): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(logBaseUrl(baseUrl = BuildConfig.INFO_RETROFIT_URL))
            .addConverterFactory(StringConverterFactory(gson))
            .build()
    }

    @Provides
    @Singleton
    @Named("RECOMMEND_RETROFIT")
    fun provideRetrofitRecommend(
        okHttpClient: OkHttpClient,
        gson: Gson
    ) : Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(logBaseUrl(baseUrl = BuildConfig.RECOMMEND_RETROFIT_URL))
            .addConverterFactory(StringConverterFactory(gson))
            .build()

    }

    private fun logBaseUrl(baseUrl: String): String {
        Timber.d("baseUrl $baseUrl")
        return baseUrl
    }

    @Provides
    @Singleton
    fun provideApiService(@Named("INFO_RETROFIT")retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)


    @Provides
    @Singleton
    fun provideRecommendService(@Named("RECOMMEND_RETROFIT")retrofit: Retrofit): RecommendService = retrofit.create(RecommendService::class.java)

    @Provides
    @Singleton
    fun bindNetworkRequestFactory(networkRequestFactory: NetworkRequestFactoryImpl): NetworkRequestFactory =
        networkRequestFactory

    @Provides
    @Singleton
    fun bindNetworkRecommendFactory(networkRecommendFactory: NetworkRecommendFactoryImpl) : NetworkRecommendFactory = networkRecommendFactory
}

class HeaderInterceptor constructor(private val token: String) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val token = "Bearer $token"
        val newRequest = chain.request().newBuilder()
            .addHeader("Authorization", token)
            .build()
        return chain.proceed(newRequest)
    }
}