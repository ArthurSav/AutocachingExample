package arthursaveliev.autocachingexample.data.api;

import arthursaveliev.autocachingexample.data.caching.CacheListener;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

class ApiManager implements CacheListener {


    private static ApiManager api;
    private Service service;

    private ApiManager() {
        service = createService();
    }

    static Service getInstance() {
        if (api == null) api = new ApiManager();
        return api.service;
    }

    private Service createService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Hosts.DOMAIN)
                .client(new OkHttpClient())
                //.addConverterFactory(GsonConverterFactory.create(builder.create()))
                //.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(Service.class);
    }

    @Override
    public void onCacheRequest() {

    }
}
