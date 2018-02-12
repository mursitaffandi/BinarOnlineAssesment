package com.mursitaffandi.binaronlineassesment;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.facebook.stetho.Stetho;
import com.google.firebase.auth.FirebaseAuth;
import com.mursitaffandi.binaronlineassesment.view.LoginActivity;

import io.realm.Realm;

/**
 * Created by mursitaffandi on 2/11/18.
 */

public class BaseApp extends Application {
    private static Context mContext;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        Realm.init(mContext);
        Stetho.initializeWithDefaults(this);
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(
                                Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(
                                Stetho.defaultInspectorModulesProvider(this))
                        .build());
    }

    public static Context getContext(){
        return mContext;
    }

    public static void bringToLogin(Context context){
        context.startActivity(new Intent(getContext(), LoginActivity.class));
    }
}
