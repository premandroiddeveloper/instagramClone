package com.example.instagramclone;

import android.app.Application;

import com.parse.Parse;

public class app extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("iuvhfpawFm8hpqWtESGk0FpLIVY1WWrDZ0b9ZUid")
                // if defined
                .clientKey("kGnuDg6XJ8O5ji3busVHbnuuGCM0gxLyR9MUnZTi")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
}
