package vn.eazy.studio.core.base;

import android.app.Application;
import android.content.Context;

import vn.eazy.studio.core.delegate.App;
import vn.eazy.studio.core.delegate.AppDelegate;
import vn.eazy.studio.core.di.component.AppComponent;


/**
 * Created by harryle on 6/17/17.
 */

public class BaseApplication extends Application implements App {
    private AppDelegate mAppDelegate;

    @Override
    public void onCreate() {
        super.onCreate();
        this.mAppDelegate = new AppDelegate(this);
        this.mAppDelegate.onCreate();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
//        MultiDex.install(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        if (mAppDelegate != null) {
            mAppDelegate.onTerminal();
        }
    }

    @Override
    public AppComponent getAppComponent() {
        return mAppDelegate.getAppComponent();
    }
}
