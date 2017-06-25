package vn.eazy.studio.core.example.base;

import android.app.Application;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import com.google.gson.GsonBuilder;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import vn.eazy.studio.core.delegate.AppDelegate;
import vn.eazy.studio.core.di.module.AppModule;
import vn.eazy.studio.core.di.module.ClientModule;
import vn.eazy.studio.core.di.module.GlobalModule;
import vn.eazy.studio.core.intergration.ConfigModule;
import vn.eazy.studio.core.intergration.IRepositoryManager;

/**
 * Created by harryle on 6/25/17.
 */

public class GlobalConfiguration implements ConfigModule {
    private final String TAG = this.getClass().getSimpleName();
    @Override
    public void applyOptions(Context context, GlobalModule.Builder builder) {
        builder.baseUrl("http://github.com");
        builder.retrofitConfiguration(new ClientModule.RetrofitConfiguration() {
            @Override
            public void configRetrofit(Context context, Retrofit.Builder builder) {

            }
        });
        builder.okHttpConfiguration(new ClientModule.OkHttpConfiguration() {
            @Override
            public void configOkHttp(Context context, OkHttpClient.Builder builder) {

            }
        });
        builder.gsonConfiguration(new AppModule.GsonConfiguration() {
            @Override
            public void configGson(Context context, GsonBuilder builder) {

            }
        });
    }

    @Override
    public void registerComponents(Context context, IRepositoryManager repositoryManager) {

    }

    @Override
    public void injectAppLifeCycles(Context context, List<AppDelegate.LifeCycle> lifeCycles) {

        Log.d(TAG,"Inject App Lifecycle");
    }

    @Override
    public void injectActivityLifeCycles(Context context, List<Application.ActivityLifecycleCallbacks> activityLifeCycles) {
        Log.d(TAG,"Inject Activity Lifecycle");
    }

    @Override
    public void injectFragmentLifeCycles(Context context, List<FragmentManager.FragmentLifecycleCallbacks> fragmentLifecycleCallbacks) {

    }
}
