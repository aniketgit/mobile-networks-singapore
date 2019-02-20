package singapore.mobiledata.com.mobiledatasingapore.webservice;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;

import retrofit2.converter.gson.GsonConverterFactory;


/**
 * This class will initiate the retrofit to perform API related task
 */
public class APIRequestBuilder {

    private static Retrofit mRetrofit = null;

    public static Retrofit apiBuilder() {

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        okhttp3.Response response = chain.proceed(request);

                        if(response.code() == 504) {
                        }
                        return response;
                    }
                }).build();

        if(mRetrofit == null) {
            mRetrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://data.gov.sg/api/action/")
                    .client(client)
                    .build();
        }
        return mRetrofit;
    }


}
