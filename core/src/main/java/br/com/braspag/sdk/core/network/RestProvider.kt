package br.com.braspag.sdk.core.network

import br.com.braspag.sdk.core.BuildConfig
import com.google.gson.GsonBuilder
import okhttp3.Headers
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

open class RestProvider(apiUrl: String) {

    private val gson = GsonBuilder().create()

    private val consoleLogInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().also {
        it.level = HttpLoggingInterceptor.Level.BODY
    }

    private var httpClient: OkHttpClient.Builder = OkHttpClient().newBuilder()

    private var builder: Retrofit.Builder = Retrofit.Builder()
        .baseUrl(apiUrl)
        .addConverterFactory(GsonConverterFactory.create(gson))

    private fun OkHttpClient.Builder.updateInterceptors(
        additionalHeaders: Headers,
        additionalInterceptors: List<Interceptor>? = null
    ) {
        this.apply {
            addInterceptor { chain ->
                val original = chain.request()

                val request = original.newBuilder()
                    .headers(additionalHeaders)
                    .method(original.method(), original.body())
                    .build()

                return@addInterceptor chain.proceed(request)
            }
            addInterceptor(consoleLogInterceptor)

            additionalInterceptors?.forEach { interceptor ->
                addInterceptor(interceptor)
            }
        }
    }

    fun <T> createService(
        service: Class<T>,
        additionalInterceptors: List<Interceptor>? = null
    ): T {

        httpClient.updateInterceptors(
            Headers.of(
                "Braspag-SDK-Version",
                BuildConfig.VERSION_NAME,
                "Accept",
                "application/json"
            ), additionalInterceptors
        )

        val client = httpClient
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

        return builder
            .client(client)
            .build()
            .create(service)
    }


}