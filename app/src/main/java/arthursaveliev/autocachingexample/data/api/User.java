package arthursaveliev.autocachingexample.data.api;

import arthursaveliev.autocachingexample.data.caching.Cacheable;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class User extends RealmObject implements Cacheable {


    @PrimaryKey
    private String id;

    private String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean isCacheable() {
        return true;
    }
}
