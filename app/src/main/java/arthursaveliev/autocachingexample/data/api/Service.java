package arthursaveliev.autocachingexample.data.api;

import java.util.List;

import retrofit2.adapter.rxjava.Result;
import retrofit2.http.GET;
import rx.Observable;

interface Service {


    @GET("/users")
    Observable<Result<List<User>>> getUsers();
}
