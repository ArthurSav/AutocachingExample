package arthursaveliev.autocachingexample.data.api;

import java.util.List;

import retrofit2.adapter.rxjava.Result;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public final class Api {


    private Api() {
    }

    public static void syncUsers() {
        ApiManager.getInstance()
                .getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(new Func1<Result<List<User>>, Boolean>() {
                    @Override
                    public Boolean call(Result<List<User>> listResult) {
                        return !listResult.isError() && listResult.response().isSuccessful();
                    }
                })
                .map(new Func1<Result<List<User>>, List<User>>() {
                    @Override
                    public List<User> call(Result<List<User>> listResult) {
                        return listResult.response().body();
                    }
                })
                .subscribe();
    }
}
