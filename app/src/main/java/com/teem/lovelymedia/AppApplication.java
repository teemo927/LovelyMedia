package com.teem.lovelymedia;

import android.app.Application;

import com.teem.lovelymedia.model.db.AppDatabaseHelper;

/**
 * @author tangdi
 * @date 2020/05/16
 */
public class AppApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppDatabaseHelper.getInstance().initRoom(this);
    }
}
